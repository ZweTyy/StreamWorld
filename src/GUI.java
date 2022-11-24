import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame frame = new JFrame();
    JButton button1 = new JButton("Serier");
    public GUI (){
        button1.setBounds(100, 50, 200, 40);
        button1.setFocusable(false);
        button1.addActionListener(this);

        frame.add(button1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            frame.dispose();
            Serier serieSide = new Serier();
        }
    }
}
