/**
 * Copyright (c) 2011 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.osgify.maven.context;

import org.codehaus.plexus.component.annotations.Component;
import org.sourcepit.common.maven.model.MavenArtifact;
import org.sourcepit.common.utils.priority.Priority;
import org.sourcepit.osgify.core.model.context.BundleCandidate;
import org.sourcepit.osgify.core.resolve.AbstractSymbolicNameResolutionStrategy;

/**
 * @author Bernd
 */
@Component(role = AbstractSymbolicNameResolutionStrategy.class, hint = "UseArtifactId")
public class UseArtifactId extends AbstractSymbolicNameResolutionStrategy
{
   public Priority getPriority()
   {
      return Priority.LOW;
   }

   @Override
   public String resolveSymbolicName(BundleCandidate bundleCandidate)
   {
      final MavenArtifact mavenArtifact = bundleCandidate.getExtension(MavenArtifact.class);
      if (mavenArtifact != null)
      {
         final String artifactId = mavenArtifact.getArtifactId();
         if (artifactId != null)
         {
            return artifactId;
         }
      }
      return null;
   }
}
