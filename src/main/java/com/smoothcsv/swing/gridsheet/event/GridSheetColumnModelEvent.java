package com.smoothcsv.swing.gridsheet.event;

import com.smoothcsv.swing.gridsheet.model.GridSheetModel;

@SuppressWarnings("serial")
public class GridSheetColumnModelEvent extends java.util.EventObject {
  //
  // Instance Variables
  //

  /** The index of the column from where it was moved or removed */
  protected int fromIndex;

  /** The index of the column to where it was moved or added */
  protected int toIndex;

  //
  // Constructors
  //

  /**
   * Constructs a {@code TableColumnModelEvent} object.
   *
   * @param source the {@code TableColumnModel} that originated the event
   * @param from an int specifying the index from where the column was moved or removed
   * @param to an int specifying the index to where the column was moved or added
   * @see #getFromIndex
   * @see #getToIndex
   */
  public GridSheetColumnModelEvent(GridSheetModel source, int from, int to) {
    super(source);
    fromIndex = from;
    toIndex = to;
  }

  //
  // Querying Methods
  //

  /** Returns the fromIndex. Valid for removed or moved events */
  public int getFromIndex() {
    return fromIndex;
  };

  /** Returns the toIndex. Valid for add and moved events */
  public int getToIndex() {
    return toIndex;
  };
}
