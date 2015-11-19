package com.smoothcsv.swing.gridsheet.renderer;

import java.awt.Component;

import com.smoothcsv.swing.gridsheet.AbstractGridSheetHeaderComponent;

public interface GridSheetHeaderRenderer {

  Component getGridCellRendererComponent(AbstractGridSheetHeaderComponent header, Object value,
      boolean isSelected, boolean hasFocus, int index);
}
