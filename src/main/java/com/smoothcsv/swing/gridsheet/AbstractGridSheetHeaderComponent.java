package com.smoothcsv.swing.gridsheet;

import javax.swing.JComponent;

import lombok.Getter;

@SuppressWarnings("serial")
public abstract class AbstractGridSheetHeaderComponent extends JComponent {

  //
  // Instance Variables
  //
  /**
   * The table for which this object is the header; the default is <code>null</code>.
   */
  @Getter
  protected final GridSheetPane gridSheetPane;

  /**
   * If true, resizing of rows are allowed by the user; the default is true.
   */
  protected boolean resizingAllowed;

  // /**
  // * The index of the row being resized. <code>null</code> if not resizing.
  // */
  // transient protected GridRow resizingRow;
  //
  // Constructors
  //
  public AbstractGridSheetHeaderComponent(GridSheetPane gridSheetPane) {
    this.gridSheetPane = gridSheetPane;
    setFocusable(false);
  }

  //
  // Local behavior attributes
  //
  /**
   * Sets whether the user can resize rows by dragging between headers.
   *
   * @param resizingAllowed true if table view should allow resizing
   * @see #getResizingAllowed
   */
  public void setResizingAllowed(boolean resizingAllowed) {
    boolean old = this.resizingAllowed;
    this.resizingAllowed = resizingAllowed;
    firePropertyChange("resizingAllowed", old, resizingAllowed);
  }

  /**
   * Returns true if the user is allowed to resize rows by dragging between their headers, false
   * otherwise. The default is true. You can resize rows programmatically regardless of this
   * setting.
   *
   * @return the <code>resizingAllowed</code> property
   * @see #setResizingAllowed
   */
  public boolean getResizingAllowed() {
    return resizingAllowed;
  }

  /**
   * Sizes the header and marks it as needing display. Equivalent to <code>revalidate</code>
   * followed by <code>repaint</code>.
   */
  public void resizeAndRepaint() {
    revalidate();
    repaint();
  }

  @Override
  public boolean requestFocusInWindow() {
    return gridSheetPane.getTable().requestFocusInWindow();
  }

  @Override
  public void requestFocus() {
    gridSheetPane.getTable().requestFocus();
  }
}
