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

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import com.smoothcsv.commons.exception.UnexpectedException;

/**
 * @author kohii
 *
 */
public class LineBreakableTextField extends JTextArea {

  private static final long serialVersionUID = 6515247959471471489L;

  private List<ActionListener> actionListeners = new ArrayList<>(1);
  private int lineHeight;
  private boolean enableDefaultKeyBindings;

  private Action insertBreakAction;

  @SuppressWarnings("serial")
  public LineBreakableTextField(boolean enableActionPerformed) {

    this.enableDefaultKeyBindings = enableActionPerformed;
    
    setTabSize(4);

    insertBreakAction = getActionMap().get("insert-break");
    if (insertBreakAction == null) {
      throw new UnexpectedException("Action:\"insert-break\" is not available.");
    }
    if (enableActionPerformed) {
      getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "actionPerformed");
      getActionMap().put("actionPerformed", new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
          for (ActionListener actionListener : actionListeners) {
            actionListener.actionPerformed(e);
          }
        }
      });
      getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.SHIFT_DOWN_MASK),
          "insertBreak");
      getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.ALT_DOWN_MASK),
          "insertBreak");
      getActionMap().put("insertBreak", insertBreakAction);
    } else {
      // disable the key binding of ENTER
      getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "-------------dummy");
    }

    calcLineHeight();
  }

  public void insertBreak() {
    insertBreakAction.actionPerformed(null);
  }

  private void calcLineHeight() {
    FontMetrics fm = getFontMetrics(getFont());
    lineHeight = fm.getHeight();
  }

  @Override
  public void setFont(Font f) {
    super.setFont(f);
    calcLineHeight();
  }

  public int getLineHeight() {
    return lineHeight;
  }

  public void addActionListener(ActionListener actionListener) {
    if (!enableDefaultKeyBindings) {
      throw new IllegalStateException();
    }
    actionListeners.add(actionListener);
  }
}
