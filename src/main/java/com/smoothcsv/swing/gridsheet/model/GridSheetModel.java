/*
 * Copyright 2015 kohii
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.smoothcsv.swing.gridsheet.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import com.smoothcsv.swing.gridsheet.event.GridSheetDataEvent;
import com.smoothcsv.swing.gridsheet.event.GridSheetStructureEvent;

import lombok.Getter;
import lombok.Setter;

/**
 * @author kohii
 *
 */
public class GridSheetModel implements IGridSheetModel {

  private static final int MIN = -1;
  private static final int MAX = Integer.MAX_VALUE;

  @Getter
  @Setter
  private Object defaultValue = "";

  /**
   * The <code>List</code> of <code>List</code> of <code>Object</code> values.
   */
  protected List<List> dataList;

  private List<Consumer<GridSheetDataEvent>> dataUpdateListeners = new ArrayList<>();

  @Getter
  private boolean adjusting;
  private int firstAdjustedRowIndex = MAX;
  private int lastAdjustedRowIndex = MIN;
  private int firstAdjustedColumnIndex = MAX;
  private int lastAdjustedColumnIndex = MIN;
  private boolean adjustdStructureChanged = false;


  /**
   * @param dataList
   */
  public GridSheetModel(List<List> dataList) {
    setDataList(dataList, dataList.size(), getMaxColumnCount(dataList));
  }

  /**
   * @param dataList
   */
  public GridSheetModel(List<List> dataList, int rowCount, int columnCount) {
    setDataList(dataList, rowCount, columnCount);
  }

  public void setDataList(List<List> dataList) {
    setDataList(dataList, dataList.size(), getMaxColumnCount(dataList));
  }

  public void setDataList(List<List> dataList, int rowCount, int columnCount) {
    if (dataList == null || dataList.isEmpty()) {
      throw new IllegalArgumentException();
    }
    this.dataList = dataList;

    invalidateWidthCache();
    invalidateHeightCache();

    List<GridSheetRow> rows = new ArrayList<>(rowCount);
    for (int i = 0; i < rowCount; i++) {
      rows.add(createDefaultRow());
    }
    this.rows = rows;

    List<GridSheetColumn> columns = new ArrayList<>(columnCount);
    for (int i = 0; i < columnCount; i++) {
      columns.add(createDefaultColumn());
    }
    this.columns = columns;
    fireStructureChanged(GridSheetStructureEvent.CHANGE_DATALIST);
  }

  private int getMaxColumnCount(List<List> dataList) {
    int columnCount = -1;
    for (int i = 0; i < dataList.size(); i++) {
      columnCount = Math.max(dataList.get(i).size(), columnCount);
    }
    return columnCount;
  }

  /**
   * Returns an attribute value for the cell at <code>row</code> and <code>column</code>.
   *
   * @param row the row whose value is to be queried
   * @param column the column whose value is to be queried
   * @return the value Object at the specified cell
   * @exception ArrayIndexOutOfBoundsException if an invalid row or column was given
   */
  public Object getValueAt(int row, int column) {
    List rowData = dataList.get(row);
    if (rowData.size() <= column) {
      return null;
    }
    return rowData.get(column);
  }

  /**
   * Sets the object value for the cell at <code>column</code> and <code>row</code>.
   * <code>aValue</code> is the new value. This method will generate a <code>tableChanged</code>
   * notification.
   *
   * @param aValue the new value; this can be null
   * @param row the row whose value is to be changed
   * @param column the column whose value is to be changed
   * @exception ArrayIndexOutOfBoundsException if an invalid row or column was given
   */
  @SuppressWarnings("unchecked")
  public void setValueAt(Object aValue, int row, int column) {
    List<Object> rowData = dataList.get(row);
    rowData.set(column, aValue);
    fireDataUpdated(row, column);
  }

  public List getRowDataAt(int rowIndex) {
    return dataList.get(rowIndex);
  }

  protected void setRowDataAt(int rowIndex, Object[] data) {
    dataList.set(rowIndex, new ArrayList<Object>(Arrays.asList(data)));
    fireDataUpdated(rowIndex, 0, rowIndex, getColumnCount(), false);
  }

  //
  // Data change event
  //

  @Override
  public void addValueChangeListener(Consumer<GridSheetDataEvent> l) {
    dataUpdateListeners.add(l);
  }

  @Override
  public void removeValueChangeListener(Consumer<GridSheetDataEvent> l) {
    dataUpdateListeners.remove(l);
  }

  protected void fireDataUpdated(int row, int column) {
    if (adjusting) {
      markAsDirty(row, column);
    } else {
      if (!dataUpdateListeners.isEmpty()) {
        GridSheetDataEvent e = new GridSheetDataEvent(this, row, column, row, column);
        for (Consumer<GridSheetDataEvent> l : dataUpdateListeners) {
          l.accept(e);
        }
      }
    }
  }

  protected void fireDataUpdated(int firstRow, int firstColumn, int lastRow, int lastColumn,
      boolean structureChanged) {
    if (adjusting) {
      markAsDirty(firstRow, firstColumn);
      markAsDirty(lastRow, lastColumn);
      markStructureChanged(structureChanged);
    } else {
      if (!dataUpdateListeners.isEmpty()) {
        GridSheetDataEvent e = new GridSheetDataEvent(this, firstRow, firstColumn, lastRow,
            lastColumn, structureChanged);
        for (Consumer<GridSheetDataEvent> l : dataUpdateListeners) {
          l.accept(e);
        }
      }
    }
  }

  /**
   * @param adjusting the adjusting to set
   */
  public void setAdjusting(boolean adjusting) {
    boolean old = this.adjusting;
    this.adjusting = adjusting;
    if (old != adjusting && !adjusting) {
      if (!dataUpdateListeners.isEmpty()) {
        GridSheetDataEvent e =
            new GridSheetDataEvent(this, firstAdjustedRowIndex, firstAdjustedColumnIndex,
                lastAdjustedRowIndex, lastAdjustedColumnIndex, adjustdStructureChanged);
        for (Consumer<GridSheetDataEvent> l : dataUpdateListeners) {
          l.accept(e);
        }
      }
      firstAdjustedRowIndex = MAX;
      firstAdjustedColumnIndex = MAX;
      lastAdjustedRowIndex = MIN;
      lastAdjustedColumnIndex = MIN;
      adjustdStructureChanged = false;
    }
  }

  // Updates first and last change indices
  private void markAsDirty(int r, int c) {
    if (r == -1 || c == -1) {
      return;
    }
    firstAdjustedRowIndex = Math.min(firstAdjustedRowIndex, r);
    lastAdjustedRowIndex = Math.max(lastAdjustedRowIndex, r);
    firstAdjustedColumnIndex = Math.min(firstAdjustedColumnIndex, c);
    lastAdjustedColumnIndex = Math.max(lastAdjustedColumnIndex, c);
  }

  private void markStructureChanged(boolean structureChanged) {
    adjustdStructureChanged = structureChanged || adjustdStructureChanged;
  }

  //
  // Reflect structure change to data model.
  //

  protected void insertColumnData(int index, int numColumns) {
    int rowCount = getRowCount();
    for (int r = 0; r < rowCount; r++) {
      Object[] elements = new Object[numColumns];
      Arrays.fill(elements, defaultValue);
      dataList.get(r).addAll(index, Arrays.asList(elements));
    }
    fireDataUpdated(0, index, GridSheetDataEvent.TO_THE_END, GridSheetDataEvent.TO_THE_END, true);
  }

  protected void deleteColumnData(int index, int numColumns) {
    int rowCount = getRowCount();
    for (int r = 0; r < rowCount; r++) {
      dataList.get(r).subList(index, index + numColumns).clear();
    }
    fireDataUpdated(0, index, GridSheetDataEvent.TO_THE_END, GridSheetDataEvent.TO_THE_END, true);
  }

  protected void insertRowData(int index, int numRows) {
    int columnCount = getColumnCount();
    List[] newData = new List[numRows];
    for (int i = 0; i < newData.length; i++) {
      Object[] elements = new Object[columnCount];
      Arrays.fill(elements, defaultValue);
      newData[i] = new ArrayList<>(Arrays.asList(elements));
    }
    dataList.addAll(index, Arrays.asList(newData));
    fireDataUpdated(index, 0, GridSheetDataEvent.TO_THE_END, GridSheetDataEvent.TO_THE_END, true);
  }

  protected void deleteRowData(int index, int numRows) {
    dataList.subList(index, index + numRows).clear();
    fireDataUpdated(index, 0, GridSheetDataEvent.TO_THE_END, GridSheetDataEvent.TO_THE_END, true);
  }


  // ////////////////////////////////////////////////////////////////////////////////
  // Structure
  // ////////////////////////////////////////////////////////////////////////////////

  private List<Consumer<GridSheetStructureEvent>> structureChangelistenerList = new ArrayList<>();

  private List<GridSheetColumn> columns;
  private List<GridSheetRow> rows;

  @Getter
  @Setter
  private int minColumnWidth = 8;
  @Getter
  @Setter
  private int maxColumnWidth = 1000;
  @Getter
  @Setter
  private int minRowHeight = 1;
  @Getter
  @Setter
  private int maxRowHeight = 300;
  @Getter
  @Setter
  private int defaultColumnWidth = 40;
  @Getter
  @Setter
  private int defaultRowHeight = 17;

  private int totalColumnWidth = -1;
  private int totalRowHeight = -1;

  @Override
  public GridSheetColumn getColumn(int index) {
    return columns.get(index);
  }

  @Override
  public GridSheetRow getRow(int index) {
    return rows.get(index);
  }

  /**
   * @return the columns
   */
  public List<GridSheetColumn> getColumns() {
    return Collections.unmodifiableList(columns);
  }

  /**
   * @return the rows
   */
  public List<GridSheetRow> getRows() {
    return Collections.unmodifiableList(rows);
  }

  @Override
  public int getColumnCount() {
    return columns.size();
  }

  @Override
  public int getRowCount() {
    return rows.size();
  }

  @Override
  public void addColumn(GridSheetColumn column) {
    insertColumn(getColumnCount(), column);
  }

  @Override
  public void addColumn(GridSheetColumn[] column) {
    insertColumn(getColumnCount(), column);
  }

  @Override
  public void addColumn(int numColumns) {
    insertColumn(getColumnCount(), numColumns);
  }

  @Override
  public void insertColumn(int index, GridSheetColumn column) {
    columns.add(index, column);
    fireColumnsInserted(index, new GridSheetColumn[] {column});
  }

  @Override
  public void insertColumn(int index, GridSheetColumn[] column) {
    columns.addAll(index, Arrays.asList(column));
    fireColumnsInserted(index, column);
  }

  @Override
  public void insertColumn(int index, int numColumns) {
    GridSheetColumn[] column = new GridSheetColumn[numColumns];
    for (int i = 0; i < column.length; i++) {
      column[i] = createDefaultColumn();
    }
    insertColumn(index, column);
  }

  @Override
  public GridSheetColumn deleteColumn(int index) {
    GridSheetColumn column = columns.remove(index);
    fireColumnsDeleted(index, new GridSheetColumn[] {column});
    return column;
  }

  public GridSheetColumn[] deleteColumn(int index, int numColumns) {
    GridSheetColumn[] arrayColumnsRemoved = new GridSheetColumn[numColumns];
    for (int i = 0; i < arrayColumnsRemoved.length; i++) {
      arrayColumnsRemoved[i] = columns.get(index + i);
    }
    columns.subList(index, index + numColumns).clear();
    fireColumnsDeleted(index, arrayColumnsRemoved);
    return arrayColumnsRemoved;
  }

  @Override
  public void addRow(GridSheetRow row) {
    insertRow(getRowCount(), row);
  }

  @Override
  public void addRow(GridSheetRow[] row) {
    insertRow(getRowCount(), row);
  }

  @Override
  public void addRow(int numRows) {
    insertRow(getRowCount(), numRows);
  }

  @Override
  public void insertRow(int index, GridSheetRow row) {
    rows.add(index, row);
    fireRowsInserted(index, new GridSheetRow[] {row});
  }

  @Override
  public void insertRow(int index, GridSheetRow[] row) {
    rows.addAll(index, Arrays.asList(row));
    fireRowsInserted(index, row);
  }

  @Override
  public void insertRow(int index, int numRows) {
    GridSheetRow[] row = new GridSheetRow[numRows];
    for (int i = 0; i < row.length; i++) {
      row[i] = createDefaultRow();
    }
    insertRow(index, row);
  }

  @Override
  public GridSheetRow deleteRow(int index) {
    GridSheetRow row = rows.remove(index);
    fireRowsDeleted(index, new GridSheetRow[] {row});
    return row;
  }

  public GridSheetRow[] deleteRow(int index, int numRows) {
    GridSheetRow[] arrayRowsRemoved = new GridSheetRow[numRows];
    for (int i = 0; i < arrayRowsRemoved.length; i++) {
      arrayRowsRemoved[i] = rows.get(index + i);
    }
    rows.subList(index, index + numRows).clear();
    fireRowsDeleted(index, arrayRowsRemoved);
    return arrayRowsRemoved;
  }

  // Width and Heidht ---------------------------

  @Override
  public int getTotalColumnWidth() {
    if (totalColumnWidth == -1) {
      totalColumnWidth = 0;
      for (int i = 0; i < columns.size(); i++) {
        totalColumnWidth += columns.get(i).getWidth();
      }
    }
    return totalColumnWidth;
  }

  protected void invalidateWidthCache() {
    totalColumnWidth = -1;
  }

  @Override
  public int getTotalRowHeight() {
    if (totalRowHeight == -1) {
      totalRowHeight = 0;
      for (int i = 0; i < rows.size(); i++) {
        totalRowHeight += rows.get(i).getHeight();
      }
    }
    return totalRowHeight;
  }

  protected void invalidateHeightCache() {
    totalRowHeight = -1;
  }

  // Name ------------------------
  public String getColumnName(int column) {
    return String.valueOf(column + 1);
  }

  public String getRowName(int row) {
    return String.valueOf(row + 1);
  }

  // Events -------------------------

  @Override
  public void addStructureChangeListener(Consumer<GridSheetStructureEvent> l) {
    structureChangelistenerList.add(l);
  }

  @Override
  public void removeStructureChangeListener(Consumer<GridSheetStructureEvent> l) {
    structureChangelistenerList.remove(l);
  }


  protected void fireColumnsInserted(int index, GridSheetColumn[] columnsInserted) {
    insertColumnData(index, columnsInserted.length);
    invalidateWidthCache();
    if (!structureChangelistenerList.isEmpty()) {
      GridSheetStructureEvent e =
          new GridSheetStructureEvent(this, GridSheetStructureEvent.INSERT_COLUMN, adjusting, index,
              columnsInserted.length, getRowCount(), getColumnCount());
      for (Consumer<GridSheetStructureEvent> l : structureChangelistenerList) {
        l.accept(e);
      }
    }
  }

  protected void fireColumnsDeleted(int index, GridSheetColumn[] columnsRemoved) {
    deleteColumnData(index, columnsRemoved.length);
    invalidateWidthCache();
    if (!structureChangelistenerList.isEmpty()) {
      GridSheetStructureEvent e =
          new GridSheetStructureEvent(this, GridSheetStructureEvent.REMOVE_COLUMN, adjusting, index,
              columnsRemoved.length, getRowCount(), getColumnCount());
      for (Consumer<GridSheetStructureEvent> l : structureChangelistenerList) {
        l.accept(e);
      }
    }
  }

  protected void fireRowsInserted(int index, GridSheetRow[] rowsInserted) {
    insertRowData(index, rowsInserted.length);
    invalidateHeightCache();
    if (!adjusting) {
      if (!structureChangelistenerList.isEmpty()) {
        GridSheetStructureEvent e =
            new GridSheetStructureEvent(this, GridSheetStructureEvent.INSERT_ROW, adjusting, index,
                rowsInserted.length, getRowCount(), getColumnCount());
        for (Consumer<GridSheetStructureEvent> l : structureChangelistenerList) {
          l.accept(e);
        }
      }
    }
  }

  protected void fireRowsDeleted(int index, GridSheetRow[] rowsRemoved) {
    deleteRowData(index, rowsRemoved.length);
    invalidateHeightCache();
    if (!structureChangelistenerList.isEmpty()) {
      GridSheetStructureEvent e =
          new GridSheetStructureEvent(this, GridSheetStructureEvent.REMOVE_ROW, adjusting, index,
              rowsRemoved.length, getRowCount(), getColumnCount());
      for (Consumer<GridSheetStructureEvent> l : structureChangelistenerList) {
        l.accept(e);
      }
    }
  }

  public void fireVisibleColumnsUpdated() {
    invalidateWidthCache();
    fireStructureChanged(GridSheetStructureEvent.UPDATE_VISIBLE_COLUMNS);
  }

  public void fireVisibleRowsUpdated() {
    invalidateHeightCache();
    fireStructureChanged(GridSheetStructureEvent.UPDATE_VISIBLE_ROWS);
  }

  public void fireWidthUpdated() {
    invalidateWidthCache();
    fireStructureChanged(GridSheetStructureEvent.UPDATE_WIDTH);
  }

  public void fireHeightUpdated() {
    invalidateHeightCache();
    fireStructureChanged(GridSheetStructureEvent.UPDATE_HEIGHT);
  }

  protected void fireStructureChanged(int type) {
    if (!structureChangelistenerList.isEmpty()) {
      GridSheetStructureEvent e = new GridSheetStructureEvent(this, type, adjusting);
      for (Consumer<GridSheetStructureEvent> l : structureChangelistenerList) {
        l.accept(e);
      }
    }
  }

  protected GridSheetColumn createDefaultColumn() {
    return new GridSheetColumn(defaultColumnWidth, this);
  }

  protected GridSheetRow createDefaultRow() {
    return new GridSheetRow(defaultRowHeight, this);
  }

  // for SmoothCSV ////////////////////////////////////////

  public int getColumnCountAt(int rowIndex) {
    return dataList.get(rowIndex).size();
  }

  public void sort(int[] order) {
    int len = dataList.size();
    if (len != order.length) {
      throw new IllegalArgumentException();
    }

    List[] newData = new List[len];
    for (int i = 0; i < order.length; i++) {
      newData[order[i]] = dataList.get(i);
    }
    dataList = new ArrayList<List>(Arrays.asList(newData));

    GridSheetRow[] newRows = new GridSheetRow[len];
    for (int i = 0; i < order.length; i++) {
      newRows[order[i]] = rows.get(i);
    }
    rows = new ArrayList<GridSheetRow>(Arrays.asList(newRows));

    fireStructureChanged(GridSheetStructureEvent.SORT_ROWS);
  }

  public void sort(int[] order, int[] targetRows) {
    int len = dataList.size();
    if (len < order.length) {
      throw new IllegalArgumentException();
    } else if (order.length != targetRows.length) {
      throw new IllegalArgumentException();
    }

    // TODO improve
    List<List> targetDataList = new ArrayList<>();
    for (int i = 0; i < targetRows.length; i++) {
      int r = targetRows[i];
      targetDataList.add(dataList.get(r));
    }
    List[] newTargetData = new List[len];
    for (int i = 0; i < order.length; i++) {
      newTargetData[order[i]] = targetDataList.get(i);
    }
    for (int i = 0; i < targetRows.length; i++) {
      int r = targetRows[i];
      dataList.set(r, newTargetData[i]);
    }

    List<GridSheetRow> targetRowList = new ArrayList<>();
    for (int i = 0; i < targetRows.length; i++) {
      int r = targetRows[i];
      targetRowList.add(rows.get(r));
    }
    GridSheetRow[] newTargetRowList = new GridSheetRow[len];
    for (int i = 0; i < order.length; i++) {
      newTargetRowList[order[i]] = targetRowList.get(i);
    }
    for (int i = 0; i < targetRows.length; i++) {
      int r = targetRows[i];
      rows.set(r, newTargetRowList[i]);
    }

    fireStructureChanged(GridSheetStructureEvent.SORT_ROWS);
  }


  public void sort(int[] order, CellRect targetCells) {
    setAdjusting(true);

    List<List> targetDataList = new ArrayList<>(targetCells.getNumRows());
    for (int r = targetCells.getRow(); r <= targetCells.getLastRow(); r++) {
      List rowData = new ArrayList(targetCells.getNumColumns());
      for (int c = targetCells.getColumn(); c <= targetCells.getLastColumn(); c++) {
        Object v = getValueAt(r, c);
        rowData.add(v);
      }
      targetDataList.add(rowData);
    }
    List[] newTargetData = new List[targetCells.getNumRows()];
    for (int i = 0; i < order.length; i++) {
      newTargetData[order[i]] = targetDataList.get(i);
    }
    for (int r = 0; r < targetCells.getNumRows(); r++) {
      for (int c = 0; c < targetCells.getNumColumns(); c++) {
        getRowDataAt(r + targetCells.getRow()).set(c + targetCells.getColumn(),
            newTargetData[r].get(c));
      }
    }

    fireDataUpdated(targetCells.getRow(), targetCells.getColumn());
    fireDataUpdated(targetCells.getLastRow(), targetCells.getLastColumn());
    setAdjusting(false);
  }
}
