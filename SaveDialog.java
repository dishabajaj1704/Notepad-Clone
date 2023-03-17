import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SaveDialog extends Frame {
    SaveDialog(Ui ref) {
        new SampleDialog(ref, this, "Save?");
    }
}

class SampleDialog extends Dialog implements ActionListener {
    Ui ref;
    
    Button yes, no;

    SampleDialog(Ui ref, Frame parent, String title) {

        super(parent, title, true); // true means modal and modeless for false
        this.ref = ref;
        setLayout(new FlowLayout());
        Label l = new Label("Do you want to save the content?");
        yes = new Button("Yes");
        no = new Button("No");

        add(l);
        add(yes);
        add(no);
        yes.addActionListener(this);
        no.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();

            }
        });
        setSize(300, 150);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == yes) {
            // System.out.println("Save dialog ka yes");
            new SaveFile(ref);
            dispose();
            ref.dispose();
            // new Ui();

        } else if (ae.getSource() == no) {
            // System.out.println("Save dialog ka no");
            ref.ta.setText("");
            dispose();
            ref.dispose();
        }
    }
}
