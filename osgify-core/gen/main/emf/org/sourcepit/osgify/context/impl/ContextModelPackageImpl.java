/**
 * Copyright (c) 2011 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.osgify.context.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.sourcepit.common.manifest.ManifestPackage;
import org.sourcepit.common.manifest.osgi.BundleManifestPackage;
import org.sourcepit.modeling.common.CommonModelPackage;
import org.sourcepit.osgify.context.BundleNode;
import org.sourcepit.osgify.context.BundleReference;
import org.sourcepit.osgify.context.ContextModelFactory;
import org.sourcepit.osgify.context.ContextModelPackage;
import org.sourcepit.osgify.context.OsgifyContext;
import org.sourcepit.osgify.java.JavaModelPackage;
import org.sourcepit.osgify.java.impl.JavaModelPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ContextModelPackageImpl extends EPackageImpl implements ContextModelPackage
{
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   private EClass osgifyContextEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   private EClass bundleNodeEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   private EClass bundleReferenceEClass = null;

   /**
    * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
    * EPackage.Registry} by the package
    * package URI value.
    * <p>
    * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
    * performs initialization of the package, or returns the registered package, if one already exists. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see org.eclipse.emf.ecore.EPackage.Registry
    * @see org.sourcepit.osgify.context.ContextModelPackage#eNS_URI
    * @see #init()
    * @generated
    */
   private ContextModelPackageImpl()
   {
      super(eNS_URI, ContextModelFactory.eINSTANCE);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   private static boolean isInited = false;

   /**
    * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
    * 
    * <p>
    * This method is used to initialize {@link ContextModelPackage#eINSTANCE} when that field is accessed. Clients
    * should not invoke it directly. Instead, they should simply access that field to obtain the package. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #eNS_URI
    * @see #createPackageContents()
    * @see #initializePackageContents()
    * @generated
    */
   public static ContextModelPackage init()
   {
      if (isInited)
         return (ContextModelPackage) EPackage.Registry.INSTANCE.getEPackage(ContextModelPackage.eNS_URI);

      // Obtain or create and register package
      ContextModelPackageImpl theContextModelPackage = (ContextModelPackageImpl) (EPackage.Registry.INSTANCE
         .get(eNS_URI) instanceof ContextModelPackageImpl
         ? EPackage.Registry.INSTANCE.get(eNS_URI)
         : new ContextModelPackageImpl());

      isInited = true;

      // Initialize simple dependencies
      CommonModelPackage.eINSTANCE.eClass();
      ManifestPackage.eINSTANCE.eClass();

      // Obtain or create and register interdependencies
      JavaModelPackageImpl theJavaModelPackage = (JavaModelPackageImpl) (EPackage.Registry.INSTANCE
         .getEPackage(JavaModelPackage.eNS_URI) instanceof JavaModelPackageImpl ? EPackage.Registry.INSTANCE
         .getEPackage(JavaModelPackage.eNS_URI) : JavaModelPackage.eINSTANCE);

      // Create package meta-data objects
      theContextModelPackage.createPackageContents();
      theJavaModelPackage.createPackageContents();

      // Initialize created meta-data
      theContextModelPackage.initializePackageContents();
      theJavaModelPackage.initializePackageContents();

      // Mark meta-data to indicate it can't be changed
      theContextModelPackage.freeze();


      // Update the registry and return the package
      EPackage.Registry.INSTANCE.put(ContextModelPackage.eNS_URI, theContextModelPackage);
      return theContextModelPackage;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EClass getOsgifyContext()
   {
      return osgifyContextEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getOsgifyContext_Bundles()
   {
      return (EReference) osgifyContextEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EClass getBundleNode()
   {
      return bundleNodeEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getBundleNode_Content()
   {
      return (EReference) bundleNodeEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getBundleNode_Dependencies()
   {
      return (EReference) bundleNodeEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getBundleNode_Version()
   {
      return (EAttribute) bundleNodeEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getBundleNode_SymbolicName()
   {
      return (EAttribute) bundleNodeEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EClass getBundleReference()
   {
      return bundleReferenceEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getBundleReference_VersionRange()
   {
      return (EAttribute) bundleReferenceEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getBundleReference_Optional()
   {
      return (EAttribute) bundleReferenceEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getBundleReference_Target()
   {
      return (EReference) bundleReferenceEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getBundleReference_Provided()
   {
      return (EAttribute) bundleReferenceEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public ContextModelFactory getContextModelFactory()
   {
      return (ContextModelFactory) getEFactoryInstance();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   private boolean isCreated = false;

   /**
    * Creates the meta-model objects for the package. This method is
    * guarded to have no affect on any invocation but its first.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public void createPackageContents()
   {
      if (isCreated)
         return;
      isCreated = true;

      // Create classes and their features
      osgifyContextEClass = createEClass(OSGIFY_CONTEXT);
      createEReference(osgifyContextEClass, OSGIFY_CONTEXT__BUNDLES);

      bundleNodeEClass = createEClass(BUNDLE_NODE);
      createEReference(bundleNodeEClass, BUNDLE_NODE__CONTENT);
      createEReference(bundleNodeEClass, BUNDLE_NODE__DEPENDENCIES);
      createEAttribute(bundleNodeEClass, BUNDLE_NODE__VERSION);
      createEAttribute(bundleNodeEClass, BUNDLE_NODE__SYMBOLIC_NAME);

      bundleReferenceEClass = createEClass(BUNDLE_REFERENCE);
      createEAttribute(bundleReferenceEClass, BUNDLE_REFERENCE__VERSION_RANGE);
      createEAttribute(bundleReferenceEClass, BUNDLE_REFERENCE__OPTIONAL);
      createEReference(bundleReferenceEClass, BUNDLE_REFERENCE__TARGET);
      createEAttribute(bundleReferenceEClass, BUNDLE_REFERENCE__PROVIDED);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   private boolean isInitialized = false;

   /**
    * Complete the initialization of the package and its meta-model. This
    * method is guarded to have no affect on any invocation but its first.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public void initializePackageContents()
   {
      if (isInitialized)
         return;
      isInitialized = true;

      // Initialize package
      setName(eNAME);
      setNsPrefix(eNS_PREFIX);
      setNsURI(eNS_URI);

      // Obtain other dependent packages
      CommonModelPackage theCommonModelPackage = (CommonModelPackage) EPackage.Registry.INSTANCE
         .getEPackage(CommonModelPackage.eNS_URI);
      JavaModelPackage theJavaModelPackage = (JavaModelPackage) EPackage.Registry.INSTANCE
         .getEPackage(JavaModelPackage.eNS_URI);
      BundleManifestPackage theBundleManifestPackage = (BundleManifestPackage) EPackage.Registry.INSTANCE
         .getEPackage(BundleManifestPackage.eNS_URI);

      // Create type parameters

      // Set bounds for type parameters

      // Add supertypes to classes
      osgifyContextEClass.getESuperTypes().add(theCommonModelPackage.getExtendable());
      bundleNodeEClass.getESuperTypes().add(theCommonModelPackage.getExtendable());
      bundleReferenceEClass.getESuperTypes().add(theCommonModelPackage.getExtendable());

      // Initialize classes and features; add operations and parameters
      initEClass(osgifyContextEClass, OsgifyContext.class, "OsgifyContext", !IS_ABSTRACT, !IS_INTERFACE,
         IS_GENERATED_INSTANCE_CLASS);
      initEReference(getOsgifyContext_Bundles(), this.getBundleNode(), null, "bundles", null, 0, -1,
         OsgifyContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
         !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(bundleNodeEClass, BundleNode.class, "BundleNode", !IS_ABSTRACT, !IS_INTERFACE,
         IS_GENERATED_INSTANCE_CLASS);
      initEReference(getBundleNode_Content(), theJavaModelPackage.getJavaPackageBundle(), null, "content", null, 1, 1,
         BundleNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
         !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getBundleNode_Dependencies(), this.getBundleReference(), null, "dependencies", null, 0, -1,
         BundleNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
         !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getBundleNode_Version(), theBundleManifestPackage.getVersion(), "version", null, 0, 1,
         BundleNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
         IS_ORDERED);
      initEAttribute(getBundleNode_SymbolicName(), ecorePackage.getEString(), "symbolicName", null, 0, 1,
         BundleNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
         IS_ORDERED);

      initEClass(bundleReferenceEClass, BundleReference.class, "BundleReference", !IS_ABSTRACT, !IS_INTERFACE,
         IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getBundleReference_VersionRange(), theBundleManifestPackage.getVersionRange(), "versionRange",
         null, 0, 1, BundleReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
         IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getBundleReference_Optional(), ecorePackage.getEBoolean(), "optional", null, 0, 1,
         BundleReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
         !IS_DERIVED, IS_ORDERED);
      initEReference(getBundleReference_Target(), this.getBundleNode(), null, "target", null, 0, 1,
         BundleReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
         !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getBundleReference_Provided(), ecorePackage.getEBoolean(), "provided", null, 0, 1,
         BundleReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
         !IS_DERIVED, IS_ORDERED);

      // Create resource
      createResource(eNS_URI);
   }

} // ContextModelPackageImpl