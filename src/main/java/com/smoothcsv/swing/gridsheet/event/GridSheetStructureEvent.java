/**
 * 
 */
package com.smoothcsv.swing.gridsheet.event;

import lombok.Getter;

/**
 * @author kohii
 *
 */
@SuppressWarnings("serial")
public class GridSheetStructureEvent extends java.util.EventObject {

  public static final int INSERT_ROW = 1;
  public static final int INSERT_COLUMN = 2;

  public static final int REMOVE_ROW = 3;
  public static final int REMOVE_COLUMN = 4;

  public static final int UPDATE_WIDTH = 5;
  public static final int UPDATE_HEIGHT = 6;

  public static final int UPDATE_VISIBLE_ROWS = 7;
  public static final int UPDATE_VISIBLE_COLUMNS = 8;

  public static final int SORT_ROWS = 9;
  public static final int CHANGE_DATALIST = 999;

  @Getter
  private int type;
  @Getter
  private boolean adjusting;
  @Getter
  private int index;
  @Getter
  private int numRows;
  @Getter
  private int newRowCount;
  @Getter
  private int newColumnCount;

  /**
   * @param source
   * @param type
   * @param adjusting
   * @param index
   * @param numRows
   * @param newRowCount
   * @param newColumnCount
   */
  public GridSheetStructureEvent(Object source, int type, boolean adjusting, int index,
      int numRows, int newRowCount, int newColumnCount) {
    super(source);
    this.type = type;
    this.adjusting = adjusting;
    this.index = index;
    this.numRows = numRows;
    this.newRowCount = newRowCount;
    this.newColumnCount = newColumnCount;
  }


  /**
   * @param source
   * @param type
   * @param adjusting
   */
  public GridSheetStructureEvent(Object source, int type, boolean adjusting) {
    super(source);
    this.type = type;
    this.adjusting = adjusting;
  }
}
