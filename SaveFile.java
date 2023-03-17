import java.io.*;

public class SaveFile {
    Ui ref;

    SaveFile(Ui ref) {

        // System.out.println("Save File cons");
        this.ref = ref;
        if (this.ref.saveFirst) {
            new SaveDemo(ref);
            this.ref.saveFirst = false;
        } else {
            System.out.println("Save Twice");
            String text = ref.ta.getText();
            byte b[] = text.getBytes();
            File f = new File(ref.directory + ref.fileName);
            try {

                FileOutputStream fo = new FileOutputStream(f);
                fo.write(b);
                fo.close();
            } catch (FileNotFoundException fe) {
                System.out.println("File not found!");
            } catch (IOException e) {
                System.out.println("Some Error occured!");
            }
        }
    }
}
