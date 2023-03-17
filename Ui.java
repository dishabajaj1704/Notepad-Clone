import java.awt.*;
import java.awt.event.*;

public class Ui extends Frame implements ActionListener, KeyListener {

    MenuItem save, open, new1, newWindow, date, saveAs, exit, find, findNext, findPrevious, copy, paste, cut, replace,
            delete;
    MenuItem selectAll, font;
    CheckboxMenuItem wordWrap;
    TextArea ta;
    boolean saveFirst = true;
    String directory, fileName;
    String selectedText = "";
    boolean csave = false;
    Ui ref = this;
    boolean saveD = false;
    FindDialog fdref;
    boolean fontd = false;
    int newWindowCount = 1;

    Ui() {

        super("Untitled");
        this.setLayout(new BorderLayout());
        ta = new TextArea("", 100, 100, TextArea.SCROLLBARS_VERTICAL_ONLY);
        this.add(ta, BorderLayout.CENTER);
        setSize(1000, 1000);
        setVisible(true);
        MenuBar mbar = new MenuBar();
        setMenuBar(mbar);

        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        // Menu view = new Menu("View");
        // Menu zoom = new Menu("Zoom");

        mbar.add(fileMenu);
        mbar.add(editMenu);
        // mbar.add(view); // first here we added sub so it was showing in menubar

        // In MenuItem - means separator
        new1 = new MenuItem("New");
        newWindow = new MenuItem("New Window");
        open = new MenuItem("Open");
        save = new MenuItem("Save");
        saveAs = new MenuItem("Save As");
        // MenuItem print = new MenuItem("Print");
        // MenuItem pageSetup = new MenuItem("PageSetUp");
        exit = new MenuItem("Exit");

        // MenuItem undo = new MenuItem("Undo");
        cut = new MenuItem("Cut");
        copy = new MenuItem("Copy");
        paste = new MenuItem("Paste");
        delete = new MenuItem("Delete");
        selectAll = new MenuItem("Select All");
        find = new MenuItem("Find");
        findNext = new MenuItem("Find Next");
        findPrevious = new MenuItem("Find Previous");
        replace = new MenuItem("Replace");
        // MenuItem goto1 = new MenuItem("Go to");
        date = new MenuItem("Time/Date");
        font = new MenuItem("Font");

        wordWrap = new CheckboxMenuItem("Word Wrap", true);
        // MenuItem zoomIn = new MenuItem("Zoom In");
        // MenuItem zoomOut = new MenuItem("Zoom out");

        // CheckboxMenuItem StatusBar = new CheckboxMenuItem("StatusBar", true);

        fileMenu.add(new1);
        fileMenu.add(newWindow);
        fileMenu.addSeparator();
        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.add(saveAs);
        fileMenu.addSeparator();
        // fileMenu.add(pageSetup);
        // fileMenu.add(print);
        // fileMenu.addSeparator();
        fileMenu.add(exit);

        delete.setEnabled(false);
        cut.setEnabled(false);
        copy.setEnabled(false);
        paste.setEnabled(false);
        delete.setEnabled(false);
        find.setEnabled(false);
        findNext.setEnabled(false);
        findPrevious.setEnabled(false);
        replace.setEnabled(false);
        selectAll.setEnabled(false);

        // editMenu.add(undo);
        // editMenu.addSeparator();
        editMenu.add(cut);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.add(delete);
        editMenu.addSeparator();
        editMenu.add(find);
        editMenu.add(findNext);
        editMenu.add(findPrevious);
        editMenu.add(replace);
        editMenu.add(date);
        editMenu.addSeparator();
        editMenu.add(selectAll);
        editMenu.addSeparator();
        editMenu.add(font);

        // zoom.add(zoomIn);
        // zoom.add(zoomOut);

        // view.add(zoom);
        // view.add(StatusBar);
        // view.add(wordWrap);

        saveAs.addActionListener(this);
        open.addActionListener(this);
        newWindow.addActionListener(this);
        findNext.addActionListener(this);
        findPrevious.addActionListener(this);
        new1.addActionListener(this);
        exit.addActionListener(this);
        ta.addKeyListener(this);
        save.addActionListener(this);
        find.addActionListener(this);
        copy.addActionListener(this);
        replace.addActionListener(this);
        cut.addActionListener(this);
        paste.addActionListener(this);
        delete.addActionListener(this);
        selectAll.addActionListener(this);
        date.addActionListener(this);
        font.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                if (!csave) {
                    new SaveDialog(ref);
                    csave = true;
                }
                newWindowCount--;
                if (newWindowCount > 1) {
                    dispose();
                } else {
                    dispose();
                }

                // System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        new Ui();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == save) {
            new SaveFile(this);
        } else if (ae.getSource() == open) {
            new OpenDemo(this);
        } else if (ae.getSource() == newWindow) {
            newWindowCount++;
            new Ui();
        } else if (ae.getSource() == exit) {
            new ExitDemo(this);
        } else if (ae.getSource() == save) {
            new SaveFile(this);
        } else if (ae.getSource() == saveAs) {
            new SaveDemo(this);
        } else if (ae.getSource() == new1) {
            new NewFile(this);
        } else if (ae.getSource() == find || ae.getSource() == replace || ae.getSource() == findNext ||
                ae.getSource() == findPrevious) {
            if (saveD == false) {
                new FindDemo(this);
                saveD = true;
            }
        } else if (ae.getSource() == copy) {
            CopyPaste cp = new CopyPaste(this);
            cp.copy();
        } else if (ae.getSource() == paste) {
            CopyPaste cp = new CopyPaste(this);
            cp.paste();
        } else if (ae.getSource() == cut) {
            CopyPaste cp = new CopyPaste(this);
            cp.cut();
        } else if (ae.getSource() == delete) {
            CopyPaste cp = new CopyPaste(this);
            cp.delete();
        } else if (ae.getSource() == selectAll) {
            CopyPaste cp = new CopyPaste(this);
            cp.selectAll();
        } else if (ae.getSource() == date) {
            new DateTime(this);
        } else if (ae.getSource() == font) {
            fontd = true;
            new Font(ref);
        }
        // else if (ae.getSource() == wordWrap) {
        // wrapOn = false;
        // Format_Text fm = new Format_Text(this);
        // fm.wrapText();
        // }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ta.getText() != null) {
            find.setEnabled(true);
            findNext.setEnabled(true);
            findPrevious.setEnabled(true);
            copy.setEnabled(true);
            paste.setEnabled(true);
            replace.setEnabled(true);
            delete.setEnabled(true);
            cut.setEnabled(true);
            selectAll.setEnabled(true);
            findNext.setEnabled(true);
        } else {
            find.setEnabled(false);
            findNext.setEnabled(false);
            findPrevious.setEnabled(false);
            copy.setEnabled(false);
            replace.setEnabled(false);
            cut.setEnabled(false);
            paste.setEnabled(false);
            delete.setEnabled(false);
            selectAll.setEnabled(false);
            findNext.setEnabled(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        csave = false;
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

}
