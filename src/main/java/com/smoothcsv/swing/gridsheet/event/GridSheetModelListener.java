package com.smoothcsv.swing.gridsheet.event;


public interface GridSheetModelListener extends java.util.EventListener {

  public void tableChanged(GridSheetModelEvent e);

  /** Tells listeners that a column was added to the model. */
  public void columnAdded(GridSheetColumnModelEvent e);

  /** Tells listeners that a column was removed from the model. */
  public void columnRemoved(GridSheetColumnModelEvent e);
}
