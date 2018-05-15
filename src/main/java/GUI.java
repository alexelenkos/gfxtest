import processing.core.PApplet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JTextField textField;
    private JButton button;
    private JPanel panel;
    static String str;

    public GUI() {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                str = textField.getText();
                PApplet.main("GFXTest");
            }
        });
    }

    public static String getStr(){
        return str;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,100);
        frame.setVisible(true);
    }
}
