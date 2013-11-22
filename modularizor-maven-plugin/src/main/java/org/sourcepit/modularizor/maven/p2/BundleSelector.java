/**
 * Copyright (c) 2013 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.modularizor.maven.p2;

import java.util.Collection;
import java.util.Stack;

import org.sourcepit.modularizor.core.model.context.BundleCandidate;
import org.sourcepit.modularizor.core.model.context.BundleReference;
import org.sourcepit.modularizor.core.model.context.OsgifyContext;

public interface BundleSelector
{
   BundleSelector ALL = new BundleSelector()
   {
      @Override
      public Collection<BundleCandidate> selectRootBundles(OsgifyContext bundleContext)
      {
         return bundleContext.getBundles();
      }

      @Override
      public boolean select(Stack<BundleCandidate> path, BundleReference reference)
      {
         return true;
      }
   };

   Collection<BundleCandidate> selectRootBundles(OsgifyContext bundleContext);

   boolean select(Stack<BundleCandidate> path, BundleReference reference);
}