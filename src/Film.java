import javax.swing.*;

public class Film {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Film!");
    public Film (){
        label.setBounds(100,0,100,50);

        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
