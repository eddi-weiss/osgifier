/*
 * Copyright 2014 Bernd Vogt and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sourcepit.osgifier.maven;

import static org.apache.commons.io.FileUtils.copyFile;
import static org.sourcepit.common.utils.lang.Exceptions.pipe;
import static org.sourcepit.osgifier.maven.ArtifactManifestBuilderRequest.chainOptions;
import static org.sourcepit.osgifier.maven.ArtifactManifestBuilderRequest.toOptions;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.maven.RepositoryUtils;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.LegacySupport;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;
import org.eclipse.emf.ecore.EObject;
import org.sourcepit.common.manifest.osgi.BundleManifest;
import org.sourcepit.common.maven.artifact.ArtifactFactory;
import org.sourcepit.common.maven.artifact.MavenArtifactUtils;
import org.sourcepit.common.modeling.Annotation;
import org.sourcepit.common.utils.props.AbstractPropertiesSource;
import org.sourcepit.common.utils.props.PropertiesSource;
import org.sourcepit.common.utils.props.PropertiesSources;
import org.sourcepit.osgifier.core.headermod.HeaderModifications;
import org.sourcepit.osgifier.core.model.context.BundleCandidate;
import org.sourcepit.osgifier.maven.ArtifactManifestBuilder;
import org.sourcepit.osgifier.maven.ArtifactManifestBuilderRequest;
import org.sourcepit.osgifier.maven.ArtifactManifestBuilderResult;

/**
 * The goal <i>generate-manifest</i> can be used to generate OSGi manifest files for Java projects.<br>
 * <br>
 * <b>Note:</b> This goal considers the dependency information of this project to determine proper OSGi requirements.
 * For that the dependency artifacts musn't be OSGi bundles for themselves but it is highly recommended.
 * 
 * @author Bernd Vogt <bernd.vogt@sourcepit.org>
 */
@Mojo(name = "generate-manifest", requiresProject = true, requiresDependencyResolution = ResolutionScope.COMPILE_PLUS_RUNTIME, defaultPhase = LifecyclePhase.PROCESS_CLASSES)
public class GenerateManifestMojo extends AbstractOsgifierMojo
{
   /**
    * Mapping between option name and value. These options will be passed to the OSGifier and are intended to customize
    * the OSGifiers default behavior to your needs.<br>
    * </br>
    * 
    * <pre>
    * &lt;options&gt;
    *   &lt;symbolicNameMappings&gt;
    *     xalan:xalan:jar=org.apache.xalan,
    *     stax:stax-api:jar=javax.xml.stream,
    *   &lt;/symbolicNameMappings&gt;
    *   &lt;overrideNativeBundles&gt;
    *     slf4j.api
    *   &lt;/overrideNativeBundles&gt;
    * &lt;/options&gt;
    * </pre>
    */
   @Parameter(required = false)
   private Map<String, String> options;

   /**
    * <code>Bundle-SymbolicName</code> header value for this project.
    */
   @Parameter(required = false, defaultValue = "${project.artifactId}")
   private String symbolicName;

   /**
    * Output file for the generated OSGi manifest.
    */
   @Parameter(defaultValue = "${project.build.directory}/${project.build.finalName}.MF")
   private File manifestFile;

   /**
    * Output file for the generated Eclipse compatible manifest file for the source artifact related to this project.
    */
   @Parameter(defaultValue = "${project.build.directory}/${project.build.finalName}-sources.MF")
   private File sourceManifestFile;

   /**
    * Classifier that is used for the internal source artifact stub (used when an Eclipse compatible
    * <code>MANIFEST.MF</code> file should be generated).
    */
   @Parameter(property = "maven.source.classifier", defaultValue = "sources")
   private String sourceClassifier;

   /**
    * Whether an Eclipse compatible <code>MANIFEST.MF</code> file for the source artifacts should be generated or not.
    */
   @Parameter(property = "source.skip", defaultValue = "false")
   private boolean skipSource;

   /**
    * With header modifications you can customize the generated <code>MANIFEST.MF</code> file. You can remove or add
    * headers.<br>
    * <br>
    * 
    * <pre>
    * &lt;headerModifications&gt;
    *   &lt;headers&gt;
    *     &lt;header&gt;
    *       &lt;name&gt;Bundle-Vendor&lt;/name&gt;
    *       &lt;value&gt;Sourcepit.org&lt;/value&gt;
    *       &lt;after&gt;Bundle-SymbolicName&lt;/after&gt;
    *     &lt;/header&gt;
    *     &lt;header&gt;
    *       &lt;name&gt;Bundle-Name&lt;/name&gt;
    *       &lt;value&gt;${project.name}&lt;/value&gt;
    *       &lt;before&gt;Bundle-Vendor&lt;/before&gt;
    *     &lt;/header&gt;
    *   &lt;/headers&gt;
    *   &lt;removals&gt;
    *     &lt;name&gt;Ant-Version&lt;name&gt;
    *     &lt;name&gt;Created-By&lt;name&gt;
    *   &lt;/removals&gt;
    * &lt;/headerModifications&gt;
    * </pre>
    */
   @Parameter(required = false)
   private HeaderModifications headerModifications;

   /**
    * When set to <code>true</code>, the generated <code>MANIFEST.MF</code> will also be copied to
    * <code>${project.basedir}/META-INF/MANIFEST.MF</code>.
    */
   @Parameter(defaultValue = "false")
   private boolean pde;

   @Inject
   private LegacySupport buildContext;

   @Inject
   private ArtifactFactory artifactFactory;

   @Inject
   private ArtifactManifestBuilder manifestBuilder;

   @Override
   protected void doExecute() throws MojoExecutionException, MojoFailureException
   {
      final MavenProject project = buildContext.getSession().getCurrentProject();

      final ArtifactManifestBuilderRequest request = newManifestRequest(project);

      final ArtifactManifestBuilderResult result = manifestBuilder.buildManifest(request);

      final BundleManifest manifest = result.getBundleManifest();

      final BundleCandidate bundle = (BundleCandidate) manifest.eContainer();

      project.setContextValue("osgifier.Bundle-Localization", getBundleLocalization(bundle));

      ModelUtils.writeModel(manifestFile, manifest);
      project.setContextValue("osgifier.manifestFile", manifestFile);

      if (pde)
      {
         // set as derived
         try
         {
            copyFile(manifestFile, new File(project.getBasedir(), "META-INF/MANIFEST.MF"));
         }
         catch (IOException e)
         {
            throw pipe(e);
         }
      }

      final BundleManifest sourceManifest = result.getSourceBundleManifest();
      if (sourceManifest != null)
      {
         ModelUtils.writeModel(sourceManifestFile, sourceManifest);
         project.setContextValue("osgifier.sourceManifestFile", sourceManifestFile);
      }
   }

   public static Map<String, Map> getBundleLocalization(final BundleCandidate bundle)
   {
      final Map<String, Map> foo = new LinkedHashMap<String, Map>();

      final Annotation localization = bundle.getAnnotation("Bundle-Localization");
      if (localization != null)
      {
         for (Annotation nl : localization.getAnnotations())
         {
            final String name = nl.getSource();
            foo.put(name, nl.getData().map());
         }
      }
      return foo;
   }

   private ArtifactManifestBuilderRequest newManifestRequest(final MavenProject project)
   {
      final ArtifactManifestBuilderRequest request = new ArtifactManifestBuilderRequest();
      request.setArtifact(project.getArtifact());
      if (!skipSource)
      {
         request.setSourceArtifact(newProjectArtifact(project, sourceClassifier, "jar"));
      }
      request.getDependencies().addAll(project.getArtifacts());

      final PropertiesSource options = chainOptions(getMojoConfigurationOptions(), toOptions(project.getProperties()),
         toOptions(System.getProperties()));
      request.setOptions(options);

      request.setSymbolicName(symbolicName);
      request.setTimestamp(buildContext.getSession().getStartTime());
      request.setHeaderModifications(headerModifications);
      return request;
   }

   private PropertiesSource getMojoConfigurationOptions()
   {
      if (options == null)
      {
         return PropertiesSources.emptyPropertiesSource();
      }
      return trimKeyPrefix("osgifier.", PropertiesSources.toPropertiesSource(options));
   }

   private static PropertiesSource trimKeyPrefix(final String prefix, final PropertiesSource propertiesSource)
   {
      return new AbstractPropertiesSource()
      {
         @Override
         public String get(String key)
         {
            if (key.startsWith(prefix))
            {
               return propertiesSource.get(key.substring(9));
            }
            return null;
         }
      };
   }

   private Artifact newProjectArtifact(final MavenProject project, String classifier, String type)
   {
      org.eclipse.aether.artifact.Artifact artifact = artifactFactory.createArtifact(
         RepositoryUtils.toArtifact(project.getArtifact()), classifier, type);

      final String buildDir = project.getBuild().getDirectory();

      final String finalName = project.getBuild().getFinalName();

      final String sourceFinalName = finalName + "-" + artifact.getClassifier();

      final File file = new File(buildDir + "/" + sourceFinalName + "." + artifact.getExtension());

      artifact = artifact.setFile(file);

      return MavenArtifactUtils.toArtifact(artifact);
   }
}
