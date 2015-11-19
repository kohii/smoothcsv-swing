package com.smoothcsv.swing.gridsheet.event;

import java.util.EventObject;

@SuppressWarnings("serial")
public class GridSheetFocusEvent extends EventObject {
  private int row;
  private int column;
  private boolean isAdjusting;

  public GridSheetFocusEvent(Object source, int row, int column, boolean isAdjusting) {
    super(source);
    this.row = row;
    this.column = column;
    this.isAdjusting = isAdjusting;
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
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
        " source=" + getSource() + " row= " + row + " column= " + column + " isAdjusting= "
            + isAdjusting + " ";
    return getClass().getName() + "[" + properties + "]";
  }

}
