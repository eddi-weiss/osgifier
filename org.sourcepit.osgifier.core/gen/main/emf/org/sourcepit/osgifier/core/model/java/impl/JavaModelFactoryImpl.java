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

package org.sourcepit.osgifier.core.model.java.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.sourcepit.osgifier.core.model.java.Directory;
import org.sourcepit.osgifier.core.model.java.File;
import org.sourcepit.osgifier.core.model.java.ImportDeclaration;
import org.sourcepit.osgifier.core.model.java.JavaArchive;
import org.sourcepit.osgifier.core.model.java.JavaClass;
import org.sourcepit.osgifier.core.model.java.JavaCompilationUnit;
import org.sourcepit.osgifier.core.model.java.JavaModelFactory;
import org.sourcepit.osgifier.core.model.java.JavaModelPackage;
import org.sourcepit.osgifier.core.model.java.JavaPackage;
import org.sourcepit.osgifier.core.model.java.JavaProject;
import org.sourcepit.osgifier.core.model.java.JavaResourcesRoot;
import org.sourcepit.osgifier.core.model.java.JavaResourcesType;
import org.sourcepit.osgifier.core.model.java.JavaType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class JavaModelFactoryImpl extends EFactoryImpl implements JavaModelFactory {
   /**
    * Creates the default factory implementation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public static JavaModelFactory init() {
      try {
         JavaModelFactory theJavaModelFactory = (JavaModelFactory) EPackage.Registry.INSTANCE.getEFactory(JavaModelPackage.eNS_URI);
         if (theJavaModelFactory != null) {
            return theJavaModelFactory;
         }
      }
      catch (Exception exception) {
         EcorePlugin.INSTANCE.log(exception);
      }
      return new JavaModelFactoryImpl();
   }

   /**
    * Creates an instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public JavaModelFactoryImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public EObject create(EClass eClass) {
      switch (eClass.getClassifierID()) {
         case JavaModelPackage.DIRECTORY :
            return createDirectory();
         case JavaModelPackage.FILE :
            return createFile();
         case JavaModelPackage.JAVA_PROJECT :
            return createJavaProject();
         case JavaModelPackage.JAVA_ARCHIVE :
            return createJavaArchive();
         case JavaModelPackage.JAVA_RESOURCES_ROOT :
            return createJavaResourcesRoot();
         case JavaModelPackage.JAVA_PACKAGE :
            return createJavaPackage();
         case JavaModelPackage.JAVA_CLASS :
            return createJavaClass();
         case JavaModelPackage.JAVA_COMPILATION_UNIT :
            return createJavaCompilationUnit();
         case JavaModelPackage.IMPORT_DECLARATION :
            return createImportDeclaration();
         case JavaModelPackage.JAVA_TYPE :
            return createJavaType();
         default :
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public Object createFromString(EDataType eDataType, String initialValue) {
      switch (eDataType.getClassifierID()) {
         case JavaModelPackage.JAVA_RESOURCES_TYPE :
            return createJavaResourcesTypeFromString(eDataType, initialValue);
         default :
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public String convertToString(EDataType eDataType, Object instanceValue) {
      switch (eDataType.getClassifierID()) {
         case JavaModelPackage.JAVA_RESOURCES_TYPE :
            return convertJavaResourcesTypeToString(eDataType, instanceValue);
         default :
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public Directory createDirectory() {
      DirectoryImpl directory = new DirectoryImpl();
      return directory;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public File createFile() {
      FileImpl file = new FileImpl();
      return file;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public JavaProject createJavaProject() {
      JavaProjectImpl javaProject = new JavaProjectImpl();
      return javaProject;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public JavaArchive createJavaArchive() {
      JavaArchiveImpl javaArchive = new JavaArchiveImpl();
      return javaArchive;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public JavaResourcesRoot createJavaResourcesRoot() {
      JavaResourcesRootImpl javaResourcesRoot = new JavaResourcesRootImpl();
      return javaResourcesRoot;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public JavaPackage createJavaPackage() {
      JavaPackageImpl javaPackage = new JavaPackageImpl();
      return javaPackage;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public JavaClass createJavaClass() {
      JavaClassImpl javaClass = new JavaClassImpl();
      return javaClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public JavaCompilationUnit createJavaCompilationUnit() {
      JavaCompilationUnitImpl javaCompilationUnit = new JavaCompilationUnitImpl();
      return javaCompilationUnit;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public ImportDeclaration createImportDeclaration() {
      ImportDeclarationImpl importDeclaration = new ImportDeclarationImpl();
      return importDeclaration;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public JavaType createJavaType() {
      JavaTypeImpl javaType = new JavaTypeImpl();
      return javaType;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public JavaResourcesType createJavaResourcesTypeFromString(EDataType eDataType, String initialValue) {
      JavaResourcesType result = JavaResourcesType.get(initialValue);
      if (result == null)
         throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
            + eDataType.getName() + "'");
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public String convertJavaResourcesTypeToString(EDataType eDataType, Object instanceValue) {
      return instanceValue == null ? null : instanceValue.toString();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public JavaModelPackage getJavaModelPackage() {
      return (JavaModelPackage) getEPackage();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @deprecated
    * @generated
    */
   @Deprecated
   public static JavaModelPackage getPackage() {
      return JavaModelPackage.eINSTANCE;
   }

} // JavaModelFactoryImpl
