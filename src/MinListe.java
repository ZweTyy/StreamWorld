import javax.swing.*;

public class MinListe {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Min Liste!");
    public MinListe (){
        label.setBounds(100,0,100,50);

        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
