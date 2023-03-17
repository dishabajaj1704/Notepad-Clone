import java.util.Date;
import java.text.SimpleDateFormat;

public class DateTime {
    Ui ref;

    DateTime(Ui ref) {
        this.ref = ref;
        int currentCaretPosition = ref.ta.getCaretPosition();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        ref.ta.insert(formatter.format(date), currentCaretPosition);
    }
}
