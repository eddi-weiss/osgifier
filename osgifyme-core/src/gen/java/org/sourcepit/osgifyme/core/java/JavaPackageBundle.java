/**
 * Copyright (c) 2011 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.osgifyme.core.java;

import org.eclipse.emf.common.util.EList;
import org.sourcepit.modeling.common.Annotatable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Package Bundle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sourcepit.osgifyme.core.java.JavaPackageBundle#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.sourcepit.osgifyme.core.java.JavaPackageBundle#getPackageRoots <em>Package Roots</em>}</li>
 *   <li>{@link org.sourcepit.osgifyme.core.java.JavaPackageBundle#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sourcepit.osgifyme.core.java.JavaModelPackage#getJavaPackageBundle()
 * @model abstract="true"
 * @generated
 */
public interface JavaPackageBundle extends Annotatable
{
   /**
    * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list.
    * The list contents are of type {@link org.sourcepit.osgifyme.core.java.DependencyNode}.
    * It is bidirectional and its opposite is '{@link org.sourcepit.osgifyme.core.java.DependencyNode#getPackageBundle <em>Package Bundle</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Dependencies</em>' containment reference list isn't clear, there really should be more
    * of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Dependencies</em>' containment reference list.
    * @see org.sourcepit.osgifyme.core.java.JavaModelPackage#getJavaPackageBundle_Dependencies()
    * @see org.sourcepit.osgifyme.core.java.DependencyNode#getPackageBundle
    * @model opposite="packageBundle" containment="true"
    * @generated
    */
   EList<DependencyNode> getDependencies();

   /**
    * Returns the value of the '<em><b>Package Roots</b></em>' containment reference list.
    * The list contents are of type {@link org.sourcepit.osgifyme.core.java.JavaPackageRoot}.
    * It is bidirectional and its opposite is '{@link org.sourcepit.osgifyme.core.java.JavaPackageRoot#getPackageBundle <em>Package Bundle</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Package Roots</em>' containment reference list isn't clear, there really should be more
    * of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Package Roots</em>' containment reference list.
    * @see org.sourcepit.osgifyme.core.java.JavaModelPackage#getJavaPackageBundle_PackageRoots()
    * @see org.sourcepit.osgifyme.core.java.JavaPackageRoot#getPackageBundle
    * @model opposite="packageBundle" containment="true"
    * @generated
    */
   EList<JavaPackageRoot> getPackageRoots();

   /**
    * Returns the value of the '<em><b>Version</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Version</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Version</em>' attribute.
    * @see #setVersion(String)
    * @see org.sourcepit.osgifyme.core.java.JavaModelPackage#getJavaPackageBundle_Version()
    * @model
    * @generated
    */
   String getVersion();

   /**
    * Sets the value of the '{@link org.sourcepit.osgifyme.core.java.JavaPackageBundle#getVersion <em>Version</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Version</em>' attribute.
    * @see #getVersion()
    * @generated
    */
   void setVersion(String value);

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @model required="true"
    * @generated
    */
   EList<JavaPackage> getRootPackages(String path);

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @model
    * @generated
    */
   JavaPackage getPackage(String path, String fullyQualifiedName, boolean createOnDemand);

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @model
    * @generated
    */
   JavaType getType(String path, String packageName, String typeName, boolean createOnDemand);

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @model
    * @generated
    */
   JavaPackageRoot getPackageRoot(String path);

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @model
    * @generated
    */
   JavaPackageRoot getPackageRoot(String path, boolean createOnDemand);

} // JavaPackageBundle
