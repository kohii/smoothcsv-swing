package com.smoothcsv.swing.gridsheet.event;

@SuppressWarnings("serial")
public class GridSheetHeaderSelectionEvent extends java.util.EventObject {

  private int firstIndex;
  private int lastIndex;
  private boolean isHeaderSelected;
  private boolean isAdjusting;

  public GridSheetHeaderSelectionEvent(Object source, int firstIndex, int lastIndex,
      boolean isHeaderSelected, boolean isAdjusting) {
    super(source);
    this.firstIndex = firstIndex;
    this.lastIndex = lastIndex;
    this.isHeaderSelected = isHeaderSelected;
    this.isAdjusting = isAdjusting;
  }

  public int getFirstIndex() {
    return firstIndex;
  }

  public int getLastIndex() {
    return lastIndex;
  }

  public boolean isHeaderSelected() {
    return isHeaderSelected;
  }

  public boolean getValueIsAdjusting() {
    return isAdjusting;
  }
}
