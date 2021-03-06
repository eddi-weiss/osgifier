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

package org.sourcepit.osgifier.core.util;

import static com.google.common.base.Preconditions.checkArgument;

import org.sourcepit.common.constraints.NotNull;


/**
 * @author Bernd
 */
public final class SymbolicNameUtils {
   private static final String ALLOWED = "_-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

   public static boolean isValidSymbolicName(String symbolicName) {
      if (symbolicName == null || symbolicName.length() == 0) {
         return false;
      }
      char[] chars = symbolicName.toCharArray();
      int length = chars.length;
      for (int i = 0; i < length; i++) {
         char c = chars[i];
         if (ALLOWED.indexOf(c) < 0) {
            if ('.' != c) {
               return false;
            }
            if (i == 0 || i == length - 1) {
               return false;
            }
            if (i > 0 && chars[i - 1] == '.') {
               return false;
            }
         }
      }
      return true;
   }

   public static String toValidSymbolicName(@NotNull String symbolicName) {
      checkArgument(symbolicName.length() > 0);
      final StringBuilder sb = new StringBuilder();
      char[] chars = symbolicName.trim().toCharArray();
      int length = chars.length;
      for (int i = 0; i < length; i++) {
         char c = chars[i];
         if (ALLOWED.indexOf(c) < 0) {
            replace(sb, c, i, length);
         }
         else {
            sb.append(c);
         }
      }
      if (sb.length() == 0) {
         sb.append('_');
      }
      return sb.toString();
   }

   private static void replace(final StringBuilder sb, char c, int idx, int length) {
      switch (c) {
         case 'ä' :
            sb.append("ae");
            break;
         case 'ö' :
            sb.append("oe");
            break;
         case 'ü' :
            sb.append("ue");
            break;
         case 'ß' :
            sb.append("ss");
            break;
         case '.' :
            if (sb.length() != 0 && idx != length - 1) {
               sb.append(c);
            }
            break;
         default :
            sb.append('_');
            break;
      }
   }
}
