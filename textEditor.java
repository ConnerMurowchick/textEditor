import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;
public class textEditor implements ActionListener {
     // menubar
    static JMenuBar mb;
    // text area
    static JTextArea jt;
 
    // JMenu
    static JMenu fileM, editM, formatM, x1;

    // Menu items
    static JMenuItem fileNew, fileOpen, fileSave, fileSaveAs, s1, s2,
    editUndo, editCut, editCopy, editPaste,
    formatFont, formatWordWrap, formatFontSize;

    // create a frame
    static JFrame f;

    // a label
    static JLabel l;
    public static void main(String args[]) {
        createWindow();
    }
    // NEED TO REFACTOR THIS INTO MULTIPLE METHODS FOR CLARITY 
    private static void createWindow() {
         // create an object of the class
         textEditor te = new textEditor();
         // create a frame
         f = new JFrame("Text Editor");
         // create a label
         l = new JLabel("no task ");
         jt = new JTextArea("hello",10, 10);
         jt.setBounds(0,0, 800,800);
         f.setLayout(new FlowLayout());
         f.add(jt);
         // create a menubar
         mb = new JMenuBar();
         // create a menu
         fileM = new JMenu("File");
         editM = new JMenu("Edit");
         formatM = new JMenu("Format");
         x1 = new JMenu("submenu");
         // create menuitems
         fileNew = new JMenuItem("New");
         fileOpen = new JMenuItem("Open");
         fileSave = new JMenuItem("Save");
         fileSaveAs = new JMenuItem("Save As");
         editUndo = new JMenuItem("Undo");
         editCut = new JMenuItem("Cut");
         editCopy = new JMenuItem("Copy");
         editPaste = new JMenuItem("Paste");
         formatFont = new JMenuItem("Font");
         formatWordWrap = new JMenuItem("Word Wrap");
         formatFontSize = new JMenuItem("Font Size");
         s1 = new JMenuItem("SubMenuItem1");
         s2 = new JMenuItem("SubMenuItem2");
         // add ActionListener to menuItems
         fileNew.addActionListener(te);
         fileOpen.addActionListener(te);
         fileSave.addActionListener(te);
         fileSaveAs.addActionListener(te);
         s1.addActionListener(te);
         s2.addActionListener(te);
         // add menu items to menu
         fileM.add(fileNew);
         fileM.add(fileOpen);
         fileM.add(fileSave);
         fileM.add(fileSaveAs);
         editM.add(editUndo);
         editM.add(editCut);
         editM.add(editCopy);
         editM.add(editPaste);
         formatM.add(formatFont);
         formatM.add(formatWordWrap);
         formatM.add(formatFontSize);
         x1.add(s1);
         x1.add(s2);
         // add submenu
         fileM.add(x1);
         // add menu to menu bar
         mb.add(fileM);
         mb.add(editM);
         mb.add(formatM);
         // add menubar to frame
         f.setJMenuBar(mb);
         // add label
         f.add(l);
         // set the size of the frame
         f.setSize(500, 500);
         f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        // set the label to the menuItem that is selected
        l.setText(s + " selected");
    }
    
}
