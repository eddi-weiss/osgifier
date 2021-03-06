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

package org.sourcepit.osgifier.core.model.context;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bundle Localization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.sourcepit.osgifier.core.model.context.BundleLocalization#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sourcepit.osgifier.core.model.context.ContextModelPackage#getBundleLocalization()
 * @model
 * @generated
 */
public interface BundleLocalization extends EObject {
   /**
    * Returns the value of the '<em><b>Data</b></em>' containment reference list.
    * The list contents are of type {@link org.sourcepit.osgifier.core.model.context.LocalizedData}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Data</em>' containment reference list isn't clear, there really should be more of a
    * description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Data</em>' containment reference list.
    * @see org.sourcepit.osgifier.core.model.context.ContextModelPackage#getBundleLocalization_Data()
    * @model containment="true"
    * @generated
    */
   EList<LocalizedData> getData();

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @model localeRequired="true" keyRequired="true"
    * @generated
    */
   void set(String locale, String key, String value);

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @model localeRequired="true" keyRequired="true"
    * @generated
    */
   String get(String locale, String key);

} // BundleLocalization
