import javax.swing.*;

public class Window {
    private JFrame frame;
    private JPanel MainPanel;
    private JScrollBar scrollBar1;
    private JComboBox comboBox1;
    private JPanel NavPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel Filter;

    public Window() {
        frame = new JFrame();
        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
