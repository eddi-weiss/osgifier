/**
 * Copyright (c) 2012 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.modularizor.core.ee.impl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map.Entry;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcepit.common.utils.props.LinkedPropertiesMap;
import org.sourcepit.common.utils.props.PropertiesMap;
import org.sourcepit.modularizor.core.ee.ExecutionEnvironment;
import org.sourcepit.modularizor.core.ee.ExecutionEnvironmentImplementation;
import org.sourcepit.modularizor.core.util.JsonUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * @author Bernd Vogt <bernd.vogt@sourcepit.org>
 */
@Named
public class DefaultExecutionEnvironmentContributor implements ExecutionEnvironmentContributor
{
   private final static Logger LOGGER = LoggerFactory.getLogger(DefaultExecutionEnvironmentContributor.class);

   private List<ExecutionEnvironment> ees;

   private List<ExecutionEnvironmentImplementation> eeImpls;

   public List<ExecutionEnvironment> getExecutionEnvironments()
   {
      lazyInit();
      return ees;
   }

   public List<ExecutionEnvironmentImplementation> getExecutionEnvironmentImplementations()
   {
      lazyInit();
      return eeImpls;
   }

   private synchronized void lazyInit()
   {
      if (ees != null)
      {
         return;
      }

      ees = new ArrayList<ExecutionEnvironment>();
      eeImpls = new ArrayList<ExecutionEnvironmentImplementation>();

      try
      {
         parseSpecs();
         parseImpls();
      }
      catch (IOException e)
      {
         throw new IllegalStateException(e);
      }
   }

   private void parseSpecs() throws IOException
   {
      final Enumeration<URL> resources = getClass().getClassLoader().getResources("META-INF/modularizor/ee.spec");
      while (resources.hasMoreElements())
      {
         final JsonElement jsonElement = JsonUtils.parse(((URL) resources.nextElement()).openStream());
         if (jsonElement instanceof JsonArray)
         {
            for (JsonElement eeSpec : jsonElement.getAsJsonArray())
            {
               parseSpec(eeSpec.getAsJsonObject());
            }
         }
         else if (jsonElement instanceof JsonObject)
         {
            parseSpec(jsonElement.getAsJsonObject());
         }
      }
   }

   private void parseSpec(JsonObject eeSpec)
   {
      final String id = getValue(eeSpec, "id");
      if (id == null)
      {
         LOGGER.debug("Ignoring Execution Environment Specification, because of missing id attribute.");
         return;
      }

      final String releaseDate = getValue(eeSpec, "releaseDate");
      if (releaseDate == null)
      {
         LOGGER.debug("Ignoring Execution Environment {}, because of missing releaseDate attribute.", id);
         return;
      }

      final int maxClassVersion = getIntValue(eeSpec, "maxClassVersion");
      if (maxClassVersion < 0)
      {
         LOGGER.debug("Ignoring Execution Environment {}, because of missing or invalid max class version attribute.",
            id);
         return;
      }

      final String vendor = getValue(eeSpec, "vendor");
      if (vendor == null)
      {
         LOGGER.debug("Ignoring Execution Environment {}, because of missing vendor attribute.", id);
         return;
      }

      final List<String> packages = getListValue(eeSpec, "packages");

      final PropertiesMap properties = parseJsonProperties(eeSpec);

      ees.add(new ExecutionEnvironment(id, releaseDate, maxClassVersion, properties, packages));
   }

   private void parseImpls() throws IOException
   {
      final Enumeration<URL> resources = getClass().getClassLoader().getResources("META-INF/modularizor/ee.impl");
      while (resources.hasMoreElements())
      {
         final JsonElement jsonElement = JsonUtils.parse(((URL) resources.nextElement()).openStream());
         if (jsonElement instanceof JsonArray)
         {
            for (JsonElement eeImpl : jsonElement.getAsJsonArray())
            {
               parseImpl(eeImpl.getAsJsonObject());
            }
         }
         else if (jsonElement instanceof JsonObject)
         {
            parseImpl(jsonElement.getAsJsonObject());
         }
      }
   }

   private void parseImpl(JsonObject eeImpl)
   {
      final String eeId = getValue(eeImpl, "executionEnvironmentId");
      if (eeId == null)
      {
         LOGGER
            .debug("Ignoring Execution Environment Implementation, because of missing executionEnvironmentId attribute.");
         return;
      }

      final String vendor = getValue(eeImpl, "vendor");
      if (vendor == null)
      {
         LOGGER.debug("Ignoring Execution Environment Implementation for {}, because of missing vendor attribute.",
            eeId);
         return;
      }

      final String version = getValue(eeImpl, "version");
      if (version == null)
      {
         LOGGER.debug(
            "Ignoring Execution Environment Implementation for {} of vendor {}, because of missing version attribute.",
            eeId, vendor);
         return;
      }

      final List<String> packages = getListValue(eeImpl, "vendorPackages");

      final PropertiesMap properties = parseJsonProperties(eeImpl);

      eeImpls.add(new ExecutionEnvironmentImplementation(eeId, vendor, properties, packages));
   }

   private PropertiesMap parseJsonProperties(JsonObject jvm)
   {
      final PropertiesMap properties = new LinkedPropertiesMap();
      for (Entry<String, JsonElement> entry : jvm.entrySet())
      {
         if (entry.getValue() instanceof JsonPrimitive)
         {
            properties.put(entry.getKey(), entry.getValue().getAsString());
         }
      }
      return properties;
   }

   private static String getValue(JsonObject jsonObject, String property)
   {
      final JsonElement jsonElement = jsonObject.get(property);
      return jsonElement == null ? null : jsonElement.getAsString();
   }

   private static int getIntValue(JsonObject jsonObject, String property)
   {
      final JsonElement jsonElement = jsonObject.get(property);
      return jsonElement == null ? -1 : jsonElement.getAsInt();
   }

   private static List<String> getListValue(JsonObject jsonObject, String property)
   {
      final List<String> result = new ArrayList<String>();
      final JsonElement jsonElement = jsonObject.get(property);
      if (jsonElement != null)
      {
         final JsonArray jsonArray = jsonElement.getAsJsonArray();
         for (JsonElement entry : jsonArray)
         {
            result.add(entry.getAsString());
         }
      }
      return result;
   }
}