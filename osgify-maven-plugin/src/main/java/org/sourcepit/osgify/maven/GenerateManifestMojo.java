/**
 * Copyright (c) 2014 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.osgify.maven;

import java.io.File;
import java.util.Date;
import java.util.Map;

import javax.inject.Inject;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DefaultArtifact;
import org.apache.maven.plugin.LegacySupport;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;
import org.sourcepit.common.manifest.osgi.BundleManifest;
import org.sourcepit.common.maven.model.util.MavenModelUtils;
import org.sourcepit.common.utils.props.PropertiesSource;
import org.sourcepit.osgify.core.model.context.BundleCandidate;
import org.sourcepit.osgify.core.model.context.BundleReference;
import org.sourcepit.osgify.core.model.context.ContextModelFactory;
import org.sourcepit.osgify.core.model.context.OsgifyContext;
import org.sourcepit.osgify.core.resolve.VersionRangeResolver;

@Mojo(name = "generate-manifest", requiresProject = true, requiresDependencyResolution = ResolutionScope.RUNTIME_PLUS_SYSTEM, defaultPhase = LifecyclePhase.PROCESS_CLASSES)
public class GenerateManifestMojo extends AbstractOsgifyMojo
{
   @Parameter(required = false)
   private Map<String, String> options;

   @Parameter(defaultValue = "${project.build.directory}/osgified")
   private File workDir;

   @Inject
   private LegacySupport buildContext;

   @Inject
   private OsgifyContextInflator inflater;

   @Inject
   private VersionRangeResolver versionRangeResolver;

   @Override
   protected void doExecute() throws MojoExecutionException, MojoFailureException
   {
      final MavenProject project = buildContext.getSession().getCurrentProject();
      final BundleCandidate projectBundle = newBundleCandidate(project);

      final OsgifyContext context = ContextModelFactory.eINSTANCE.createOsgifyContext();
      context.getBundles().add(projectBundle);
      for (Artifact artifact : project.getArtifacts())
      {
         final BundleReference reference = ContextModelFactory.eINSTANCE.createBundleReference();
         reference.addExtension(MavenModelUtils.toMavenDependecy(artifact));
         reference.setOptional(artifact.isOptional());
         reference.setProvided(DefaultArtifact.SCOPE_PROVIDED.equals(artifact.getScope()));
         reference.setVersionRange(versionRangeResolver.resolveVersionRange(reference));

         final BundleCandidate bundle = ContextModelFactory.eINSTANCE.createBundleCandidate();
         bundle.setLocation(artifact.getFile());
         bundle.addExtension(MavenModelUtils.toMavenArtifact(artifact));

         reference.setTarget(bundle);
         projectBundle.getDependencies().add(reference);
         context.getBundles().add(bundle);
      }

      final Date startTime = buildContext.getSession().getStartTime();

      final ManifestGeneratorFilter generatorFilter = new ManifestGeneratorFilter();

      final PropertiesSource options = MojoUtils.getOptions(buildContext.getSession().getCurrentProject()
         .getProperties(), this.options);

      inflater.infalte(generatorFilter, options, context, startTime);

      final BundleManifest manifest = projectBundle.getManifest();

      ModelUtils.writeModel(new File(workDir, "MANIFEST.MF"), manifest);
   }

   private BundleCandidate newBundleCandidate(MavenProject project)
   {
      BundleCandidate bundle = ContextModelFactory.eINSTANCE.createBundleCandidate();
      bundle.setLocation(project.getArtifact().getFile());
      bundle.addExtension(MavenModelUtils.toMavenArtifact(project.getArtifact()));

      // MavenArtifact artifact = MavenModelFactory.eINSTANCE.createMavenArtifact();
      // artifact.setGroupId(project.getGroupId());
      // artifact.setArtifactId(project.getArtifactId());
      // artifact.setVersion(project.getVersion());
      // artifact.setFile(project.getArtifact().getFile());
      //
      // bundle.addExtension(artifact);

      return bundle;
   }

}
