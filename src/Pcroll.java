import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Pcroll {

    public Pcroll(ArrayList<Medie> arrFilm,ArrayList<Medie> arrSerier ){

        ArrayList<ArrayList<Medie>> arrMedie = new ArrayList<>(Arrays.asList(arrFilm,arrSerier));
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
        JButton object0 = new JButton("Min liste");
        object0.setBounds(0, 0, 80, 80);
        object0.setBackground(red);

        JButton object1 = new JButton("Serier");
        object1.setBounds(80, 80, 80, 80);
        object1.setBackground(red);

        JButton wall = new JButton("Film");
        wall.setBounds(80, 160, 80, 80);
        wall.setBackground(grey);

        JButton avatar = new JButton("Start");
        avatar.setBounds(0, 80, 100, 500);
        avatar.setBackground(blue);

//        myPanel.add(object0);
//        myPanel.add(object1);
//        myPanel.add(wall);
//        myPanel.add(avatar);

         ArrayList<JButton> arrBtnMedie = new ArrayList<>();

         ArrayList<JButton> arrBtnSerier = new ArrayList<>();

        for (Medie m : arrMedie.get(0)) {
            try {
                BufferedImage image = ImageIO.read(new File("src/forsider/"+m.titel+".jpg"));
                JButton picBtn = new JButton(new ImageIcon(image.getScaledInstance(200,300,Image.SCALE_SMOOTH)));
                picBtn.setBackground(new Color(255, 9, 9));
                picBtn.setBorder(null);
                arrBtnSerier.add(picBtn);
            } catch (Exception e) {
                System.out.println("Kunne ikke loade " + m.titel);
            }
        }

        for(int i = 0; i < arrBtnSerier.size(); i++) {
            //indlæser fra arrLabel og display hver film ud
            arrBtnSerier.get(i).setBackground(new Color(255, 204, 69));
            myPanel.add(arrBtnSerier.get(i));
//            filmPanel.add(arrLabelTitel.get(i));
        }

        myPanel.setBackground(new Color(35,35,35));

        //notice how the panel is dropped inside the scroll pane
        JScrollPane scroll = new JScrollPane(myPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        //        scroll.setVisible(true);
//        f.add(scroll);  // This adds the scroll bars but doesn't actually make them work.

//        finally add the scroll to frame's content pane .. which is more proper than adding to frame directly
        myPanel.setLayout( new GridLayout(20,5));
//        f.setLayout(null);
        JTextField searchBar = new JTextField();
        searchBar.addActionListener(searchBar.getAction());
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new BorderLayout());
        JPanel navPanel = new JPanel();
        navPanel.setBackground(Color.black);
        navPanel.setLayout(new GridLayout(1,5,20,10));
        navPanel.add(avatar);
        navPanel.add(wall);
        navPanel.add(object0);
        navPanel.add(object1);
        JLabel l = new JLabel("Søg",SwingConstants.RIGHT);
        l.setBounds(0,0,20,10);
        l.setForeground(Color.white);

        navPanel.add(l);
        navPanel.add(searchBar);


        JPanel showSearch = new JPanel();
        newPanel .add(showSearch);
        showSearch.setVisible(false);
        object0.addActionListener(e -> {
            System.out.println(searchBar.getText());
            JLabel word = new JLabel(searchBar.getText());
            showSearch.add(word);
            showSearch.setVisible(true);
            myPanel.setVisible(false);
        });

        newPanel.add(navPanel, BorderLayout.NORTH);
        newPanel.add(scroll, BorderLayout.CENTER);
        f.getContentPane().add(newPanel);
        f.setSize(1000, 800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}