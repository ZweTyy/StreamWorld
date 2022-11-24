import javax.swing.*;
public class Serier {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Serier!");
    public Serier (){
        label.setBounds(100,0,100,50);

        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
