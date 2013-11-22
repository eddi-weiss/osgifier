/**
 * Copyright (c) 2011 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.modularizor.core.util;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.sourcepit.modularizor.core.inspect.ResourceVisitor;
import org.sourcepit.modularizor.core.util.ZipTraverser;

public class ZipTraverserTest extends AbstractTraverserTest
{
   @Override
   protected void travers(ResourceVisitor visitor)
   {
      File jarFile = new File("target/testResources/modularizor-core.jar");
      assertTrue(jarFile.exists());
      new ZipTraverser(jarFile).travers(visitor);
   }
}