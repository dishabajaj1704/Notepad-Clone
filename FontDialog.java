import java.awt.*;
import java.awt.Font;
import java.awt.event.*;

public class FontDialog extends Frame {
    Ui ref;

    FontDialog(Ui ref) {
        this.ref = ref;
        System.out.println("Hello");
        new FontDialogDemo(ref, this, "Font");
    }
}

class FontDialogDemo extends Dialog implements ActionListener {
    Ui ref;
    Button set;
    Choice fontsList;
    int index;
    Panel p1, p2, p3;
    TextField sizetf;

    FontDialogDemo(Ui ref, Frame parent, String title) {

        super(parent, title); // true means modal and modeless for false
        System.out.println("FDDEMO");
        this.ref = ref;
        setLayout(new FlowLayout(FlowLayout.LEFT));

        Label fontL = new Label("Font");
        fontsList = new Choice();
        fontsList.add("Arial");
        fontsList.add("Courier");
        fontsList.add("Times New Roman");
        fontsList.add("Serif");
        fontsList.add("SansSerif");
        add(fontL);
        add(fontsList);

        Label sizeL = new Label("Size");
        sizetf = new TextField("11");
        add(sizeL);
        add(sizetf);

        set = new Button("Set");
        set.addActionListener(this);
        add(set);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                ref.fontd = false;
                dispose();

            }
        });

        setSize(200, 200);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == set) {
            // String data =fontsList.getItem(fontsList.getSelectedIndex());

            index = fontsList.getSelectedIndex();
            System.out.println(index);
            int size = 11;
            String sizeText = sizetf.getText();
            if (sizeText.equals("")) {
                sizeText = "11";
                size = Integer.parseInt(sizeText);
            } else {
                size = Integer.parseInt(sizeText);
            }

            System.out.println(sizeText);

            if (index == 0) {
                Font courier = new Font("Arial", Font.PLAIN, size);
                ref.ta.setFont(courier);
            } else if (index == 1) {
                Font courier = new Font("Courier", Font.PLAIN, size);
                ref.ta.setFont(courier);
            } else if (index == 2) {
                Font courier = new Font("Times New Roman", Font.PLAIN, size);
                ref.ta.setFont(courier);
            } else if (index == 3) {
                Font courier = new Font("Serif", Font.PLAIN, size);
                ref.ta.setFont(courier);
            } else if (index == 4) {
                Font courier = new Font("SansSerif", Font.PLAIN, size);
                ref.ta.setFont(courier);
            }

        }
    }
}
