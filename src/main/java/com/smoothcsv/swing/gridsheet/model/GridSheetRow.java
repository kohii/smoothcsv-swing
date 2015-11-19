package com.smoothcsv.swing.gridsheet.model;

public class GridSheetRow {


  private int height;

  private boolean visible = true;

  private GridSheetModel model;

  public GridSheetRow(int height) {
    this.height = height;
  }

  public GridSheetRow() {
    this(-1);
  }

  protected GridSheetRow(int height, GridSheetModel model) {
    this(height);
    this.model = model;
  }

  /**
   * @param model the model to set
   */
  void setModel(GridSheetModel model) {
    assert model != null;
    this.model = model;
    if (this.height == -1) {
      this.height = model.getDefaultRowHeight();
    }
  }

  void removeModel() {
    this.model = null;
  }

  public int getHeight() {
    return visible ? height : -1;
  }

  public void setHeight(int height) {
    int oldVal = this.height;
    this.height = Math.min(Math.max(height, model.getMinRowHeight()), model.getMaxRowHeight());
    if (oldVal != height) {
      model.fireHeightUpdated();
    }
  }

  public boolean isVisible() {
    return visible;
  }

  public void setVisible(boolean isVisible) {
    boolean oldVal = this.visible;
    this.visible = isVisible;
    if (oldVal != isVisible) {
      model.fireVisibleRowsUpdated();
    }
  }

  /**
   * @return the model
   */
  protected GridSheetModel getModel() {
    return model;
  }
}
