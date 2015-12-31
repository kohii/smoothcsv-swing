/*
 * Copyright 2015 kohii
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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.smoothcsv.commons.exception.UnexpectedException;
import com.smoothcsv.commons.utils.FileUtils;


public class History {

  private static final String CHARSET = "UTF-8";

  private static final int DEFAULT_MAX_SIZE = 15;

  private List<String> values;

  private final File file;

  private final boolean autoFlush;

  private int maxSize;


  public History(File file, boolean autoFlush) {
    this(file, autoFlush, DEFAULT_MAX_SIZE);
  }

  public History(File file, boolean autoFlush, int maxSize) {
    this.maxSize = maxSize;
    this.autoFlush = autoFlush;
    this.file = file;
    if (!file.exists() || !file.canRead()) {
      values = new ArrayList<String>(maxSize);
    } else {
      try {
        values = FileUtils.read(file, CHARSET);
      } catch (IOException e) {
        values = new ArrayList<String>(maxSize);
      }
      trimToMaxSize();
    }
  }

  public boolean put(String value) {
    boolean ret = true;
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
    return (List<String>) ((ArrayList<String>) values).clone();
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
