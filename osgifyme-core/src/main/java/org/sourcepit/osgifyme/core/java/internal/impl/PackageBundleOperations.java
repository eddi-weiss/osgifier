/**
 * Copyright (c) 2011 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.osgifyme.core.java.internal.impl;

import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.sourcepit.osgifyme.core.java.JavaArchive;
import org.sourcepit.osgifyme.core.java.JavaModelFactory;
import org.sourcepit.osgifyme.core.java.JavaPackage;
import org.sourcepit.osgifyme.core.java.JavaPackageBundle;
import org.sourcepit.osgifyme.core.java.JavaType;
import org.sourcepit.osgifyme.core.java.JavaTypeRoot;

public final class PackageBundleOperations
{
   private PackageBundleOperations()
   {
      super();
   }

   public static JavaType getType(JavaArchive bundle, String packageName, String typeName, boolean createOnDemand)
   {
      return getType(bundle, "", packageName, typeName, createOnDemand);
   }

   public static JavaType getType(JavaPackageBundle bundle, String path, String packageName, String typeName,
      boolean createOnDemand)
   {
      final JavaPackage pkg = getPackage(bundle, path, packageName, createOnDemand);
      if (pkg == null)
      {
         return null;
      }

      final String[] names = typeName.replace('$', '.').split("\\.");

      JavaType type = getType(pkg, names[0], createOnDemand);
      if (type == null)
      {
         return null;
      }

      for (int i = 1; i < names.length; i++)
      {
         type = getType(type.getInnerTypes(), names[i], createOnDemand);
         if (type == null)
         {
            return null;
         }
      }

      return type;
   }

   private static JavaType getType(EList<JavaType> types, String name, boolean createOnDeamand)
   {
      for (JavaType type : types)
      {
         if (name.equals(type.getSimpleName()))
         {
            return type;
         }
      }

      if (createOnDeamand)
      {
         final JavaType type = JavaModelFactory.eINSTANCE.createJavaType();
         type.setSimpleName(name);
         types.add(type);
         return type;
      }

      return null;
   }

   private static JavaType getType(JavaPackage pkg, String name, boolean createOnDeamand)
   {
      for (JavaTypeRoot typeRoot : pkg.getTypeRoots())
      {
         if (name.equals(typeRoot.getType().getSimpleName()))
         {
            return typeRoot.getType();
         }
      }

      if (createOnDeamand)
      {
         final JavaType type = JavaModelFactory.eINSTANCE.createJavaType();
         type.setSimpleName(name);

         final JavaTypeRoot typeRoot = JavaModelFactory.eINSTANCE.createJavaClass();
         typeRoot.setType(type);
         pkg.getTypeRoots().add(typeRoot);
         return type;
      }

      return null;
   }

   public static EList<JavaPackage> getRootPackages(JavaPackageBundle bundle)
   {
      final BasicEList<JavaPackage> pkgs = new BasicEList<JavaPackage>();
      for (Entry<String, EList<JavaPackage>> entry : bundle.getPathToRootPackagesMap())
      {
         final EList<JavaPackage> value = entry.getValue();
         if (value != null)
         {
            pkgs.addAll(value);
         }
      }
      return pkgs;
   }

   public static JavaPackage getPackage(JavaArchive bundle, String fullyQualified, boolean createOnDemand)
   {
      return getPackage(bundle, "", fullyQualified, createOnDemand);
   }

   public static JavaPackage getPackage(JavaPackageBundle bundle, String path, String fullyQualified,
      boolean createOnDemand)
   {
      if (bundle == null)
      {
         throw new IllegalArgumentException("Package bundle must not be null");
      }
      if (path == null)
      {
         throw new IllegalArgumentException("Path must not be null.");
      }
      if (fullyQualified == null)
      {
         throw new IllegalArgumentException("Fully qualified must not be null.");
      }

      EList<JavaPackage> pkgs = bundle.getPathToRootPackagesMap().get(path);
      if (pkgs == null)
      {
         pkgs = new BasicEList<JavaPackage>();
         bundle.getPathToRootPackagesMap().put(path, pkgs);
      }
      final String[] names = fullyQualified.replace('/', '.').split("\\.");
      JavaPackage pkg = null;
      for (String name : names)
      {
         pkg = getPackage(pkgs, name, createOnDemand);
         if (pkg == null)
         {
            break;
         }
         pkgs = pkg.getPackages();
      }
      return pkg;
   }

   public static JavaPackage getSubPackage(JavaPackage parentPkg, String name, boolean createOnDemand)
   {
      return getPackage(parentPkg.getPackages(), name, createOnDemand);
   }

   private static JavaPackage getPackage(EList<JavaPackage> pkgs, String name, boolean createOnDemand)
   {
      for (JavaPackage pkg : pkgs)
      {
         if (name.equals(pkg.getSimpleName()))
         {
            return pkg;
         }
      }
      if (createOnDemand)
      {
         final JavaPackage pkg = JavaModelFactory.eINSTANCE.createJavaPackage();
         pkg.setSimpleName(name);
         pkgs.add(pkg);
         return pkg;
      }
      return null;
   }
}