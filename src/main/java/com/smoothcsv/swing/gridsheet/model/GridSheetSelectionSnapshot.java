package com.smoothcsv.swing.gridsheet.model;


public class GridSheetSelectionSnapshot {

  private final int rowAnchor;
  private final int columnAnchor;
  private final GridSheetCellRange[] selections;
  private final boolean isRowHeaderSelected;
  private final boolean isColumnHeaderSelected;

  public GridSheetSelectionSnapshot(int rowAnchor, int columnAnchor,
      GridSheetCellRange[] selections, boolean isRowHeaderSelected, boolean isColumnHeaderSelected) {
    this.rowAnchor = rowAnchor;
    this.columnAnchor = columnAnchor;
    this.selections = selections;
    this.isRowHeaderSelected = isRowHeaderSelected;
    this.isColumnHeaderSelected = isColumnHeaderSelected;
  }

  public int getRowAnchor() {
    return rowAnchor;
  }

  public int getColumnAnchor() {
    return columnAnchor;
  }

  public GridSheetCellRange[] getSelections() {
    return selections;
  }

  public boolean isRowSelected(int row) {
    if (selections == null) {
      return false;
    }
    for (GridSheetCellRange as : selections) {
      if (as.containsRowAt(row)) {
        return true;
      }
    }
    return false;
  }

  public boolean isColumnSelected(int column) {
    if (selections == null) {
      return false;
    }
    for (GridSheetCellRange as : selections) {
      if (as.containsColumnAt(column)) {
        return true;
      }
    }
    return false;
  }

  public int[] getSelectedRows(int rowCount) {
    int iMin = Integer.MAX_VALUE;
    int iMax = -1;

    for (GridSheetCellRange as : selections) {
      iMin = Math.min(iMin, as.getFirstRow());
      iMax = Math.max(iMax, as.getLastRow());
    }

    iMax = Math.min(iMax, rowCount - 1);

    int[] rvTmp = new int[1 + (iMax - iMin)];
    int n = 0;
    for (int i = iMin; i <= iMax; i++) {
      if (isRowSelected(i)) {
        rvTmp[n++] = i;
      }
    }
    int[] rv = new int[n];
    System.arraycopy(rvTmp, 0, rv, 0, n);
    return rv;
  }

  public int[] getSelectedColumns(int columnCount) {
    int iMin = Integer.MAX_VALUE;
    int iMax = -1;

    for (GridSheetCellRange as : selections) {
      iMin = Math.min(iMin, as.getFirstColumn());
      iMax = Math.max(iMax, as.getLastColumn());
    }

    iMax = Math.min(iMax, columnCount - 1);

    int[] rvTmp = new int[1 + (iMax - iMin)];
    int n = 0;
    for (int i = iMin; i <= iMax; i++) {
      if (isColumnSelected(i)) {
        rvTmp[n++] = i;
      }
    }
    int[] rv = new int[n];
    System.arraycopy(rvTmp, 0, rv, 0, n);
    return rv;
  }

  public boolean isRowHeaderSelected() {
    return isRowHeaderSelected;
  }

  public boolean isColumnHeaderSelected() {
    return isColumnHeaderSelected;
  }
}
