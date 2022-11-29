import javax.swing.*;
import java.awt.*;

public class TestGUI {
    private JFrame Frame;
    private JPanel MainPanel;
    private JPanel NavPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JComboBox comboBox1;
    private JPanel Editor;

    public TestGUI() {
        Frame = new JFrame();
        Frame.setSize(1920,1080);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setVisible(true);
        Frame.setContentPane(MainPanel);
    }
}
