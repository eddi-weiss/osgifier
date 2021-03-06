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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.sourcepit.osgifier.core.model.java.JavaModelFactory
 * @model kind="package"
 * @generated
 */
public interface JavaModelPackage extends EPackage {
   /**
    * The package name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   String eNAME = "java";

   /**
    * The package namespace URI.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   String eNS_URI = "http://www.sourcepit.org/osgifier/java/0.1";

   /**
    * The package namespace name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   String eNS_PREFIX = "java";

   /**
    * The singleton instance of the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   JavaModelPackage eINSTANCE = org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl.init();

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.Named <em>Named</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.Named
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getNamed()
    * @generated
    */
   int NAMED = 0;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int NAMED__NAME = 0;

   /**
    * The number of structural features of the '<em>Named</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int NAMED_FEATURE_COUNT = 1;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.impl.ResourceImpl <em>Resource</em>}'
    * class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.impl.ResourceImpl
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getResource()
    * @generated
    */
   int RESOURCE = 1;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int RESOURCE__NAME = NAMED__NAME;

   /**
    * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int RESOURCE__EXTENSIONS = NAMED_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int RESOURCE__ANNOTATIONS = NAMED_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Parent Directory</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int RESOURCE__PARENT_DIRECTORY = NAMED_FEATURE_COUNT + 2;

   /**
    * The number of structural features of the '<em>Resource</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int RESOURCE_FEATURE_COUNT = NAMED_FEATURE_COUNT + 3;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.impl.DirectoryImpl <em>Directory</em>}'
    * class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.impl.DirectoryImpl
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getDirectory()
    * @generated
    */
   int DIRECTORY = 2;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int DIRECTORY__NAME = RESOURCE__NAME;

   /**
    * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int DIRECTORY__EXTENSIONS = RESOURCE__EXTENSIONS;

   /**
    * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int DIRECTORY__ANNOTATIONS = RESOURCE__ANNOTATIONS;

   /**
    * The feature id for the '<em><b>Parent Directory</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int DIRECTORY__PARENT_DIRECTORY = RESOURCE__PARENT_DIRECTORY;

   /**
    * The feature id for the '<em><b>Resources</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int DIRECTORY__RESOURCES = RESOURCE_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Directory</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int DIRECTORY_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.impl.FileImpl <em>File</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.impl.FileImpl
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getFile()
    * @generated
    */
   int FILE = 3;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int FILE__NAME = RESOURCE__NAME;

   /**
    * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int FILE__EXTENSIONS = RESOURCE__EXTENSIONS;

   /**
    * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int FILE__ANNOTATIONS = RESOURCE__ANNOTATIONS;

   /**
    * The feature id for the '<em><b>Parent Directory</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int FILE__PARENT_DIRECTORY = RESOURCE__PARENT_DIRECTORY;

   /**
    * The number of structural features of the '<em>File</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int FILE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.JavaElement <em>Java Element</em>}'
    * class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.JavaElement
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaElement()
    * @generated
    */
   int JAVA_ELEMENT = 4;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_ELEMENT__NAME = NAMED__NAME;

   /**
    * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_ELEMENT__EXTENSIONS = NAMED_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_ELEMENT__ANNOTATIONS = NAMED_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>Java Element</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_ELEMENT_FEATURE_COUNT = NAMED_FEATURE_COUNT + 2;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.QualifiedJavaElement
    * <em>Qualified Java Element</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.QualifiedJavaElement
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getQualifiedJavaElement()
    * @generated
    */
   int QUALIFIED_JAVA_ELEMENT = 5;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int QUALIFIED_JAVA_ELEMENT__NAME = JAVA_ELEMENT__NAME;

   /**
    * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int QUALIFIED_JAVA_ELEMENT__EXTENSIONS = JAVA_ELEMENT__EXTENSIONS;

   /**
    * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int QUALIFIED_JAVA_ELEMENT__ANNOTATIONS = JAVA_ELEMENT__ANNOTATIONS;

   /**
    * The number of structural features of the '<em>Qualified Java Element</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int QUALIFIED_JAVA_ELEMENT_FEATURE_COUNT = JAVA_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaResourceBundleImpl
    * <em>Java Resource Bundle</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaResourceBundleImpl
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaResourceBundle()
    * @generated
    */
   int JAVA_RESOURCE_BUNDLE = 6;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCE_BUNDLE__NAME = JAVA_ELEMENT__NAME;

   /**
    * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCE_BUNDLE__EXTENSIONS = JAVA_ELEMENT__EXTENSIONS;

   /**
    * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCE_BUNDLE__ANNOTATIONS = JAVA_ELEMENT__ANNOTATIONS;

   /**
    * The feature id for the '<em><b>Resources Roots</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCE_BUNDLE__RESOURCES_ROOTS = JAVA_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Java Resource Bundle</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCE_BUNDLE_FEATURE_COUNT = JAVA_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaProjectImpl
    * <em>Java Project</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaProjectImpl
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaProject()
    * @generated
    */
   int JAVA_PROJECT = 7;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_PROJECT__NAME = JAVA_RESOURCE_BUNDLE__NAME;

   /**
    * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_PROJECT__EXTENSIONS = JAVA_RESOURCE_BUNDLE__EXTENSIONS;

   /**
    * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_PROJECT__ANNOTATIONS = JAVA_RESOURCE_BUNDLE__ANNOTATIONS;

   /**
    * The feature id for the '<em><b>Resources Roots</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_PROJECT__RESOURCES_ROOTS = JAVA_RESOURCE_BUNDLE__RESOURCES_ROOTS;

   /**
    * The number of structural features of the '<em>Java Project</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_PROJECT_FEATURE_COUNT = JAVA_RESOURCE_BUNDLE_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaArchiveImpl
    * <em>Java Archive</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaArchiveImpl
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaArchive()
    * @generated
    */
   int JAVA_ARCHIVE = 8;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_ARCHIVE__NAME = JAVA_RESOURCE_BUNDLE__NAME;

   /**
    * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_ARCHIVE__EXTENSIONS = JAVA_RESOURCE_BUNDLE__EXTENSIONS;

   /**
    * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_ARCHIVE__ANNOTATIONS = JAVA_RESOURCE_BUNDLE__ANNOTATIONS;

   /**
    * The feature id for the '<em><b>Resources Roots</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_ARCHIVE__RESOURCES_ROOTS = JAVA_RESOURCE_BUNDLE__RESOURCES_ROOTS;

   /**
    * The number of structural features of the '<em>Java Archive</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_ARCHIVE_FEATURE_COUNT = JAVA_RESOURCE_BUNDLE_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.JavaResourceDirectory
    * <em>Java Resource Directory</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.JavaResourceDirectory
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaResourceDirectory()
    * @generated
    */
   int JAVA_RESOURCE_DIRECTORY = 9;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCE_DIRECTORY__NAME = JAVA_ELEMENT__NAME;

   /**
    * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCE_DIRECTORY__EXTENSIONS = JAVA_ELEMENT__EXTENSIONS;

   /**
    * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCE_DIRECTORY__ANNOTATIONS = JAVA_ELEMENT__ANNOTATIONS;

   /**
    * The feature id for the '<em><b>Parent Directory</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCE_DIRECTORY__PARENT_DIRECTORY = JAVA_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Resources</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCE_DIRECTORY__RESOURCES = JAVA_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>Java Resource Directory</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCE_DIRECTORY_FEATURE_COUNT = JAVA_ELEMENT_FEATURE_COUNT + 2;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaResourcesRootImpl
    * <em>Java Resources Root</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaResourcesRootImpl
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaResourcesRoot()
    * @generated
    */
   int JAVA_RESOURCES_ROOT = 10;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCES_ROOT__NAME = JAVA_RESOURCE_DIRECTORY__NAME;

   /**
    * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCES_ROOT__EXTENSIONS = JAVA_RESOURCE_DIRECTORY__EXTENSIONS;

   /**
    * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCES_ROOT__ANNOTATIONS = JAVA_RESOURCE_DIRECTORY__ANNOTATIONS;

   /**
    * The feature id for the '<em><b>Parent Directory</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCES_ROOT__PARENT_DIRECTORY = JAVA_RESOURCE_DIRECTORY__PARENT_DIRECTORY;

   /**
    * The feature id for the '<em><b>Resources</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCES_ROOT__RESOURCES = JAVA_RESOURCE_DIRECTORY__RESOURCES;

   /**
    * The feature id for the '<em><b>Package Bundle</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCES_ROOT__PACKAGE_BUNDLE = JAVA_RESOURCE_DIRECTORY_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Resources Type</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCES_ROOT__RESOURCES_TYPE = JAVA_RESOURCE_DIRECTORY_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>Java Resources Root</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCES_ROOT_FEATURE_COUNT = JAVA_RESOURCE_DIRECTORY_FEATURE_COUNT + 2;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaResourceImpl
    * <em>Java Resource</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaResourceImpl
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaResource()
    * @generated
    */
   int JAVA_RESOURCE = 17;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCE__NAME = RESOURCE__NAME;

   /**
    * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCE__EXTENSIONS = RESOURCE__EXTENSIONS;

   /**
    * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCE__ANNOTATIONS = RESOURCE__ANNOTATIONS;

   /**
    * The feature id for the '<em><b>Parent Directory</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCE__PARENT_DIRECTORY = RESOURCE__PARENT_DIRECTORY;

   /**
    * The number of structural features of the '<em>Java Resource</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaPackageImpl
    * <em>Java Package</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaPackageImpl
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaPackage()
    * @generated
    */
   int JAVA_PACKAGE = 11;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_PACKAGE__NAME = JAVA_RESOURCE__NAME;

   /**
    * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_PACKAGE__EXTENSIONS = JAVA_RESOURCE__EXTENSIONS;

   /**
    * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_PACKAGE__ANNOTATIONS = JAVA_RESOURCE__ANNOTATIONS;

   /**
    * The feature id for the '<em><b>Parent Directory</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_PACKAGE__PARENT_DIRECTORY = JAVA_RESOURCE__PARENT_DIRECTORY;

   /**
    * The feature id for the '<em><b>Resources</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_PACKAGE__RESOURCES = JAVA_RESOURCE_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Java Package</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_PACKAGE_FEATURE_COUNT = JAVA_RESOURCE_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaFileImpl <em>Java File</em>}'
    * class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaFileImpl
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaFile()
    * @generated
    */
   int JAVA_FILE = 12;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_FILE__NAME = JAVA_RESOURCE__NAME;

   /**
    * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_FILE__EXTENSIONS = JAVA_RESOURCE__EXTENSIONS;

   /**
    * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_FILE__ANNOTATIONS = JAVA_RESOURCE__ANNOTATIONS;

   /**
    * The feature id for the '<em><b>Parent Directory</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_FILE__PARENT_DIRECTORY = JAVA_RESOURCE__PARENT_DIRECTORY;

   /**
    * The feature id for the '<em><b>Type</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_FILE__TYPE = JAVA_RESOURCE_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Java File</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_FILE_FEATURE_COUNT = JAVA_RESOURCE_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaClassImpl <em>Java Class</em>}'
    * class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaClassImpl
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaClass()
    * @generated
    */
   int JAVA_CLASS = 13;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_CLASS__NAME = JAVA_FILE__NAME;

   /**
    * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_CLASS__EXTENSIONS = JAVA_FILE__EXTENSIONS;

   /**
    * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_CLASS__ANNOTATIONS = JAVA_FILE__ANNOTATIONS;

   /**
    * The feature id for the '<em><b>Parent Directory</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_CLASS__PARENT_DIRECTORY = JAVA_FILE__PARENT_DIRECTORY;

   /**
    * The feature id for the '<em><b>Type</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_CLASS__TYPE = JAVA_FILE__TYPE;

   /**
    * The feature id for the '<em><b>Major</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_CLASS__MAJOR = JAVA_FILE_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Minor</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_CLASS__MINOR = JAVA_FILE_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>Java Class</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_CLASS_FEATURE_COUNT = JAVA_FILE_FEATURE_COUNT + 2;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaCompilationUnitImpl
    * <em>Java Compilation Unit</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaCompilationUnitImpl
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaCompilationUnit()
    * @generated
    */
   int JAVA_COMPILATION_UNIT = 14;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_COMPILATION_UNIT__NAME = JAVA_FILE__NAME;

   /**
    * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_COMPILATION_UNIT__EXTENSIONS = JAVA_FILE__EXTENSIONS;

   /**
    * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_COMPILATION_UNIT__ANNOTATIONS = JAVA_FILE__ANNOTATIONS;

   /**
    * The feature id for the '<em><b>Parent Directory</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_COMPILATION_UNIT__PARENT_DIRECTORY = JAVA_FILE__PARENT_DIRECTORY;

   /**
    * The feature id for the '<em><b>Type</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_COMPILATION_UNIT__TYPE = JAVA_FILE__TYPE;

   /**
    * The feature id for the '<em><b>Import Declarations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_COMPILATION_UNIT__IMPORT_DECLARATIONS = JAVA_FILE_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Java Compilation Unit</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_COMPILATION_UNIT_FEATURE_COUNT = JAVA_FILE_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.impl.ImportDeclarationImpl
    * <em>Import Declaration</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.impl.ImportDeclarationImpl
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getImportDeclaration()
    * @generated
    */
   int IMPORT_DECLARATION = 15;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int IMPORT_DECLARATION__NAME = JAVA_ELEMENT__NAME;

   /**
    * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int IMPORT_DECLARATION__EXTENSIONS = JAVA_ELEMENT__EXTENSIONS;

   /**
    * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int IMPORT_DECLARATION__ANNOTATIONS = JAVA_ELEMENT__ANNOTATIONS;

   /**
    * The feature id for the '<em><b>Compilation Unit</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int IMPORT_DECLARATION__COMPILATION_UNIT = JAVA_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Import Declaration</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int IMPORT_DECLARATION_FEATURE_COUNT = JAVA_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaTypeImpl <em>Java Type</em>}'
    * class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaTypeImpl
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaType()
    * @generated
    */
   int JAVA_TYPE = 16;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_TYPE__NAME = QUALIFIED_JAVA_ELEMENT__NAME;

   /**
    * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_TYPE__EXTENSIONS = QUALIFIED_JAVA_ELEMENT__EXTENSIONS;

   /**
    * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_TYPE__ANNOTATIONS = QUALIFIED_JAVA_ELEMENT__ANNOTATIONS;

   /**
    * The feature id for the '<em><b>Inner Types</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_TYPE__INNER_TYPES = QUALIFIED_JAVA_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Outer Type</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_TYPE__OUTER_TYPE = QUALIFIED_JAVA_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>Java Type</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int JAVA_TYPE_FEATURE_COUNT = QUALIFIED_JAVA_ELEMENT_FEATURE_COUNT + 2;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.ResourceVisitor
    * <em>Resource Visitor</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.ResourceVisitor
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getResourceVisitor()
    * @generated
    */
   int RESOURCE_VISITOR = 18;

   /**
    * The number of structural features of the '<em>Resource Visitor</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int RESOURCE_VISITOR_FEATURE_COUNT = 0;

   /**
    * The meta object id for the '{@link org.sourcepit.osgifier.core.model.java.JavaResourcesType
    * <em>Java Resources Type</em>}' enum.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.osgifier.core.model.java.JavaResourcesType
    * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaResourcesType()
    * @generated
    */
   int JAVA_RESOURCES_TYPE = 19;


   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.Named <em>Named</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Named</em>'.
    * @see org.sourcepit.osgifier.core.model.java.Named
    * @generated
    */
   EClass getNamed();

   /**
    * Returns the meta object for the attribute '{@link org.sourcepit.osgifier.core.model.java.Named#getName
    * <em>Name</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for the attribute '<em>Name</em>'.
    * @see org.sourcepit.osgifier.core.model.java.Named#getName()
    * @see #getNamed()
    * @generated
    */
   EAttribute getNamed_Name();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.Resource <em>Resource</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Resource</em>'.
    * @see org.sourcepit.osgifier.core.model.java.Resource
    * @generated
    */
   EClass getResource();

   /**
    * Returns the meta object for the container reference '
    * {@link org.sourcepit.osgifier.core.model.java.Resource#getParentDirectory <em>Parent Directory</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for the container reference '<em>Parent Directory</em>'.
    * @see org.sourcepit.osgifier.core.model.java.Resource#getParentDirectory()
    * @see #getResource()
    * @generated
    */
   EReference getResource_ParentDirectory();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.Directory <em>Directory</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Directory</em>'.
    * @see org.sourcepit.osgifier.core.model.java.Directory
    * @generated
    */
   EClass getDirectory();

   /**
    * Returns the meta object for the containment reference list '
    * {@link org.sourcepit.osgifier.core.model.java.Directory#getResources <em>Resources</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for the containment reference list '<em>Resources</em>'.
    * @see org.sourcepit.osgifier.core.model.java.Directory#getResources()
    * @see #getDirectory()
    * @generated
    */
   EReference getDirectory_Resources();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.File <em>File</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>File</em>'.
    * @see org.sourcepit.osgifier.core.model.java.File
    * @generated
    */
   EClass getFile();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.JavaElement
    * <em>Java Element</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Java Element</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaElement
    * @generated
    */
   EClass getJavaElement();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.QualifiedJavaElement
    * <em>Qualified Java Element</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Qualified Java Element</em>'.
    * @see org.sourcepit.osgifier.core.model.java.QualifiedJavaElement
    * @generated
    */
   EClass getQualifiedJavaElement();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.JavaResourceBundle
    * <em>Java Resource Bundle</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Java Resource Bundle</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaResourceBundle
    * @generated
    */
   EClass getJavaResourceBundle();

   /**
    * Returns the meta object for the containment reference list '
    * {@link org.sourcepit.osgifier.core.model.java.JavaResourceBundle#getResourcesRoots <em>Resources Roots</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for the containment reference list '<em>Resources Roots</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaResourceBundle#getResourcesRoots()
    * @see #getJavaResourceBundle()
    * @generated
    */
   EReference getJavaResourceBundle_ResourcesRoots();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.JavaProject
    * <em>Java Project</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Java Project</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaProject
    * @generated
    */
   EClass getJavaProject();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.JavaArchive
    * <em>Java Archive</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Java Archive</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaArchive
    * @generated
    */
   EClass getJavaArchive();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.JavaResourceDirectory
    * <em>Java Resource Directory</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Java Resource Directory</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaResourceDirectory
    * @generated
    */
   EClass getJavaResourceDirectory();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.JavaResourcesRoot
    * <em>Java Resources Root</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Java Resources Root</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaResourcesRoot
    * @generated
    */
   EClass getJavaResourcesRoot();

   /**
    * Returns the meta object for the container reference '
    * {@link org.sourcepit.osgifier.core.model.java.JavaResourcesRoot#getPackageBundle <em>Package Bundle</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for the container reference '<em>Package Bundle</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaResourcesRoot#getPackageBundle()
    * @see #getJavaResourcesRoot()
    * @generated
    */
   EReference getJavaResourcesRoot_PackageBundle();

   /**
    * Returns the meta object for the attribute '
    * {@link org.sourcepit.osgifier.core.model.java.JavaResourcesRoot#getResourcesType <em>Resources Type</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for the attribute '<em>Resources Type</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaResourcesRoot#getResourcesType()
    * @see #getJavaResourcesRoot()
    * @generated
    */
   EAttribute getJavaResourcesRoot_ResourcesType();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.JavaPackage
    * <em>Java Package</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Java Package</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaPackage
    * @generated
    */
   EClass getJavaPackage();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.JavaFile <em>Java File</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Java File</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaFile
    * @generated
    */
   EClass getJavaFile();

   /**
    * Returns the meta object for the containment reference '
    * {@link org.sourcepit.osgifier.core.model.java.JavaFile#getType <em>Type</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for the containment reference '<em>Type</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaFile#getType()
    * @see #getJavaFile()
    * @generated
    */
   EReference getJavaFile_Type();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.JavaClass <em>Java Class</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Java Class</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaClass
    * @generated
    */
   EClass getJavaClass();

   /**
    * Returns the meta object for the attribute '{@link org.sourcepit.osgifier.core.model.java.JavaClass#getMajor
    * <em>Major</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for the attribute '<em>Major</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaClass#getMajor()
    * @see #getJavaClass()
    * @generated
    */
   EAttribute getJavaClass_Major();

   /**
    * Returns the meta object for the attribute '{@link org.sourcepit.osgifier.core.model.java.JavaClass#getMinor
    * <em>Minor</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for the attribute '<em>Minor</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaClass#getMinor()
    * @see #getJavaClass()
    * @generated
    */
   EAttribute getJavaClass_Minor();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.JavaCompilationUnit
    * <em>Java Compilation Unit</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Java Compilation Unit</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaCompilationUnit
    * @generated
    */
   EClass getJavaCompilationUnit();

   /**
    * Returns the meta object for the containment reference list '
    * {@link org.sourcepit.osgifier.core.model.java.JavaCompilationUnit#getImportDeclarations
    * <em>Import Declarations</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for the containment reference list '<em>Import Declarations</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaCompilationUnit#getImportDeclarations()
    * @see #getJavaCompilationUnit()
    * @generated
    */
   EReference getJavaCompilationUnit_ImportDeclarations();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.ImportDeclaration
    * <em>Import Declaration</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Import Declaration</em>'.
    * @see org.sourcepit.osgifier.core.model.java.ImportDeclaration
    * @generated
    */
   EClass getImportDeclaration();

   /**
    * Returns the meta object for the container reference '
    * {@link org.sourcepit.osgifier.core.model.java.ImportDeclaration#getCompilationUnit <em>Compilation Unit</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for the container reference '<em>Compilation Unit</em>'.
    * @see org.sourcepit.osgifier.core.model.java.ImportDeclaration#getCompilationUnit()
    * @see #getImportDeclaration()
    * @generated
    */
   EReference getImportDeclaration_CompilationUnit();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.JavaType <em>Java Type</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Java Type</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaType
    * @generated
    */
   EClass getJavaType();

   /**
    * Returns the meta object for the containment reference list '
    * {@link org.sourcepit.osgifier.core.model.java.JavaType#getInnerTypes <em>Inner Types</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for the containment reference list '<em>Inner Types</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaType#getInnerTypes()
    * @see #getJavaType()
    * @generated
    */
   EReference getJavaType_InnerTypes();

   /**
    * Returns the meta object for the container reference '
    * {@link org.sourcepit.osgifier.core.model.java.JavaType#getOuterType <em>Outer Type</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for the container reference '<em>Outer Type</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaType#getOuterType()
    * @see #getJavaType()
    * @generated
    */
   EReference getJavaType_OuterType();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.JavaResource
    * <em>Java Resource</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Java Resource</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaResource
    * @generated
    */
   EClass getJavaResource();

   /**
    * Returns the meta object for class '{@link org.sourcepit.osgifier.core.model.java.ResourceVisitor
    * <em>Resource Visitor</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Resource Visitor</em>'.
    * @see org.sourcepit.osgifier.core.model.java.ResourceVisitor
    * @model instanceClass="org.sourcepit.osgifier.core.model.java.ResourceVisitor"
    * @generated
    */
   EClass getResourceVisitor();

   /**
    * Returns the meta object for enum '{@link org.sourcepit.osgifier.core.model.java.JavaResourcesType
    * <em>Java Resources Type</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for enum '<em>Java Resources Type</em>'.
    * @see org.sourcepit.osgifier.core.model.java.JavaResourcesType
    * @generated
    */
   EEnum getJavaResourcesType();

   /**
    * Returns the factory that creates the instances of the model.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the factory that creates the instances of the model.
    * @generated
    */
   JavaModelFactory getJavaModelFactory();

   /**
    * <!-- begin-user-doc -->
    * Defines literals for the meta objects that represent
    * <ul>
    * <li>each class,</li>
    * <li>each feature of each class,</li>
    * <li>each enum,</li>
    * <li>and each data type</li>
    * </ul>
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   interface Literals {
      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.Named <em>Named</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.Named
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getNamed()
       * @generated
       */
      EClass NAMED = eINSTANCE.getNamed();

      /**
       * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @generated
       */
      EAttribute NAMED__NAME = eINSTANCE.getNamed_Name();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.impl.ResourceImpl
       * <em>Resource</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.impl.ResourceImpl
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getResource()
       * @generated
       */
      EClass RESOURCE = eINSTANCE.getResource();

      /**
       * The meta object literal for the '<em><b>Parent Directory</b></em>' container reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @generated
       */
      EReference RESOURCE__PARENT_DIRECTORY = eINSTANCE.getResource_ParentDirectory();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.impl.DirectoryImpl
       * <em>Directory</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.impl.DirectoryImpl
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getDirectory()
       * @generated
       */
      EClass DIRECTORY = eINSTANCE.getDirectory();

      /**
       * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @generated
       */
      EReference DIRECTORY__RESOURCES = eINSTANCE.getDirectory_Resources();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.impl.FileImpl <em>File</em>}'
       * class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.impl.FileImpl
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getFile()
       * @generated
       */
      EClass FILE = eINSTANCE.getFile();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.JavaElement
       * <em>Java Element</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.JavaElement
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaElement()
       * @generated
       */
      EClass JAVA_ELEMENT = eINSTANCE.getJavaElement();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.QualifiedJavaElement
       * <em>Qualified Java Element</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.QualifiedJavaElement
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getQualifiedJavaElement()
       * @generated
       */
      EClass QUALIFIED_JAVA_ELEMENT = eINSTANCE.getQualifiedJavaElement();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaResourceBundleImpl
       * <em>Java Resource Bundle</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaResourceBundleImpl
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaResourceBundle()
       * @generated
       */
      EClass JAVA_RESOURCE_BUNDLE = eINSTANCE.getJavaResourceBundle();

      /**
       * The meta object literal for the '<em><b>Resources Roots</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @generated
       */
      EReference JAVA_RESOURCE_BUNDLE__RESOURCES_ROOTS = eINSTANCE.getJavaResourceBundle_ResourcesRoots();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaProjectImpl
       * <em>Java Project</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaProjectImpl
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaProject()
       * @generated
       */
      EClass JAVA_PROJECT = eINSTANCE.getJavaProject();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaArchiveImpl
       * <em>Java Archive</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaArchiveImpl
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaArchive()
       * @generated
       */
      EClass JAVA_ARCHIVE = eINSTANCE.getJavaArchive();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.JavaResourceDirectory
       * <em>Java Resource Directory</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.JavaResourceDirectory
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaResourceDirectory()
       * @generated
       */
      EClass JAVA_RESOURCE_DIRECTORY = eINSTANCE.getJavaResourceDirectory();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaResourcesRootImpl
       * <em>Java Resources Root</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaResourcesRootImpl
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaResourcesRoot()
       * @generated
       */
      EClass JAVA_RESOURCES_ROOT = eINSTANCE.getJavaResourcesRoot();

      /**
       * The meta object literal for the '<em><b>Package Bundle</b></em>' container reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @generated
       */
      EReference JAVA_RESOURCES_ROOT__PACKAGE_BUNDLE = eINSTANCE.getJavaResourcesRoot_PackageBundle();

      /**
       * The meta object literal for the '<em><b>Resources Type</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @generated
       */
      EAttribute JAVA_RESOURCES_ROOT__RESOURCES_TYPE = eINSTANCE.getJavaResourcesRoot_ResourcesType();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaPackageImpl
       * <em>Java Package</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaPackageImpl
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaPackage()
       * @generated
       */
      EClass JAVA_PACKAGE = eINSTANCE.getJavaPackage();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaFileImpl
       * <em>Java File</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaFileImpl
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaFile()
       * @generated
       */
      EClass JAVA_FILE = eINSTANCE.getJavaFile();

      /**
       * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @generated
       */
      EReference JAVA_FILE__TYPE = eINSTANCE.getJavaFile_Type();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaClassImpl
       * <em>Java Class</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaClassImpl
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaClass()
       * @generated
       */
      EClass JAVA_CLASS = eINSTANCE.getJavaClass();

      /**
       * The meta object literal for the '<em><b>Major</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @generated
       */
      EAttribute JAVA_CLASS__MAJOR = eINSTANCE.getJavaClass_Major();

      /**
       * The meta object literal for the '<em><b>Minor</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @generated
       */
      EAttribute JAVA_CLASS__MINOR = eINSTANCE.getJavaClass_Minor();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaCompilationUnitImpl
       * <em>Java Compilation Unit</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaCompilationUnitImpl
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaCompilationUnit()
       * @generated
       */
      EClass JAVA_COMPILATION_UNIT = eINSTANCE.getJavaCompilationUnit();

      /**
       * The meta object literal for the '<em><b>Import Declarations</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @generated
       */
      EReference JAVA_COMPILATION_UNIT__IMPORT_DECLARATIONS = eINSTANCE.getJavaCompilationUnit_ImportDeclarations();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.impl.ImportDeclarationImpl
       * <em>Import Declaration</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.impl.ImportDeclarationImpl
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getImportDeclaration()
       * @generated
       */
      EClass IMPORT_DECLARATION = eINSTANCE.getImportDeclaration();

      /**
       * The meta object literal for the '<em><b>Compilation Unit</b></em>' container reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @generated
       */
      EReference IMPORT_DECLARATION__COMPILATION_UNIT = eINSTANCE.getImportDeclaration_CompilationUnit();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaTypeImpl
       * <em>Java Type</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaTypeImpl
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaType()
       * @generated
       */
      EClass JAVA_TYPE = eINSTANCE.getJavaType();

      /**
       * The meta object literal for the '<em><b>Inner Types</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @generated
       */
      EReference JAVA_TYPE__INNER_TYPES = eINSTANCE.getJavaType_InnerTypes();

      /**
       * The meta object literal for the '<em><b>Outer Type</b></em>' container reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @generated
       */
      EReference JAVA_TYPE__OUTER_TYPE = eINSTANCE.getJavaType_OuterType();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.impl.JavaResourceImpl
       * <em>Java Resource</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaResourceImpl
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaResource()
       * @generated
       */
      EClass JAVA_RESOURCE = eINSTANCE.getJavaResource();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.ResourceVisitor
       * <em>Resource Visitor</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.ResourceVisitor
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getResourceVisitor()
       * @generated
       */
      EClass RESOURCE_VISITOR = eINSTANCE.getResourceVisitor();

      /**
       * The meta object literal for the '{@link org.sourcepit.osgifier.core.model.java.JavaResourcesType
       * <em>Java Resources Type</em>}' enum.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.osgifier.core.model.java.JavaResourcesType
       * @see org.sourcepit.osgifier.core.model.java.impl.JavaModelPackageImpl#getJavaResourcesType()
       * @generated
       */
      EEnum JAVA_RESOURCES_TYPE = eINSTANCE.getJavaResourcesType();

   }

} // JavaModelPackage
