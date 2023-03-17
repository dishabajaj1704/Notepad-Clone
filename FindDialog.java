import java.awt.*;
import java.awt.event.*;

public class FindDialog extends Frame {
    Ui ref;

    FindDialog(Ui ref) {
        this.ref = ref;
        System.out.println("Hello");
        new SampleDialog1(ref, this, "Find & Replace");
    }
}

class SampleDialog1 extends Dialog implements ActionListener {
    Button yes, no;
    String textToFound = "";
    Button find, replaceAll, findNext, findPrev, replace;
    Ui ref;
    TextField find_tf, replace_tf;
    int startIndex;
    // boolean first = true;
    int fromIndex = -1;
    // int endIndex = -1;

    SampleDialog1(Ui ref, Frame parent, String title) {
        super(parent, title); // true means modal and modeless for false
        this.ref = ref;
        setLayout(new FlowLayout(FlowLayout.LEFT));
        Label l1 = new Label("Find");
        find_tf = new TextField(20);
        Label l2 = new Label("Replace");
        replace_tf = new TextField(20);
        find = new Button("Find");
        replace = new Button("Replace");
        replaceAll = new Button("Replace All");
        findNext = new Button("Find Next");
        findPrev = new Button("FindPrev");
        add(l1);
        add(find_tf);
        add(l2);
        add(replace_tf);
        add(find);
        add(replace);
        add(replaceAll);
        add(findNext);
        add(findPrev);

        find.addActionListener(this);
        replace.addActionListener(this);
        replaceAll.addActionListener(this);
        findPrev.addActionListener(this);
        findNext.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                ref.saveD = false;
                dispose();

            }
        });

        // if (ref.ta.getText().contains(textToFound)) {
        // // ref.ta.setSelec
        // }
        setSize(270, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == find) {
            textToFound = find_tf.getText();
            // System.out.println("Text to found:- " + textToFound);
            int startIndex = ref.ta.getText().indexOf(textToFound);
            // System.out.println("StartIndex:- " + startIndex);
            ref.ta.requestFocus();
            ref.ta.select(startIndex, startIndex + textToFound.length());
            int f = startIndex + textToFound.length();
            // System.out.println("SelectedText:- " + f);
            startIndex = startIndex + textToFound.length();
            // System.out.println(startindex + textToFound.length() - 1);

        } else if (ae.getSource() == replaceAll) {
            System.out.println("Replace All");
            String text = ref.ta.getText();
            String findText = find_tf.getText();
            String replaceText = replace_tf.getText();

            if (text.contains(findText) && !replaceText.equals("")) {
                System.out.println("hello fr");
                text = text.replaceAll(findText, replaceText);
                ref.ta.setText(text);

            } else {
                System.out.println("Not Found!");
            }
        } else if (ae.getSource() == replace) {
            String text = ref.ta.getText();
            String findText = find_tf.getText();
            String replaceText = replace_tf.getText();
            if (text.contains(findText) && !replaceText.equals("")) {
                String regex = findText;
                text = text.replaceFirst(regex, replaceText);
                ref.ta.setText(text);
                int rStartIndex = ref.ta.getText().indexOf(replaceText);
                ref.ta.requestFocus();
                ref.ta.select(rStartIndex, rStartIndex + replaceText.length());
            }

        } else if (ae.getSource() == findNext) {

            textToFound = find_tf.getText();
            if (fromIndex == -1) {
                fromIndex = 0;
            } else {
                startIndex = ref.ta.getText().replaceAll("\n", "").indexOf(textToFound, fromIndex);
                if (startIndex != -1) {
                    ref.ta.requestFocus();
                    ref.ta.select(startIndex, startIndex + textToFound.length());
                    fromIndex = startIndex + textToFound.length();
                } else {
                    fromIndex = 0;
                }
            }

        } else if (ae.getSource() == findPrev) {
            textToFound = find_tf.getText();
            if (fromIndex == -1) {
                fromIndex = ref.ta.getText().length() - 1;
            }

            startIndex = ref.ta.getText().replaceAll("\n", "").lastIndexOf(textToFound, fromIndex);
            System.out.println(startIndex);
            if (startIndex != -1) {
                ref.ta.requestFocus();
                ref.ta.select(startIndex, startIndex + textToFound.length());
                fromIndex = startIndex - textToFound.length();
            } else {
                fromIndex = 0;
            }

        }
    }

}
