/**
 * Copyright (c) 2011 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.osgify.maven;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertThat;

import java.io.File;

import javax.validation.ConstraintViolationException;

import org.apache.maven.project.MavenProject;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNull;
import org.junit.Test;

public class MavenUtilsTest
{
   @Test
   public void testGetOutputDir()
   {
      try
      {
         MavenUtils.getOutputDir(null);
         fail();
      }
      catch (ConstraintViolationException e)
      {
      }

      MavenProject project = new MavenProject();

      File outputDir = MavenUtils.getOutputDir(project);
      assertThat(outputDir, IsNull.nullValue());

      project.getBuild().setOutputDirectory("target/classes");
      try
      {
         MavenUtils.getOutputDir(project);
         fail();
      }
      catch (ConstraintViolationException e)
      {
      }

      project.setFile(new File(""));

      outputDir = MavenUtils.getOutputDir(project);
      assertThat(outputDir, IsNull.notNullValue());
      assertThat(outputDir, IsEqual.equalTo(new File("", "target/classes")));

      project.getBuild().setOutputDirectory("/target/classes");
      assertThat(outputDir, IsEqual.equalTo(new File("/target/classes")));
   }

   @Test
   public void testGetTestOutputDir()
   {
      try
      {
         MavenUtils.getTestOutputDir(null);
         fail();
      }
      catch (ConstraintViolationException e)
      {
      }

      MavenProject project = new MavenProject();

      File outputDir = MavenUtils.getTestOutputDir(project);
      assertThat(outputDir, IsNull.nullValue());

      project.getBuild().setTestOutputDirectory("target/classes");
      try
      {
         MavenUtils.getTestOutputDir(project);
         fail();
      }
      catch (ConstraintViolationException e)
      {
      }

      project.setFile(new File(""));

      outputDir = MavenUtils.getTestOutputDir(project);
      assertThat(outputDir, IsNull.notNullValue());
      assertThat(outputDir, IsEqual.equalTo(new File("", "target/classes")));

      project.getBuild().setTestOutputDirectory("/target/classes");
      assertThat(outputDir, IsEqual.equalTo(new File("/target/classes")));
   }
}
