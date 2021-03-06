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
import org.junit.Test;
import org.sourcepit.common.modeling.utils.EcoreUtils;
import org.sourcepit.common.modeling.utils.EcoreUtils.RunnableWithEObject;

/**
 * @author Bernd Vogt <bernd.vogt@sourcepit.org>
 */
public class ResourceVisitorTest {

   @Test
   public void testNull() {
      EcoreUtils.foreachSupertype(JavaModelPackage.eINSTANCE.getResource(), new RunnableWithEObject() {
         public void run(EObject eObject) {
            testNull((Resource) eObject);
         }
      });
   }

   private void testNull(Resource resource) {
      try {
         resource.accept(null);
         fail();
      }
      catch (IllegalArgumentException e) {
      }
   }

   @Test
   public void testThis() {
      EcoreUtils.foreachSupertype(JavaModelPackage.eINSTANCE.getResource(), new RunnableWithEObject() {
         public void run(EObject eObject) {
            testThis((Resource) eObject);
         }
      });
   }

   private void testThis(final Resource resource) {
      resource.accept(new ResourceVisitor() {
         public boolean visit(Resource r) {
            assertThat(r, IsEqual.equalTo(resource));
            return false;
         }
      });
   }

   @Test
   public void testDir() {
      EcoreUtils.foreachSupertype(JavaModelPackage.eINSTANCE.getDirectory(), new RunnableWithEObject() {
         public void run(EObject eObject) {
            testDir((Directory) eObject);
         }
      });
   }

   private void testDir(Directory dir) {
      final Directory dir2 = JavaModelFactory.eINSTANCE.createDirectory();
      final File file = JavaModelFactory.eINSTANCE.createFile();
      final File file2 = JavaModelFactory.eINSTANCE.createFile();

      dir.getResources().add(dir2);
      dir.getResources().add(file);
      dir2.getResources().add(file2);

      final List<Resource> visited = new ArrayList<Resource>();
      dir.accept(new ResourceVisitor() {
         public boolean visit(Resource resource) {
            visited.add(resource);
            return false;
         }
      });

      assertThat(visited.size(), Is.is(1));
      assertThat(visited.get(0), IsEqual.equalTo((Resource) dir));

      visited.clear();

      dir.accept(new ResourceVisitor() {
         public boolean visit(Resource resource) {
            visited.add(resource);
            return resource != dir2;
         }
      });

      assertThat(visited.size(), Is.is(3));
      assertThat(visited.get(0), IsEqual.equalTo((Resource) dir));
      assertThat(visited.get(1), IsEqual.equalTo((Resource) dir2));
      assertThat(visited.get(2), IsEqual.equalTo((Resource) file));

      visited.clear();

      dir.accept(new ResourceVisitor() {
         public boolean visit(Resource resource) {
            visited.add(resource);
            return true;
         }
      });

      assertThat(visited.size(), Is.is(4));
      assertThat(visited.get(0), IsEqual.equalTo((Resource) dir));
      assertThat(visited.get(1), IsEqual.equalTo((Resource) dir2));
      assertThat(visited.get(2), IsEqual.equalTo((Resource) file2));
      assertThat(visited.get(3), IsEqual.equalTo((Resource) file));
   }
}
