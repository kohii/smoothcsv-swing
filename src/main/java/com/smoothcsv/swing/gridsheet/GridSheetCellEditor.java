package com.smoothcsv.swing.gridsheet;

import javax.swing.CellEditor;
import javax.swing.JComponent;

public interface GridSheetCellEditor extends CellEditor {

  boolean prepare(GridSheetTable table, Object value, boolean isSelected, int row, int column);

  JComponent getEditorComponent();

  JComponent getOuterEditorComponent();
}
