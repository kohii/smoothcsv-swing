package com.smoothcsv.swing.gridsheet.event;

import java.util.EventObject;

@SuppressWarnings("serial")
public class GridSheetSelectionEvent extends EventObject {
  private int firstRow;
  private int firstColumn;
  private int lastRow;
  private int lastColumn;
  private boolean isAdjusting;

  public GridSheetSelectionEvent(Object source, int firstRow, int firstColumn, int lastRow,
      int lastColumn, boolean isAdjusting) {
    super(source);
    this.firstRow = firstRow;
    this.firstColumn = firstColumn;
    this.lastRow = lastRow;
    this.lastColumn = lastColumn;
    this.isAdjusting = isAdjusting;
  }

  public boolean getValueIsAdjusting() {
    return isAdjusting;
  }

  /**
   * Returns a {@code String} that displays and identifies this object's properties.
   *
   * @return a String representation of this object
   */
  public String toString() {
    String properties =
        " source=" + getSource() + " firstRow= " + firstRow + " firstColumn= " + firstColumn
            + " lastRow= " + lastRow + " lastColumn= " + lastColumn + " isAdjusting= "
            + isAdjusting + " ";
    return getClass().getName() + "[" + properties + "]";
  }

  public int getFirstRow() {
    return firstRow;
  }

  public int getFirstColumn() {
    return firstColumn;
  }

  public int getLastRow() {
    return lastRow;
  }

  public int getLastColumn() {
    return lastColumn;
  }

}
