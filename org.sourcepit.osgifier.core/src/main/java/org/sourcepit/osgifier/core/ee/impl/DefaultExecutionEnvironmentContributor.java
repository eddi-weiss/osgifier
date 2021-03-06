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

package org.sourcepit.osgifier.core.ee.impl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sourcepit.osgifier.core.ee.ExecutionEnvironment;
import org.sourcepit.osgifier.core.ee.ExecutionEnvironmentImplementation;
import org.sourcepit.osgifier.core.ee.OsgiEE;
import org.sourcepit.osgifier.core.util.JsonUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * @author Bernd Vogt <bernd.vogt@sourcepit.org>
 */
@Named
public class DefaultExecutionEnvironmentContributor implements ExecutionEnvironmentContributor {
   private final static Logger LOGGER = LoggerFactory.getLogger(DefaultExecutionEnvironmentContributor.class);

   private List<ExecutionEnvironment> ees;

   private List<ExecutionEnvironmentImplementation> eeImpls;

   public List<ExecutionEnvironment> getExecutionEnvironments() {
      lazyInit();
      return ees;
   }

   public List<ExecutionEnvironmentImplementation> getExecutionEnvironmentImplementations() {
      lazyInit();
      return eeImpls;
   }

   private synchronized void lazyInit() {
      if (ees != null) {
         return;
      }

      ees = new ArrayList<ExecutionEnvironment>();
      eeImpls = new ArrayList<ExecutionEnvironmentImplementation>();

      try {
         parseSpecs();
         parseImpls();
      }
      catch (IOException e) {
         throw new IllegalStateException(e);
      }
   }

   private void parseSpecs() throws IOException {
      final Enumeration<URL> resources = getClass().getClassLoader().getResources("META-INF/osgifier/ee.spec");
      while (resources.hasMoreElements()) {
         final JsonElement jsonElement = JsonUtils.parse(((URL) resources.nextElement()).openStream());
         if (jsonElement instanceof JsonArray) {
            for (JsonElement eeSpec : jsonElement.getAsJsonArray()) {
               parseSpec(eeSpec.getAsJsonObject());
            }
         }
         else if (jsonElement instanceof JsonObject) {
            parseSpec(jsonElement.getAsJsonObject());
         }
      }
   }

   private void parseSpec(JsonObject eeSpec) {
      final String id = getValue(eeSpec, "id");
      if (id == null) {
         LOGGER.debug("Ignoring Execution Environment Specification, because of missing id attribute.");
         return;
      }

      final String releaseDate = getValue(eeSpec, "releaseDate");
      if (releaseDate == null) {
         LOGGER.debug("Ignoring Execution Environment {}, because of missing releaseDate attribute.", id);
         return;
      }

      final float maxClassVersion = getFloatValue(eeSpec, "maxClassVersion");
      if (maxClassVersion < 0) {
         LOGGER.debug("Ignoring Execution Environment {}, because of missing or invalid max class version attribute.",
            id);
         return;
      }

      final String vendor = getValue(eeSpec, "vendor");
      if (vendor == null) {
         LOGGER.debug("Ignoring Execution Environment {}, because of missing vendor attribute.", id);
         return;
      }

      final OsgiEE osgiEE = getOsgiEE(eeSpec, "osgi.ee");

      final List<String> packages = getListValue(eeSpec, "packages");

      ees.add(new ExecutionEnvironment(id, releaseDate, maxClassVersion, osgiEE, packages));
   }

   private OsgiEE getOsgiEE(JsonObject jsonObject, String property) {
      final JsonElement jsonElement = jsonObject.get(property);
      if (jsonElement != null) {
         final JsonObject obj = jsonElement.getAsJsonObject();
         final String name = getValue(obj, "name");
         final String version = getValue(obj, "version");
         return new OsgiEE(name, version);
      }
      return null;
   }

   private void parseImpls() throws IOException {
      final Enumeration<URL> resources = getClass().getClassLoader().getResources("META-INF/osgifier/ee.impl");
      while (resources.hasMoreElements()) {
         final JsonElement jsonElement = JsonUtils.parse(((URL) resources.nextElement()).openStream());
         if (jsonElement instanceof JsonArray) {
            for (JsonElement eeImpl : jsonElement.getAsJsonArray()) {
               parseImpl(eeImpl.getAsJsonObject());
            }
         }
         else if (jsonElement instanceof JsonObject) {
            parseImpl(jsonElement.getAsJsonObject());
         }
      }
   }

   private void parseImpl(JsonObject eeImpl) {
      final String eeId = getValue(eeImpl, "executionEnvironmentId");
      if (eeId == null) {
         LOGGER.debug("Ignoring Execution Environment Implementation, because of missing executionEnvironmentId attribute.");
         return;
      }

      final String vendor = getValue(eeImpl, "vendor");
      if (vendor == null) {
         LOGGER.debug("Ignoring Execution Environment Implementation for {}, because of missing vendor attribute.",
            eeId);
         return;
      }

      final String version = getValue(eeImpl, "version");
      if (version == null) {
         LOGGER.debug(
            "Ignoring Execution Environment Implementation for {} of vendor {}, because of missing version attribute.",
            eeId, vendor);
         return;
      }

      final List<String> packages = getListValue(eeImpl, "vendorPackages");

      eeImpls.add(new ExecutionEnvironmentImplementation(eeId, vendor, packages));
   }

   private static String getValue(JsonObject jsonObject, String property) {
      final JsonElement jsonElement = jsonObject.get(property);
      return jsonElement == null ? null : jsonElement.getAsString();
   }

   private static float getFloatValue(JsonObject jsonObject, String property) {
      final JsonElement jsonElement = jsonObject.get(property);
      return jsonElement == null ? -1 : jsonElement.getAsFloat();
   }

   private static List<String> getListValue(JsonObject jsonObject, String property) {
      final List<String> result = new ArrayList<String>();
      final JsonElement jsonElement = jsonObject.get(property);
      if (jsonElement != null) {
         final JsonArray jsonArray = jsonElement.getAsJsonArray();
         for (JsonElement entry : jsonArray) {
            result.add(entry.getAsString());
         }
      }
      return result;
   }
}
