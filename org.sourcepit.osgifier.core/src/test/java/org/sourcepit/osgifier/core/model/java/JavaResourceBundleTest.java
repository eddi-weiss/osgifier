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

package org.sourcepit.osgifier.core.model.java;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.hamcrest.core.IsSame;
import org.junit.Test;
import org.sourcepit.common.modeling.utils.EcoreUtils;
import org.sourcepit.common.modeling.utils.EcoreUtils.RunnableWithEObject;

public class JavaResourceBundleTest {
   @Test
   public void testGetResourceBundle() {
      EcoreUtils.foreachSupertype(JavaModelPackage.eINSTANCE.getJavaResourceBundle(), new RunnableWithEObject() {
         public void run(EObject eObject) {
            testGetResourceBundle((JavaResourceBundle) eObject);
         }
      });
   }

   private void testGetResourceBundle(JavaResourceBundle jBundle) {
      assertThat(jBundle.getResourceBundle(), IsSame.sameInstance(jBundle));
   }

   @Test
   public void testGetResourceRoot() {
      EcoreUtils.foreachSupertype(JavaModelPackage.eINSTANCE.getJavaResourceBundle(), new RunnableWithEObject() {
         public void run(EObject eObject) {
            testGetResourceRoot((JavaResourceBundle) eObject);
         }
      });
   }

   private void testGetResourceRoot(JavaResourceBundle jBundle) {
      try {
         jBundle.getResourcesRoot(null);
         fail();
      }
      catch (IllegalArgumentException e) { // noop
      }

      try {
         jBundle.getResourcesRoot(null, false);
         fail();
      }
      catch (IllegalArgumentException e) { // noop
      }

      assertThat(jBundle.getResourcesRoot("src"), IsNull.nullValue());
      assertThat(jBundle.getResourcesRoot("src", false), IsNull.nullValue());

      JavaResourcesRoot jResources = jBundle.getResourcesRoot("src", true);
      assertThat(jResources, IsNull.notNullValue());
      assertThat(jBundle.getResourcesRoots().size(), Is.is(1));
      assertThat(jBundle.getResourcesRoots().get(0), IsSame.sameInstance(jResources));
      assertThat(jBundle.getResourcesRoot("src"), IsSame.sameInstance(jResources));
      assertThat(jResources.getPackageBundle(), IsSame.sameInstance(jBundle));

      JavaResourcesRoot jResources2 = jBundle.getResourcesRoot("src", true);
      assertThat(jResources2, IsNull.notNullValue());
      assertThat(jBundle.getResourcesRoots().size(), Is.is(1));
      assertThat(jResources, IsSame.sameInstance(jResources2));

      jResources2 = jBundle.getResourcesRoot("test", true);
      assertThat(jResources2, IsNull.notNullValue());
      assertThat(jBundle.getResourcesRoots().size(), Is.is(2));
      assertThat(jBundle.getResourcesRoots().get(0), IsSame.sameInstance(jResources));
      assertThat(jBundle.getResourcesRoots().get(1), IsSame.sameInstance(jResources2));
      assertThat(jBundle.getResourcesRoot("src"), IsSame.sameInstance(jResources));
      assertThat(jBundle.getResourcesRoot("test"), IsSame.sameInstance(jResources2));
      assertThat(jResources, IsNot.not(IsSame.sameInstance(jResources2)));
      assertThat(jResources2.getPackageBundle(), IsSame.sameInstance(jBundle));
   }

   @Test
   public void testGetPackage() {
      EcoreUtils.foreachSupertype(JavaModelPackage.eINSTANCE.getJavaResourceBundle(), new RunnableWithEObject() {
         public void run(EObject eObject) {
            testGetPackage((JavaResourceBundle) eObject);
         }
      });
   }

   private void testGetPackage(JavaResourceBundle jBundle) {
      try {
         jBundle.getPackage(null, null, false);
         fail();
      }
      catch (IllegalArgumentException e) {
      }

      try {
         jBundle.getPackage("", null, false);
         fail();
      }
      catch (IllegalArgumentException e) {
      }

      assertThat(jBundle.getPackage("", "org.sourcepit", false), IsNull.nullValue());
      JavaPackage jPackage = jBundle.getPackage("", "org.sourcepit", true);
      assertThat(jBundle, Is.is(jPackage.getResourceBundle()));

      assertThat((JavaResourcesRoot) jPackage.getParentDirectory().getParentDirectory(),
         IsSame.sameInstance(jBundle.getResourcesRoot("")));
   }

   @Test
   public void testGetType() {
      EcoreUtils.foreachSupertype(JavaModelPackage.eINSTANCE.getJavaResourceBundle(), new RunnableWithEObject() {
         public void run(EObject eObject) {
            testGetType((JavaResourceBundle) eObject);
         }
      });
   }

   private void testGetType(JavaResourceBundle jBundle) {
      try {
         jBundle.getType(null, null, null, false);
         fail();
      }
      catch (IllegalArgumentException e) {
      }

      try {
         jBundle.getType("", null, null, false);
         fail();
      }
      catch (IllegalArgumentException e) {
      }

      try {
         jBundle.getType("", "foo", null, false);
         fail();
      }
      catch (IllegalArgumentException e) {
      }

      assertThat(jBundle.getType("", null, "Foo", false), IsNull.nullValue());

      JavaType jType = jBundle.getType("", null, "Foo", true);
      assertThat(jType, IsNull.notNullValue());

      JavaFile typeRoot = jType.getFile();
      assertThat(typeRoot, IsNull.notNullValue());
      assertThat(typeRoot.getName(), IsEqual.equalTo("Foo"));

      assertThat((JavaResourcesRoot) typeRoot.getParentDirectory(), IsSame.sameInstance(jBundle.getResourcesRoot("")));
   }

   @Test
   public void testResourcesType() {
      EcoreUtils.foreachSupertype(JavaModelPackage.eINSTANCE.getJavaResourceBundle(), new RunnableWithEObject() {
         public void run(EObject eObject) {
            testResourcesType((JavaResourceBundle) eObject);
         }
      });
   }

   private void testResourcesType(JavaResourceBundle jBundle) {
      JavaResourcesRoot src = jBundle.getResourcesRoot("src", true);
      src.setResourcesType(JavaResourcesType.SRC);
      JavaResourcesRoot bin = jBundle.getResourcesRoot("bin", true);
      bin.setResourcesType(JavaResourcesType.BIN);
      assertThat(jBundle.getType("src", "foo", "Bar", true).getFile(),
         IsInstanceOf.instanceOf(JavaCompilationUnit.class));
      assertThat(jBundle.getType("bin", "foo", "Bar", true).getFile(), IsInstanceOf.instanceOf(JavaClass.class));
   }

   @Test
   public void testAccept() {
      EcoreUtils.foreachSupertype(JavaModelPackage.eINSTANCE.getJavaResourceBundle(), new RunnableWithEObject() {
         public void run(EObject eObject) {
            testAccept((JavaResourceBundle) eObject);
         }
      });
   }

   private void testAccept(JavaResourceBundle jBundle) {
      try {
         jBundle.accept(null);
         fail();
      }
      catch (IllegalArgumentException e) {
      }

      JavaResourcesRoot root1 = JavaModelFactory.eINSTANCE.createJavaResourcesRoot();
      JavaResourcesRoot root2 = JavaModelFactory.eINSTANCE.createJavaResourcesRoot();

      final List<Resource> visited = new ArrayList<Resource>();
      jBundle.accept(new ResourceVisitor() {
         public boolean visit(Resource resource) {
            visited.add(resource);
            return true;
         }
      });
      assertThat(visited.isEmpty(), Is.is(true));

      jBundle.getResourcesRoots().add(root1);
      jBundle.getResourcesRoots().add(root2);

      visited.clear();
      jBundle.accept(new ResourceVisitor() {
         public boolean visit(Resource resource) {
            visited.add(resource);
            return true;
         }
      });

      assertThat(visited.size(), Is.is(2));
      assertThat(visited.get(0), IsEqual.equalTo((Resource) root1));
      assertThat(visited.get(1), IsEqual.equalTo((Resource) root2));
   }
}
