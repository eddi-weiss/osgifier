/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */

package org.sourcepit.osgify.java;

import org.sourcepit.modeling.common.Annotatable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Declaration</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.sourcepit.osgify.java.ImportDeclaration#getCompilationUnit <em>Compilation Unit</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.sourcepit.osgify.java.JavaModelPackage#getImportDeclaration()
 * @model
 * @generated
 */
public interface ImportDeclaration extends Annotatable
{
   /**
    * Returns the value of the '<em><b>Compilation Unit</b></em>' container reference.
    * It is bidirectional and its opposite is '
    * {@link org.sourcepit.osgify.java.JavaCompilationUnit#getImportDeclarations <em>Import Declarations</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Compilation Unit</em>' container reference isn't clear, there really should be more of
    * a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Compilation Unit</em>' container reference.
    * @see #setCompilationUnit(JavaCompilationUnit)
    * @see org.sourcepit.osgify.java.JavaModelPackage#getImportDeclaration_CompilationUnit()
    * @see org.sourcepit.osgify.java.JavaCompilationUnit#getImportDeclarations
    * @model opposite="importDeclarations" required="true"
    * @generated
    */
   JavaCompilationUnit getCompilationUnit();

   /**
    * Sets the value of the '{@link org.sourcepit.osgify.java.ImportDeclaration#getCompilationUnit
    * <em>Compilation Unit</em>}' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @param value the new value of the '<em>Compilation Unit</em>' container reference.
    * @see #getCompilationUnit()
    * @generated
    */
   void setCompilationUnit(JavaCompilationUnit value);

} // ImportDeclaration
