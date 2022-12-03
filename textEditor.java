import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
/********** TO DO ***************
 * Refactor code into more methods for better readability
 * Add a margin to the left and top of the text area
 * Make all menu buttons display something with actionlistener when clicked
 * Add functionality to all menu buttons
 * Make program exit on close
 */

 /*
  * NEXT: Make clicking the save button display something with actionlistener
  */
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
        l = new JLabel("no task ", 10);
        jt = new JTextArea();
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
        editUndo.addActionListener(te);
        editCut.addActionListener(te);
        editCopy.addActionListener(te);
        editPaste.addActionListener(te);
        formatFont.addActionListener(te);
        formatWordWrap.addActionListener(te);
        formatFontSize.addActionListener(te);
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
        // add label
        f.add(l);
        f.add(jt);
        f.pack();
        // add submenu
        fileM.add(x1);
        // add menu to menu bar
        mb.add(fileM);
        mb.add(editM);
        mb.add(formatM);
        // add menubar to frame
        f.setJMenuBar(mb);
        // set the size of the frame
        f.setSize(500, 500);
        f.setVisible(true);
        //f.setLayout(null);
        //f.setLayout(new BorderLayout());
    }
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        // set the label to the menuItem that is selected
        jt.setText(s + " selected");
        if(e.getSource() == fileSave) {
            SaveActionPerformed();
        }
    }
    public void SaveActionPerformed() {
        String name = "New File";
        ArrayList<String> Text = new ArrayList<String>();
        String jtS = jt.getText();
        Text.add(jtS);
    
        SaveFile(name, Text);
    } 
    public void SaveFile(String name, ArrayList< String> message) {

        String path = "C:\\Users\\Conner\\Desktop\\" + name + ".txt";
        File file1 = new File(path);
        try {
            if (!file1.exists()) {
                file1.createNewFile();
            }
            File[] files = file1.listFiles();
            FileWriter fw = new FileWriter(file1, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < message.size(); i++) {
                bw.write(message.get(i));
                bw.newLine();
            }
            bw.close();
            fw.close();
            FileReader fr = new FileReader(file1);
            BufferedReader br = new BufferedReader(fr);
            fw = new FileWriter(file1, true);
            bw = new BufferedWriter(fw);
            while (br.ready()) {
                String line = br.readLine();
                System.out.println(line);
                bw.write(line);
                bw.newLine();
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in" + ex);        
    }
    
}
}
