package com.smoothcsv.swing.gridsheet.ui;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.plaf.ComponentUI;

import com.smoothcsv.swing.gridsheet.GridSheetPane;

public abstract class AbstractGridUI extends ComponentUI {

  protected abstract GridSheetPane getGridSheetPane();

  protected void paintFrozenLine(Graphics g, Rectangle clip, Rectangle lineRect) {
    lineRect = lineRect.intersection(clip);
    if (!lineRect.isEmpty()) {
      g.setClip(clip);
      g.setColor(getGridSheetPane().getColorProvider().getFrozenLineColor());
      g.fillRect(lineRect.x, lineRect.y, lineRect.width, lineRect.height);
    }
  }
}
