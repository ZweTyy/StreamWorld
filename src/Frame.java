import java.awt.*;
import java.awt.event.*;
import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Frame extends JFrame {
    JComboBox comboBoxs;
    JPanel mainPanel;
    JPanel topPanel;
    JPanel lowerPanel;
    JLabel label1;
    JLabel label2;
    JButton button1;
    JButton button2;
    Frame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640,400);

        String[] genres = {"Crime", "War", "Drama", "Family", "Romance", "Sci-fi", "Talk-show", "Documentary", "Action", "Adventure",
                "Comedy", "Fantasy", "Animation", "Horror", "Thriller", "Mystery", "Biography", "History", "Western", "Sport"};
        comboBoxs = new JComboBox(genres);

        mainPanel = new JPanel();
        mainPanel.setBorder(new TitledBorder(("Panel Caption")));
        mainPanel.setLayout(new GridLayout(1,2));

        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        button1 = new JButton("Hej");
        button2= new JButton("Dig");
        topPanel.add(button1);
        topPanel.add(button2);

        lowerPanel = new JPanel();
        lowerPanel.setLayout(null);

        this.add(topPanel, BorderLayout.NORTH);
        // this.add(lowerPanel);

        this.setVisible(true);
    }
}
