
/*
 * A Java swing CardLayout example
 */

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutExample extends JFrame implements ActionListener {

    public static CardLayout card = new CardLayout(40, 30);
    public static Container c;
    JButton jb1, jb2, jb3;

    public CardLayoutExample() {


        c = getContentPane();
        c.setLayout(card);

        // Define new buttons
        jb1 = new JButton("Button 1");
        jb2 = new JButton("Button 2");
        jb3 = new JButton("Button 3");

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);

        c.add(jb1);
        c.add(jb2);
        c.add(jb3);
    }


    // Action listener
    public void actionPerformed(ActionEvent e) {
        card.next(c);
    }

}