public class CopyPaste {
    Ui ref;
    // String text = "";

    CopyPaste(Ui ref) {
        this.ref = ref;
    }

    public void copy() {
        ref.selectedText = ref.ta.getSelectedText();
        // System.out.println(text);
    }

    public void paste() {
        int currentCaretPosition = ref.ta.getCaretPosition();
        ref.ta.insert(ref.selectedText, currentCaretPosition);
    }

    public void cut() {
        int currentCaretPosition = ref.ta.getCaretPosition();
        ref.selectedText = ref.ta.getSelectedText();
        int startindex = currentCaretPosition;
        // int startindex = ref.ta.getText().indexOf(ref.selectedText);
        ref.ta.replaceRange("", startindex, startindex + ref.selectedText.length());
    }

    public void delete() {
        String text = ref.ta.getSelectedText();
        int currentCaretPosition = ref.ta.getCaretPosition();
        int startindex = currentCaretPosition;
        // int startindex = ref.ta.getText().indexOf(text);
        ref.ta.replaceRange("", startindex, startindex + text.length());
    }

    public void selectAll() {
        String text = ref.ta.getText();
        int startIndex = ref.ta.getText().indexOf(text);
        ref.ta.requestFocus();
        ref.ta.select(startIndex, startIndex + text.length());

    }

}
