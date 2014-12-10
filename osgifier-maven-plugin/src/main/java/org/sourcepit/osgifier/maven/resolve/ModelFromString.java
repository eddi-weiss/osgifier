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

package org.sourcepit.osgifier.maven.resolve;

import static org.sourcepit.common.utils.lang.Exceptions.pipe;

import java.io.IOException;
import java.io.StringReader;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.DefaultModelReader;

/**
 * @author Bernd Vogt <bernd.vogt@sourcepit.org>
 */
public class ModelFromString
{
   public Model fromString(String modelAsString)
   {
      try
      {
         return new DefaultModelReader().read(new StringReader(modelAsString), null);
      }
      catch (IOException e)
      {
         throw pipe(e);
      }
   }
}