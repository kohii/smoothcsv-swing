/**
 * 
 */
package com.smoothcsv.swing.gridsheet.model;

/**
 * @author kohii
 *
 */
public interface IGridSheetData {

  Object getValueAt(int row, int column) ;
  
  void setValueAt(Object aValue, int row, int column);

}
