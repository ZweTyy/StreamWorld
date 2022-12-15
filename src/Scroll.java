import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Scroll{

    public Scroll() {
        // Just defining my own colour hues
        Color blue = new Color(52, 72, 123);
        Color green = new Color(0, 255, 0);
        Color grey = new Color(166, 166, 166);
        Color red = new Color(255, 102, 102);

//         Create the JFrame
        JFrame f = new JFrame("World");
//        button will be added to this panel
        JPanel myPanel = new JPanel();

        // Creating the JButtons. They're added to the JFrame at the end of the code.
        JButton object0 = new JButton("Object");
        object0.setBounds(0, 0, 80, 80);
        object0.setBackground(red);

        JButton object1 = new JButton("Object");
        object1.setBounds(80, 80, 80, 80);
        object1.setBackground(red);

        // This just automatically adds the "Ground" buttons to the frame, as they are many of them.
        ArrayList<JButton> groundList = new ArrayList<JButton>();
        for (int i = 0; i < 19; i++) {
            groundList.add(new JButton("Ground"));
        }
        JButton temp;
        int x = 80;
        for (int i = 0; i < 19; i++) {
            temp = groundList.get(i);
            temp.setBounds(x, 0, 80, 80);
            temp.setBackground(green);
            myPanel.add(temp);
            x = x + 80;
        }
        ArrayList<JButton> groundList2 = new ArrayList<JButton>();
        for (int i = 0; i < 19; i++) {
            groundList2.add(new JButton("G2"));
        }
        JButton temp2;
        int y = 10;
        for (int i = 0; i < 19; i++) {
            temp2 = groundList2.get(i);
            temp2.setBounds(100, y, 80, 80);
            temp2.setBackground(green);
            myPanel.add(temp2);
            y+= 80;
        }

        JButton wall = new JButton("Wall");
        wall.setBounds(80, 160, 80, 80);
        wall.setBackground(grey);

        JButton avatar = new JButton("Avatar");
        avatar.setBounds(0, 80, 80, 80);
        avatar.setBackground(blue);

        myPanel.add(object0);
        myPanel.add(object1);
        myPanel.add(wall);
        myPanel.add(avatar);

        myPanel.setBackground(Color.ORANGE);

        //notice how the panel is dropped inside the scroll pane
        JScrollPane scroll = new JScrollPane(myPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);


//        finally add the scroll to frame's content pane .. which is more proper than adding to frame directly
        myPanel.setLayout( new GridLayout(10,2));

        f.getContentPane().add(scroll);
        f.setSize(800, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}