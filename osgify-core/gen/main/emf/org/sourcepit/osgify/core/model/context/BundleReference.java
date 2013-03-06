/**
 * Copyright (c) 2011 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.osgify.core.model.context;

import org.sourcepit.common.manifest.osgi.VersionRange;
import org.sourcepit.common.modeling.XAnnotatable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bundle Reference</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.sourcepit.osgify.core.model.context.BundleReference#getVersionRange <em>Version Range</em>}</li>
 * <li>{@link org.sourcepit.osgify.core.model.context.BundleReference#isOptional <em>Optional</em>}</li>
 * <li>{@link org.sourcepit.osgify.core.model.context.BundleReference#getTarget <em>Target</em>}</li>
 * <li>{@link org.sourcepit.osgify.core.model.context.BundleReference#isProvided <em>Provided</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.sourcepit.osgify.core.model.context.ContextModelPackage#getBundleReference()
 * @model
 * @generated
 */
public interface BundleReference extends XAnnotatable
{
   /**
    * Returns the value of the '<em><b>Version Range</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Version Range</em>' attribute isn't clear, there really should be more of a description
    * here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Version Range</em>' attribute.
    * @see #setVersionRange(VersionRange)
    * @see org.sourcepit.osgify.core.model.context.ContextModelPackage#getBundleReference_VersionRange()
    * @model dataType="org.sourcepit.common.manifest.osgi.VersionRange"
    * @generated
    */
   VersionRange getVersionRange();

   /**
    * Sets the value of the '{@link org.sourcepit.osgify.core.model.context.BundleReference#getVersionRange
    * <em>Version Range</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @param value the new value of the '<em>Version Range</em>' attribute.
    * @see #getVersionRange()
    * @generated
    */
   void setVersionRange(VersionRange value);

   /**
    * Returns the value of the '<em><b>Optional</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Optional</em>' attribute isn't clear, there really should be more of a description
    * here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Optional</em>' attribute.
    * @see #setOptional(boolean)
    * @see org.sourcepit.osgify.core.model.context.ContextModelPackage#getBundleReference_Optional()
    * @model
    * @generated
    */
   boolean isOptional();

   /**
    * Sets the value of the '{@link org.sourcepit.osgify.core.model.context.BundleReference#isOptional
    * <em>Optional</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @param value the new value of the '<em>Optional</em>' attribute.
    * @see #isOptional()
    * @generated
    */
   void setOptional(boolean value);

   /**
    * Returns the value of the '<em><b>Target</b></em>' reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Target</em>' reference isn't clear, there really should be more of a description
    * here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Target</em>' reference.
    * @see #setTarget(BundleCandidate)
    * @see org.sourcepit.osgify.core.model.context.ContextModelPackage#getBundleReference_Target()
    * @model
    * @generated
    */
   BundleCandidate getTarget();

   /**
    * Sets the value of the '{@link org.sourcepit.osgify.core.model.context.BundleReference#getTarget <em>Target</em>}'
    * reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @param value the new value of the '<em>Target</em>' reference.
    * @see #getTarget()
    * @generated
    */
   void setTarget(BundleCandidate value);

   /**
    * Returns the value of the '<em><b>Provided</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Provided</em>' attribute isn't clear, there really should be more of a description
    * here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Provided</em>' attribute.
    * @see #setProvided(boolean)
    * @see org.sourcepit.osgify.core.model.context.ContextModelPackage#getBundleReference_Provided()
    * @model
    * @generated
    */
   boolean isProvided();

   /**
    * Sets the value of the '{@link org.sourcepit.osgify.core.model.context.BundleReference#isProvided
    * <em>Provided</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @param value the new value of the '<em>Provided</em>' attribute.
    * @see #isProvided()
    * @generated
    */
   void setProvided(boolean value);

} // BundleReference
