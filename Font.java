public class Font {
    Ui ref;

    Font(Ui ref) {
        this.ref = ref;
        new FontDialog(ref);
    }
}
