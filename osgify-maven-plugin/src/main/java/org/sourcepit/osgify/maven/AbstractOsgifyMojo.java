/**
 * Copyright (c) 2011 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.osgify.maven;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.project.MavenProject;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.sourcepit.osgify.context.OsgifyContext;

public abstract class AbstractOsgifyMojo extends AbstractMojo
{
   /** @component */
   private OsgifyContextBuilder builder;

   /** @parameter default-value="${localRepository}" */
   protected ArtifactRepository localRepository;

   /** @parameter default-value="${project.build.directory}" */
   private File targetDir;

   /** @parameter default-value="${project}" */
   private MavenProject project;

   protected void doExecute(Goal goal)
   {
      final OsgifyContext context = builder.build(project, goal, localRepository);

      XMLResourceImpl resource = new XMLResourceImpl();
      resource.getContents().add(context);

      OutputStream out = null;
      try
      {
         out = newOutStream(goal);
         resource.save(out, null);
      }
      catch (IOException e)
      {
         throw new IllegalStateException(e);
      }
      finally
      {
         IOUtils.closeQuietly(out);
      }
   }

   private OutputStream newOutStream(Goal goal) throws IOException
   {
      File file = new File(targetDir, goal == Goal.OSGIFY ? "osgify-context.xml" : "osgify-tests-context.xml");
      if (file.exists())
      {
         file.delete();
      }
      file.getParentFile().mkdirs();
      file.createNewFile();
      return new FileOutputStream(file);
   }
}
