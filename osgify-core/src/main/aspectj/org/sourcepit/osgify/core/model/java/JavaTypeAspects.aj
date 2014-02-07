/**
 * Copyright (c) 2012 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.osgify.core.model.java;

import org.sourcepit.osgify.core.java.internal.impl.JavaTypeOperations;

/**
 * @author Bernd Vogt <bernd.vogt@sourcepit.org>
 */
public aspect JavaTypeAspects
{
   pointcut getFile(JavaType type) : target(type) && args() && execution(JavaFile JavaType.getFile());

   JavaFile around(JavaType type): getFile(type){
      return JavaTypeOperations.getFile(type);
   }
}