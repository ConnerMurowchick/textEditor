import java.awt.*; 
import javax.swing.*; 
public class textEditor {
    public static main(String args[]) {
        createWindow();
    }
    private static void createWindow() {
        JFrame frame = new JFrame();
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Text Editor");
        frame.setVisible(true);
    }

}