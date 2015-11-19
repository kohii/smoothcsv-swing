package com.smoothcsv.swing.gridsheet;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JScrollPane;

import lombok.Getter;

import com.smoothcsv.swing.components.LineBreakableTextField;

@SuppressWarnings("serial")
public class GridSheetCellStringEditor extends AbstractCellEditor implements GridSheetCellEditor {

  @Getter
  protected GridSheetTable table;
  private LineBreakableTextField editorComponent;
  private JScrollPane scrollPane;

  protected int clickCountToStart = 2;

  public GridSheetCellStringEditor(GridSheetTable gridTable) {
    this.table = gridTable;
    editorComponent = createTextComponent();
    scrollPane =
        new JScrollPane(editorComponent, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    editorComponent.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 0));
    scrollPane.setBorder(null);
    scrollPane.setViewportBorder(null);
  }

  @Override
  public boolean prepare(GridSheetTable table, Object value, boolean isSelected, int row, int column) {
    editorComponent.setText(value == null ? "" : value.toString());
    return true;
  }

  @Override
  public String getCellEditorValue() {
    return editorComponent.getText();
  }

  @Override
  public JComponent getEditorComponent() {
    return editorComponent;
  }

  @Override
  public JComponent getOuterEditorComponent() {
    return scrollPane;
  }

  @Override
  public boolean isCellEditable(EventObject e) {
    if (e instanceof MouseEvent) {
      return ((MouseEvent) e).getClickCount() >= clickCountToStart;
    }
    return true;
  }

  protected GridTableTextField createTextComponent() {
    return new GridTableTextField(this);
  }

  public static class GridTableTextField extends LineBreakableTextField {

    protected GridSheetCellStringEditor editor;

    public GridTableTextField(GridSheetCellStringEditor editor) {
      super(false);
      this.editor = editor;

      // setLineWrap(true);
      // setDocument(new PlainDocument() {
      // @Override
      // public void insertString(int offs, String str, AttributeSet a)
      // throws BadLocationException {
      // super.insertString(offs,
      // StringUtils.convertLineSeparater(str, "\r"), a);
      // }
      // });
      // SwingUtils.setKeyAction(this, insertBreakKeys, new AbstractAction("insert-break") {
      //
      // @Override
      // public void actionPerformed(ActionEvent e) {
      // // if (KeyMacroRecorder.isRecording()) {
      // // KeyMacroRecorder.getInstance()
      // // .put(GridSheetCellStringEditor.class,
      // // "insert-break");
      // // }
      // replaceSelection("\r");
      // }
      // });
      //
      // SwingUtils.setKeyAction(this, KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0),
      // new AbstractAction() {
      // @Override
      // public void actionPerformed(ActionEvent e) {
      // quickEdit = false;
      // }
      // });
      //
      // addMouseListener(new MouseAdapter() {
      // @Override
      // public void mousePressed(MouseEvent mouseevent) {
      // quickEdit = false;
      // }
      // });

      // SwingUtils.setKeyAction(this, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
      // new AbstractAction() {
      // @Override
      // public void actionPerformed(ActionEvent e) {
      // setQuickEdit(false);
      // editor.stopCellEditing();
      // }
      // }, JComponent.WHEN_FOCUSED);

    }

    // @Override
    // public boolean processKeyBinding(KeyStroke ks, KeyEvent e, int condition, boolean pressed) {
    // InputMap map = getInputMap(condition);
    // ActionMap am = getActionMap();
    // if (map != null && am != null && isEnabled()) {
    // Object binding = map.get(ks);
    // Action action = (binding == null) ? null : am.get(binding);
    // if (action != null) {
    // if (quickEdit) {
    // if (binding.toString().equals("caret-backward")) {
    // stopCellEditing();
    // invokeAction("selectPreviousColumn", KeyEvent.VK_LEFT);
    // // if (KeyMacroRecorder.isRecording()) {
    // // KeyMacroRecorder.getInstance()
    // // .put(GridSheetTable.class,
    // // "selectPreviousColumn");
    // // }
    // return true;
    // } else if (binding.toString().equals("caret-forward")) {
    // stopCellEditing();
    // invokeAction("selectNextColumn", KeyEvent.VK_RIGHT);
    // // if (KeyMacroRecorder.isRecording()) {
    // // KeyMacroRecorder.getInstance().put(
    // // GridSheetTable.class, "selectNextColumn");
    // // }
    // return true;
    // }
    // }
    // if (action instanceof DefaultKeyTypedAction) {
    // isKeyEvent = true;
    // }
    // boolean ret = SwingUtilities.notifyAction(action, ks, e, this, e.getModifiers());
    // if (ret) {
    // // if (KeyMacroRecorder.isRecording()) {
    // // if (action instanceof DefaultKeyTypedAction) {
    // // isKeyEvent = true;
    // // } else {
    // // KeyMacroRecorder.getInstance().put(
    // // GridSheetCellStringEditor.class,
    // // binding);
    // // }
    // // }
    //
    // }
    // isKeyEvent = false;
    // return ret;
    //
    // }
    // }
    // return false;
    // }

    // private void invokeAction(String key, int keyCode) {
    // Action action = gridTable.getActionMap().get(key);
    // KeyStroke ks = KeyStroke.getKeyStroke(keyCode, 0, false);
    // KeyEvent event =
    // new KeyEvent(gridTable, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode,
    // KeyEvent.CHAR_UNDEFINED);
    // SwingUtilities.notifyAction(action, ks, event, gridTable, 0);
    // }

    @Override
    public void replaceSelection(String content) {
      // if (KeyMacroRecorder.isRecording() && isKeyEvent) {
      // KeyMacroRecorder.getInstance().put(
      // GridSheetCellStringEditor.class, "type",
      // StringUtils.convertLineSeparater(content, "\\n"));
      // }
      super.replaceSelection(content);
    }
  }
}
