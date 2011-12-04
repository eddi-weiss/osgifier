/**
 * Copyright (c) 2011 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.osgify.context;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.sourcepit.osgify.context.ContextModelPackage
 * @generated
 */
public interface ContextModelFactory extends EFactory
{
   /**
    * The singleton instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   ContextModelFactory eINSTANCE = org.sourcepit.osgify.context.impl.ContextModelFactoryImpl.init();

   /**
    * Returns a new object of class '<em>OS Gi Fy Context</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return a new object of class '<em>OS Gi Fy Context</em>'.
    * @generated
    */
   OSGiFyContext createOSGiFyContext();

   /**
    * Returns a new object of class '<em>Bundle Node</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return a new object of class '<em>Bundle Node</em>'.
    * @generated
    */
   BundleNode createBundleNode();

   /**
    * Returns a new object of class '<em>Bundle Reference</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return a new object of class '<em>Bundle Reference</em>'.
    * @generated
    */
   BundleReference createBundleReference();

   /**
    * Returns the package supported by this factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the package supported by this factory.
    * @generated
    */
   ContextModelPackage getContextModelPackage();

} // ContextModelFactory