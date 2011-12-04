/**
 * Copyright (c) 2011 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.osgify.core.java.internal.impl;

import org.sourcepit.osgify.java.JavaType;
import org.sourcepit.osgify.java.JavaTypeRoot;

public final class TypeOperations
{
   private TypeOperations()
   {
      super();
   }

   public static JavaTypeRoot getTypeRoot(JavaType type)
   {
      JavaType current = type;
      while (current.getOuterType() != null)
      {
         current = current.getOuterType();
      }
      return (JavaTypeRoot) current.eContainer();
   }
}