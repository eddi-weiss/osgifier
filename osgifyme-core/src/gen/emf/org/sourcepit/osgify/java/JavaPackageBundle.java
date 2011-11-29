/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */

package org.sourcepit.osgify.java;

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
 * <li>{@link org.sourcepit.osgify.java.JavaPackageBundle#getPackageRoots <em>Package Roots</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.sourcepit.osgify.java.JavaModelPackage#getJavaPackageBundle()
 * @model abstract="true"
 * @generated
 */
public interface JavaPackageBundle extends Annotatable
{
   /**
    * Returns the value of the '<em><b>Package Roots</b></em>' containment reference list.
    * The list contents are of type {@link org.sourcepit.osgify.java.JavaPackageRoot}.
    * It is bidirectional and its opposite is '{@link org.sourcepit.osgify.java.JavaPackageRoot#getPackageBundle
    * <em>Package Bundle</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Package Roots</em>' containment reference list isn't clear, there really should be more
    * of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Package Roots</em>' containment reference list.
    * @see org.sourcepit.osgify.java.JavaModelPackage#getJavaPackageBundle_PackageRoots()
    * @see org.sourcepit.osgify.java.JavaPackageRoot#getPackageBundle
    * @model opposite="packageBundle" containment="true"
    * @generated
    */
   EList<JavaPackageRoot> getPackageRoots();

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @model required="true"
    * @generated
    */
   EList<JavaPackage> getRootPackages(String path);

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @model
    * @generated
    */
   JavaPackage getPackage(String path, String fullyQualifiedName, boolean createOnDemand);

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @model
    * @generated
    */
   JavaType getType(String path, String packageName, String typeName, boolean createOnDemand);

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @model
    * @generated
    */
   JavaPackageRoot getPackageRoot(String path);

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @model
    * @generated
    */
   JavaPackageRoot getPackageRoot(String path, boolean createOnDemand);

} // JavaPackageBundle
