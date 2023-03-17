
import java.awt.*;
import java.io.*;

public class OpenDemo extends Frame {
    Ui uiref;

    public OpenDemo(Ui ref) {
        this.uiref = ref;
        FileDialog fd = new FileDialog(this, "Open File", FileDialog.LOAD);
        fd.setVisible(true);
        if (fd.getDirectory() != null && fd.getFile() != null) {

            File f = new File(fd.getDirectory() + fd.getFile());
            try {
                String text;
                ref.setTitle(fd.getFile());
                FileInputStream fi = new FileInputStream(f);
                BufferedReader br = new BufferedReader(new InputStreamReader(fi));
                ref.ta.setText("");
                while ((text = br.readLine()) != null) {
                    ref.ta.append(text += "\n");
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            } catch (IOException e) {
                System.out.println("Some Error occured!");
            }
        }
    }
}
