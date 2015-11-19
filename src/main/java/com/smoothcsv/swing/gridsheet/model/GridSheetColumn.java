package com.smoothcsv.swing.gridsheet.model;

import java.util.Objects;

import lombok.Getter;

public class GridSheetColumn {

  private int width;

  private boolean visible = true;

  private GridSheetModel model;

  @Getter
  private String name;

  public GridSheetColumn(int width) {
    this.width = width;
  }

  public GridSheetColumn() {
    this(-1);
  }

  protected GridSheetColumn(int width, GridSheetModel model) {
    this(width);
    this.model = model;
  }

  /**
   * @param model the model to set
   */
  void setModel(GridSheetModel model) {
    assert model != null;
    this.model = model;
    if (this.width == -1) {
      this.width = model.getDefaultColumnWidth();
    }
  }

  void removeModel() {
    this.model = null;
  }

  public int getWidth() {
    return visible ? width : -1;
  }

  public void setWidth(int width) {
    int oldVal = this.width;
    this.width = Math.min(Math.max(width, model.getMinColumnWidth()), model.getMaxColumnWidth());
    if (oldVal != width) {
      model.fireWidthUpdated();
    }
  }

  public boolean isVisible() {
    return visible;
  }

  public void setVisible(boolean isVisible) {
    if (this.visible != isVisible) {
      this.visible = isVisible;
      model.fireVisibleColumnsUpdated();
    }
  }

  public void setName(String name) {
    if (Objects.equals(name, this.name)) {
      this.name = name;
      // model.fireVisibleColumnsUpdated(); TODO
    }
  }
}
