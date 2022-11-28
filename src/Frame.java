import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame {
    Frame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] genres = {"Crime", "War", "Drama", "Family", "Romance", "Sci-fi", "Talk-show", "Documentary", "Action", "Adventure",
                "Comedy", "Fantasy", "Animation", "Horror", "Thriller", "Mystery", "Biography", "History", "Western", "Sport"};
        JComboBox comboBoxs = new JComboBox(genres);

        this.add(comboBoxs);
        this.pack();
        this.setVisible(true);
    }
}
