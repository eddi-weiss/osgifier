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

package org.sourcepit.osgifier.core.inspect;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;

import org.sourcepit.common.utils.io.UnclosableInputStream;
import org.sourcepit.common.utils.path.Path;
import org.sourcepit.common.utils.zip.ZipEntryHandler;

/**
 * @author Bernd
 */
public class ZipEntryHandlerAdapter implements ZipEntryHandler
{
   private final ResourceVisitor visitor;

   public ZipEntryHandlerAdapter(ResourceVisitor visitor)
   {
      this.visitor = visitor;
   }

   public void handle(ZipEntry zipEntry, final InputStream content) throws IOException
   {
      final Path path = new Path(zipEntry.getName());
      final boolean isDirectory = zipEntry.isDirectory();
      visitor.visit(path, isDirectory, isDirectory ? null : UnclosableInputStream.wrap(content));
   }
}
