/**
 * Copyright (c) 2011 Sourcepit.org contributors and others. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.sourcepit.osgify.its;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.OS;
import org.apache.commons.exec.ProcessDestroyer;
import org.apache.commons.exec.PumpStreamHandler;

public abstract class AbstractB2ExamplesIT extends TestCase
{
   private static final Properties props;

   static
   {
      props = new Properties();
      ClassLoader cl = AbstractB2ExamplesIT.class.getClassLoader();
      InputStream is = cl.getResourceAsStream("osgiy-its.properties");
      if (is != null)
      {
         try
         {
            try
            {
               props.load(is);
            }
            finally
            {
               is.close();
            }
         }
         catch (IOException e)
         {
            throw new RuntimeException(e);
         }
      }
   }

   static synchronized String getProperty(String key)
   {
      return props.getProperty(key);
   }


   private final static boolean DEBUG = false;

   protected TearDownProcessDestroyer processDestroyer = new TearDownProcessDestroyer();
   protected Map<String, String> environment;
   protected DefaultExecutor executor;
   protected File workingDir;

   protected File exampleModuleDir;

   @Override
   protected void setUp() throws Exception
   {
      super.setUp();

      exampleModuleDir = null;

      String projects = getProperty("projects-dir");
      String out = getProperty("projects-dir");
      String maven = getProperty("maven-dir");

      workingDir = new File("projects");
      assertTrue(workingDir.exists());
      assertTrue(workingDir.canRead());

      executor = new DefaultExecutor();
      executor.setWorkingDirectory(workingDir);
      executor.setStreamHandler(new PumpStreamHandler(System.out, System.err));
      executor.setProcessDestroyer(processDestroyer);

      environment = new HashMap<String, String>(System.getenv());
      environment.remove("M2_HOME");

      environment.remove("JAVA_HOME");
      environment.put("JAVA_HOME", System.getProperty("java.home"));

      final String javaagent = System.getProperty("javaagent");
      if (javaagent != null)
      {
         String mvnOpts = environment.get("MAVEN_OPTS");
         if (mvnOpts == null)
         {
            mvnOpts = javaagent;
         }
         else
         {
            mvnOpts = (mvnOpts + " " + javaagent).trim();
         }
         environment.put("MAVEN_OPTS", mvnOpts);
         System.out.println(mvnOpts);
      }

      // environment.put("MAVEN_ARGS", "-B -e clean deploy");
   }

   private CommandLine createCmd() throws AssertionFailedError
   {
      final String testModule = getName().substring("test".length()).toLowerCase().replace('_', '-');

      CommandLine command;

      final String executable;
      if (OS.isFamilyWindows() || OS.isFamilyWin9x())
      {
         executable = isDebug(getName()) ? "debug.bat" : "run.bat";
         command = new CommandLine(new File(workingDir, executable));
      }
      else if (OS.isFamilyUnix() || OS.isFamilyMac())
      {
         executable = "sh";
         System.out.println(executable);
         command = new CommandLine(executable);
         command.addArgument(new File(workingDir, "run.sh").getAbsolutePath());
      }
      else
      {
         throw new AssertionFailedError("Os family");
      }
      //
      // if (OS.isFamilyUnix() || OS.isFamilyMac())
      // {
      // command.addArgument("run.sh");
      // }
      command.addArgument("example-modules/" + testModule);

      exampleModuleDir = new File(workingDir, "example-modules/" + testModule);

      return command;
   }

   protected boolean isDebug(String testName)
   {
      return DEBUG;
   }

   protected void execute(String... args) throws ExecuteException, IOException
   {
      CommandLine command = createCmd();
      if (args != null)
      {
         command.addArguments(args);
      }
      executor.execute(command, environment);
   }

   protected void execute() throws ExecuteException, IOException
   {
      execute((String[]) null);
   }

   @Override
   protected void tearDown() throws Exception
   {
      processDestroyer.tearDown();
      exampleModuleDir = null;
      super.tearDown();
   }

   private static class TearDownProcessDestroyer implements ProcessDestroyer
   {
      private final List<Process> processes = new ArrayList<Process>();

      public synchronized boolean add(Process process)
      {
         return processes.add(process);
      }

      public synchronized boolean remove(Process process)
      {
         return processes.remove(process);
      }

      public synchronized int size()
      {
         return processes.size();
      }

      public synchronized void tearDown()
      {
         for (Process process : processes)
         {
            try
            {
               process.destroy();
            }
            catch (Throwable t)
            {
               System.err.println("Unable to terminate process during process shutdown");
            }
         }
      }
   }
}
