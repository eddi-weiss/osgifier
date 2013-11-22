/**
 * Copyright (c) 2012 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.modularizor.java;

import javax.validation.constraints.NotNull;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Bernd Vogt <bernd.vogt@sourcepit.org>
 */
public final class JavaElementOperations
{
   private JavaElementOperations()
   {
      super();
   }

   public static JavaResourceBundle getResourceBundle(@NotNull JavaElement jElement)
   {
      EObject current = jElement;
      while (current != null && !(current instanceof JavaResourceBundle))
      {
         current = current.eContainer();
      }
      return (JavaResourceBundle) current;
   }
}
