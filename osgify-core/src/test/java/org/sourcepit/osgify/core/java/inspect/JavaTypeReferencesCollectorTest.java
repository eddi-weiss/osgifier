/**
 * Copyright (c) 2011 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.osgify.core.java.inspect;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.util.ClassLoaderRepository;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.sourcepit.osgify.test.resources.TypeA;

/**
 * @author Bernd
 */
public class JavaTypeReferencesCollectorTest
{
   @Test
   public void test() throws Exception
   {
      try
      {
         JavaTypeReferencesCollector.collect(null);
         fail();
      }
      catch (ConstraintViolationException e)
      { // expected
      }

      final File jarFile = new File("target/testResources/osgify-core.jar");
      assertTrue(jarFile.exists());

      final ClassLoaderRepository classRepo = new ClassLoaderRepository(new URLClassLoader(
         new URL[] { jarFile.toURL() }));

      JavaClass jClass = classRepo.loadClass(TypeA.class.getName());

      Set<String> typeRefs = JavaTypeReferencesCollector.collect(jClass);
      assertThat(typeRefs.size(), Is.is(3));

      Set<String> expectedRefs = new HashSet<String>();
      expectedRefs.add("java.lang.Object");
      expectedRefs.add("java.lang.String");
      expectedRefs.add("java.lang.Boolean");

      assertThat(typeRefs, IsEqual.equalTo(expectedRefs));

      jClass = classRepo.loadClass(TypeA.Hans.class.getName());

      typeRefs = JavaTypeReferencesCollector.collect(jClass);
      assertThat(typeRefs.size(), Is.is(10));

      expectedRefs = new HashSet<String>();

      expectedRefs.add("java.util.Map");
      expectedRefs.add("java.lang.Short");
      expectedRefs.add("java.lang.Boolean");
      expectedRefs.add("org.hamcrest.Matcher");
      expectedRefs.add("org.hamcrest.BaseMatcher");
      expectedRefs.add("java.lang.Object");
      expectedRefs.add("java.lang.Long");
      expectedRefs.add("java.util.HashMap");
      expectedRefs.add("java.lang.Runnable");
      expectedRefs.add("java.lang.Integer");

      assertThat(typeRefs, IsEqual.equalTo(expectedRefs));
   }
}
