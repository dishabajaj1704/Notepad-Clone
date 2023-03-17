public class NewFile {
    Ui ref;

    NewFile(Ui ref) {
        this.ref = ref;
        if (ref.ta.getText().equals("")) {
            ref.dispose();
            new Ui();
        } else {
            new SaveDialog(ref);
        }
    }
}
