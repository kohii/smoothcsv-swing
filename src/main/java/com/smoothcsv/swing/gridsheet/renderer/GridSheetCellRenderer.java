package com.smoothcsv.swing.gridsheet.renderer;

import java.awt.Component;

import com.smoothcsv.swing.gridsheet.GridSheetTable;

public interface GridSheetCellRenderer {

  Component getGridCellRendererComponent(GridSheetTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column);
}
