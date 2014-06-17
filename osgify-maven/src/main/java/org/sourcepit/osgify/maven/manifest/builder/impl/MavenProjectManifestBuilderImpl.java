/**
 * Copyright (c) 2014 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.osgify.maven.manifest.builder.impl;

import static org.sourcepit.common.utils.props.PropertiesSources.chain;
import static org.sourcepit.common.utils.props.PropertiesSources.toPropertiesSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DefaultArtifact;
import org.sourcepit.common.manifest.Manifest;
import org.sourcepit.common.manifest.merge.ManifestMerger;
import org.sourcepit.common.manifest.osgi.BundleManifest;
import org.sourcepit.common.manifest.util.ManifestUtils;
import org.sourcepit.common.maven.artifact.MavenArtifactUtils;
import org.sourcepit.common.maven.model.MavenArtifact;
import org.sourcepit.common.utils.props.PropertiesSource;
import org.sourcepit.common.utils.props.PropertiesSources;
import org.sourcepit.osgify.core.model.context.BundleCandidate;
import org.sourcepit.osgify.core.model.context.BundleReference;
import org.sourcepit.osgify.core.model.context.ContextModelFactory;
import org.sourcepit.osgify.core.model.context.OsgifyContext;
import org.sourcepit.osgify.core.resolve.VersionRangeResolver;
import org.sourcepit.osgify.maven.DefaultOsgifyContextInflatorFilter;
import org.sourcepit.osgify.maven.OsgifyContextInflator;
import org.sourcepit.osgify.maven.OsgifyContextInflatorFilter;
import org.sourcepit.osgify.maven.manifest.builder.ManifestBuilderResult;
import org.sourcepit.osgify.maven.manifest.builder.MavenProjectManifestBuilder;

import com.google.common.base.Strings;

/**
 * 
 * @author DerGilb
 * @author Bernd
 */
@Named
public class MavenProjectManifestBuilderImpl implements MavenProjectManifestBuilder
{
   public static final String DEF_SOURCE_CLASSIFIER = "sources";

   private final VersionRangeResolver versionRangeResolver;
   private final OsgifyContextInflator inflater;

   private Artifact projectArtifact;
   private List<Artifact> projectDependencies = new ArrayList<Artifact>();
   private Map<?, ?> projectProperties = Collections.emptyMap();
   private Artifact sourceArtifact;
   private String symbolicName;
   private Date timestamp;
   private PropertiesSource additionalOptions = PropertiesSources.emptyPropertiesSource();
   private Manifest mergeManifest;

   private boolean appendExecutionEnvironment = true;

   private boolean appendPackageExports = true;

   private boolean appendPackageImports = true;

   private boolean appendDynamicImports = true;

   @Inject
   public MavenProjectManifestBuilderImpl(VersionRangeResolver versionRangeResolver, OsgifyContextInflator inflater)
   {
      this.versionRangeResolver = versionRangeResolver;
      this.inflater = inflater;
   }

   @Override
   public MavenProjectManifestBuilder project(Artifact project)
   {
      this.projectArtifact = project;
      return this;
   }

   @Override
   public MavenProjectManifestBuilder withProjectProperties(Map<?, ?> properties)
   {
      this.projectProperties = properties;
      return this;
   }

   @Override
   public MavenProjectManifestBuilder withDependency(Artifact dependency)
   {
      this.projectDependencies.add(dependency);
      return this;
   }

   @Override
   public MavenProjectManifestBuilder withDependencies(Collection<Artifact> dependencies)
   {
      this.projectDependencies.addAll(dependencies);
      return this;
   }

   @Override
   public MavenProjectManifestBuilder withSourceArtifact(Artifact sourceArtifact)
   {
      this.sourceArtifact = sourceArtifact;
      return this;
   }

   @Override
   public MavenProjectManifestBuilder withOptions(PropertiesSource options)
   {
      this.additionalOptions = options;
      return this;
   }

   @Override
   public MavenProjectManifestBuilder setSymbolicName(String symbolicName)
   {
      this.symbolicName = symbolicName;
      return this;
   }

   @Override
   public MavenProjectManifestBuilder setTimestamp(Date timestamp)
   {
      this.timestamp = timestamp;
      return this;
   }

   @Override
   public MavenProjectManifestBuilder appendExecutionEnvironment(boolean append)
   {
      appendExecutionEnvironment = append;
      return this;
   }

   @Override
   public MavenProjectManifestBuilder appendPackageExports(boolean append)
   {
      appendPackageExports = append;
      return this;
   }

   @Override
   public MavenProjectManifestBuilder appendPackageImports(boolean append)
   {
      appendPackageImports = append;
      return this;
   }

   @Override
   public MavenProjectManifestBuilder appendDynamicImports(boolean append)
   {
      appendDynamicImports = append;
      return this;
   }

   @Override
   public MavenProjectManifestBuilder mergeWith(java.util.jar.Manifest manifest)
   {
      this.mergeManifest = ManifestUtils.toManifest(manifest);
      return this;
   }

   @Override
   public MavenProjectManifestBuilder mergeWith(Manifest manifest)
   {
      this.mergeManifest = manifest;
      return this;
   }

   @Override
   public ManifestBuilderResult build()
   {
      final OsgifyContext osgifyContext = buildOsgifyContext(projectArtifact, projectDependencies, versionRangeResolver);
      final BundleCandidate projectBundle = osgifyContext.getBundles().get(0);

      final OsgifyContextInflatorFilter inflatorFilter = newInflatorFilter(projectBundle);

      if (this.sourceArtifact != null)
      {
         final MavenArtifact sourceArtifact = MavenArtifactUtils.toMavenArtifact(this.sourceArtifact);

         final BundleCandidate sourceBundle = ContextModelFactory.eINSTANCE.createBundleCandidate();
         sourceBundle.setLocation(sourceArtifact.getFile());
         sourceBundle.addExtension(sourceArtifact);
         sourceBundle.setTargetBundle(projectBundle);
         projectBundle.setSourceBundle(sourceBundle);
         osgifyContext.getBundles().add(sourceBundle);
      }

      final String symbolicName = Strings.isNullOrEmpty(this.symbolicName)
         ? buildSymbolicName(projectArtifact)
         : this.symbolicName;

      final PropertiesSource osgifyOptions = buildOsgifyOptions(projectArtifact, symbolicName, projectProperties,
         additionalOptions);

      final Date startTime = timestamp == null ? new Date() : timestamp;

      inflater.inflate(inflatorFilter, osgifyOptions, osgifyContext, startTime);

      final BundleManifest manifest = projectBundle.getManifest();

      if (mergeManifest != null)
      {
         new ManifestMerger().merge(manifest, mergeManifest);
      }

      final ManifestBuilderResultImpl result = new ManifestBuilderResultImpl(manifest);
      if (this.sourceArtifact != null)
      {
         final BundleCandidate sourceBundle = projectBundle.getSourceBundle();
         final BundleManifest sourceBundleManifest = sourceBundle.getManifest();
         result.setSourceBundleManifest(sourceBundleManifest);
      }

      return result;
   }

   private static String buildSymbolicName(Artifact project)
   {
      return project.getGroupId() + "." + project.getArtifactId();
   }

   private static OsgifyContext buildOsgifyContext(Artifact artifact, Collection<Artifact> dependencies,
      VersionRangeResolver versionRangeResolver)
   {
      final BundleCandidate projectBundle = newBundleCandidate(artifact);

      final OsgifyContext context = ContextModelFactory.eINSTANCE.createOsgifyContext();
      context.getBundles().add(projectBundle);

      for (Artifact dependency : dependencies)
      {
         final BundleReference reference = ContextModelFactory.eINSTANCE.createBundleReference();
         reference.addExtension(MavenArtifactUtils.toMavenDependecy(dependency));
         reference.setOptional(dependency.isOptional());
         reference.setProvided(DefaultArtifact.SCOPE_PROVIDED.equals(dependency.getScope()));
         reference.setVersionRange(versionRangeResolver.resolveVersionRange(reference));

         final BundleCandidate bundle = ContextModelFactory.eINSTANCE.createBundleCandidate();
         bundle.setLocation(dependency.getFile());
         bundle.addExtension(MavenArtifactUtils.toMavenDependecy(dependency));

         reference.setTarget(bundle);
         projectBundle.getDependencies().add(reference);
         context.getBundles().add(bundle);
      }

      return context;
   }

   private OsgifyContextInflatorFilter newInflatorFilter(final BundleCandidate projectBundle)
   {
      final OsgifyContextInflatorFilter inflatorFilter = new DefaultOsgifyContextInflatorFilter()
      {
         @Override
         public boolean isAppendPackageExports(BundleCandidate bundle, PropertiesSource options)
         {
            if (bundle.equals(projectBundle))
            {
               return appendPackageExports;
            }
            return true;
         }

         @Override
         public boolean isAppendExecutionEnvironment(BundleCandidate bundle, PropertiesSource options)
         {
            if (bundle.equals(projectBundle))
            {
               return appendExecutionEnvironment;
            }
            return false;
         }

         @Override
         public boolean isAppendPackageImports(BundleCandidate bundle, PropertiesSource options)
         {
            if (bundle.equals(projectBundle))
            {
               return appendPackageImports;
            }
            return false;
         }

         @Override
         public boolean isAppendDynamicImports(BundleCandidate bundle, PropertiesSource options)
         {
            if (bundle.equals(projectBundle))
            {
               return appendDynamicImports;
            }
            return false;
         }
      };
      return inflatorFilter;
   }

   private static PropertiesSource buildOsgifyOptions(Artifact artifact, String symbolicName,
      Map<?, ?> projectProperties, PropertiesSource additionalOptions)
   {
      PropertiesSource options = chain(toPropertiesSource(projectProperties), additionalOptions);

      final StringBuilder sb = new StringBuilder();
      sb.append(MavenArtifactUtils.toArtifactKey(artifact));
      sb.append('=');
      sb.append(symbolicName);

      String symbolicNameMappings = options.get("osgifier.symbolicNameMappings");
      if (!Strings.isNullOrEmpty(symbolicNameMappings))
      {
         sb.append(',');
         sb.append(symbolicNameMappings);
      }

      return chain(PropertiesSources.singletonPropertiesSource("osgifier.symbolicNameMappings", sb.toString()), options);
   }

   private static BundleCandidate newBundleCandidate(Artifact artifact)
   {
      final BundleCandidate bundle = ContextModelFactory.eINSTANCE.createBundleCandidate();
      bundle.setLocation(artifact.getFile());
      bundle.addExtension(MavenArtifactUtils.toMavenArtifact(artifact));
      return bundle;
   }

}
