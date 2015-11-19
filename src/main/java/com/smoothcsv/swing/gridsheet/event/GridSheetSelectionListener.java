package com.smoothcsv.swing.gridsheet.event;

import java.util.EventListener;

public interface GridSheetSelectionListener extends EventListener {
  void selectionChanged(GridSheetSelectionEvent e);
}
