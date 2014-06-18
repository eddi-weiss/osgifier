/**
 * Copyright (c) 2013 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.osgifier.maven;

import static org.sourcepit.common.utils.lang.Exceptions.pipe;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.DependencyResolutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.ProjectBuildingException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.sourcepit.common.maven.model.MavenArtifact;
import org.sourcepit.common.utils.props.PropertiesSource;
import org.sourcepit.maven.dependency.model.ArtifactAttachmentFactory;
import org.sourcepit.maven.dependency.model.DependencyModel;
import org.sourcepit.maven.dependency.model.DependencyModelResolver;
import org.sourcepit.maven.dependency.model.DependencyNode;
import org.sourcepit.maven.dependency.model.DependencyTree;
import org.sourcepit.maven.dependency.model.JavaSourceAttachmentFactory;
import org.sourcepit.osgifier.core.model.context.OsgifierContext;
import org.sourcepit.osgifier.maven.OsgifierContextInflator;
import org.sourcepit.osgifier.maven.OsgifierContextInflatorFilter;

@Named
public class OsgifierModelBuilder
{
   @Inject
   private Logger log;

   @Inject
   private DependencyModelResolver dependencyModelResolver;

   @Inject
   private OsgifierStubModelCreator stubModelCreator;

   @Inject
   private OsgifierContextInflator inflator;

   public OsgifierContext build(OsgifierContextInflatorFilter filter, PropertiesSource options,
      Collection<Dependency> dependencies, Date timestamp)
   {
      log.info("");
      log.info("Resolving bundle candidates...");
      final DependencyModel dependencyModel = resolve(dependencies);
      final OsgifierContext osgifyModel = createStubModel(dependencyModel);
      log.info("------------------------------------------------------------------------");

      log.info("");

      return build(filter, options, osgifyModel, timestamp);
   }

   public OsgifierContext build(OsgifierContextInflatorFilter filter, PropertiesSource options,
      MavenProject project, Date timestamp)
   {
      log.info("");
      log.info("Resolving bundle candidates...");
      final DependencyModel dependencyModel = resolve(project);
      final OsgifierContext osgifyModel = createStubModel(dependencyModel);
      log.info("------------------------------------------------------------------------");

      log.info("");

      return build(filter, options, osgifyModel, timestamp);
   }

   private OsgifierContext build(final OsgifierContextInflatorFilter filter, PropertiesSource options,
      final OsgifierContext osgifyModel, Date timestamp)
   {
      log.info("Generating OSGi metadata...");
      inflator.inflate(filter, options, osgifyModel, timestamp);
      return osgifyModel;
   }

   private DependencyModel resolve(MavenProject project)
   {
      final DependencyModel dependencyModel;

      final boolean includeSource = true;

      final ArtifactAttachmentFactory attachmentFactory = includeSource ? new JavaSourceAttachmentFactory() : null;

      try
      {
         dependencyModel = dependencyModelResolver.resolve(project, attachmentFactory);
      }
      catch (DependencyResolutionException e)
      {
         throw pipe(e);
      }

      removeUnresolvedArtifacts(dependencyModel);

      return dependencyModel;
   }

   private DependencyModel resolve(Collection<Dependency> dependencies)
   {
      final DependencyModel dependencyModel;

      final boolean includeSource = true;

      final ArtifactAttachmentFactory attachmentFactory = includeSource ? new JavaSourceAttachmentFactory() : null;

      try
      {
         dependencyModel = dependencyModelResolver.resolve(dependencies, attachmentFactory);
      }
      catch (ProjectBuildingException e)
      {
         throw pipe(e);
      }
      catch (DependencyResolutionException e)
      {
         throw pipe(e);
      }

      removeUnresolvedArtifacts(dependencyModel);

      return dependencyModel;
   }

   private static void removeUnresolvedArtifacts(final DependencyModel dependencyModel)
   {
      final Iterator<MavenArtifact> it = dependencyModel.getArtifacts().iterator();
      while (it.hasNext())
      {
         MavenArtifact mavenArtifact = (MavenArtifact) it.next();
         if (mavenArtifact.getFile() == null)
         {
            DependencyTree dependencyTree = dependencyModel.getDependencyTree(mavenArtifact);
            if (dependencyTree != null)
            {
               dependencyTree.setArtifact(null);
            }
            // dependencyModel.getDependencyTrees().remove(dependencyTree);

            for (DependencyTree tree : dependencyModel.getDependencyTrees())
            {
               TreeIterator<EObject> eAllContents = tree.eAllContents();
               while (eAllContents.hasNext())
               {
                  EObject eObject = (EObject) eAllContents.next();
                  if (eObject instanceof DependencyNode)
                  {
                     DependencyNode node = (DependencyNode) eObject;
                     if (node.getArtifact() == mavenArtifact)
                     {
                        node.setArtifact(null);
                        node.setSelected(false);
                     }
                  }
               }
            }

            it.remove();
            System.out.println("Removed " + mavenArtifact.getArtifactKey());
         }
      }
   }

   private OsgifierContext createStubModel(final DependencyModel dependencyModel)
   {
      return stubModelCreator.create(dependencyModel);
   }

}