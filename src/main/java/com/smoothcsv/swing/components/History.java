/*
 * Copyright 2016 kohii
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.smoothcsv.swing.components;

import com.smoothcsv.commons.exception.UnexpectedException;
import com.smoothcsv.commons.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class History {

  private static final String CHARSET = "UTF-8";

  private static final int DEFAULT_MAX_SIZE = 15;

  private ArrayList<String> values;

  private final File file;

  private final boolean autoFlush;

  private int maxSize;

  private final boolean disallowEmpty;

  public History(File file, boolean autoFlush) {
    this(file, autoFlush, DEFAULT_MAX_SIZE);
  }

  public History(File file, boolean autoFlush, int maxSize) {
    this(file, autoFlush, maxSize, false);
  }

  public History(File file, boolean autoFlush, int maxSize, boolean disallowEmpty) {
    this.maxSize = maxSize;
    this.autoFlush = autoFlush;
    this.file = file;
    this.disallowEmpty = disallowEmpty;
    if (!file.exists() || !file.canRead()) {
      values = new ArrayList<>(maxSize);
    } else {
      try {
        values = new ArrayList<>(FileUtils.read(file, CHARSET));
        if (disallowEmpty) {
          for (Iterator<String> it = values.iterator(); it.hasNext(); ) {
            if (it.next().isEmpty()) {
              it.remove();
            }
          }
        }
      } catch (IOException e) {
        values = new ArrayList<>(maxSize);
      }
      trimToMaxSize();
    }
  }

  public boolean put(String value) {
    boolean ret = true;
    if (disallowEmpty && value.isEmpty()) {
      return false;
    }
    values.add(value);
    for (int i = 0; i < values.size() - 1; i++) {
      if (value.equals(values.get(i))) {
        values.remove(i);
        ret = false;
      }
    }
    trimToMaxSize();
    if (autoFlush) {
      flush();
    }
    return ret;
  }

  public void trimToMaxSize() {
    int over = values.size() - maxSize;
    if (0 < over) {
      values.subList(0, over).clear();
    }
  }

  public void clear() {
    values.clear();
  }

  public void remove(String s) {
    values.remove(s);
  }

  public void flush() {
    FileUtils.ensureWritable(file);
    try {
      FileUtils.write(values, file, CHARSET);
    } catch (IOException e) {
      throw new UnexpectedException(e);
    }
  }

  public int size() {
    return values.size();
  }

  @SuppressWarnings("unchecked")
  public List<String> getAll() {
    List<String> ret = new ArrayList<>(values);
    Collections.reverse(ret);
    return ret;
  }

  public String get(int i) {
    return values.get(values.size() - i - 1);
  }

  public int getMaxSize() {
    return maxSize;
  }

  public void setMaxSize(int maxSize) {
    this.maxSize = maxSize;
    trimToMaxSize();
  }

}
