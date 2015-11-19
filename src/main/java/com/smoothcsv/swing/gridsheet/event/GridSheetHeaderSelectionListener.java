package com.smoothcsv.swing.gridsheet.event;

import java.util.EventListener;

public interface GridSheetHeaderSelectionListener extends EventListener {

  void headersSelectionChanged(GridSheetHeaderSelectionEvent e);
}
