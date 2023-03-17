
import java.awt.*;
import java.io.*;
import java.nio.file.Files;

public class SaveDemo extends Frame {
    Ui uiref;

    public SaveDemo(Ui ref) {
        this.uiref = ref;
        FileDialog fd = new FileDialog(this, "Save File", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getDirectory() != null && fd.getFile() != null) {
            uiref.directory = fd.getDirectory();
            uiref.fileName = fd.getFile();

            String text = ref.ta.getText();
            byte b[] = text.getBytes();
            File f = new File(fd.getDirectory() + fd.getFile());

            ref.setTitle(fd.getFile());
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
