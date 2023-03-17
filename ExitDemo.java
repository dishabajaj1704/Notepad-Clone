public class ExitDemo {
    Ui ref;

    ExitDemo(Ui ref) {
        this.ref = ref;
        String empty = "";
        if (!ref.ta.getText().isEmpty()) {
            new SaveDialog(ref);
            System.exit(0);

        } else {
            System.exit(0);
        }

    }
}
