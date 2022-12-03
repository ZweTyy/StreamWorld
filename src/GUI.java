
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import  java.util.*;

public class GUI {
    // Opretter vores frame, panel og label instanser + alle knapper
    JFrame frame = new JFrame("Stream World");
    JPanel navPanel = new JPanel();
    JPanel forsidePanel = new JPanel();
    JPanel seriePanel = new JPanel();
    JPanel filmPanel = new JPanel();
    JPanel minListePanel = new JPanel();

    JPanel watchPanel = new JPanel();

    JButton titleBtn;
    JButton forsideBtn = new JButton("Forside");
    JButton serierBtn = new JButton("Serier");
    JButton filmBtn = new JButton("Film");
    JButton minListeBtn = new JButton("Min Liste");
    protected JLabel filmLabel;
    protected JLabel serieLabel = new JLabel("Serier!");
    protected JLabel listeLabel = new JLabel("Min Liste!");

//    Array list a film som knapper
    protected ArrayList<JButton> arrBtnMedie = new ArrayList<>();

    protected ArrayList<JButton> arrBtnSerier = new ArrayList<>();

    //Array liste af film titler
    protected ArrayList<JLabel> arrLabelTitel= new ArrayList<>();

    //Arrayliste af JPaneler undtagen navPanel. Brug til display metode.
    protected ArrayList<JPanel> arrPanel = new ArrayList<>(Arrays.asList(forsidePanel,seriePanel,filmPanel,minListePanel,watchPanel));

    //Array liste af JButton knapper
    protected  ArrayList<JButton> arrNavBtn = new ArrayList<>(Arrays.asList(forsideBtn,serierBtn,filmBtn,minListeBtn));

    //Scroll panel
//    JPanel scrollPanel = new JPanel();
    public GUI (ArrayList<Medie> arrFilm,ArrayList<Medie> arrSerier ){

        ArrayList<ArrayList<Medie>> arrMedie = new ArrayList<>(Arrays.asList(arrFilm,arrSerier));

            for (Medie m : arrMedie.get(0)) {
            try {
                BufferedImage image = ImageIO.read(new File("src/forsider/"+m.titel+".jpg"));
                JButton picBtn = new JButton(new ImageIcon(image.getScaledInstance(200,300,Image.SCALE_SMOOTH)));
                filmLabel = new JLabel(m.titel);
                arrBtnMedie.add(picBtn);
                arrLabelTitel.add(filmLabel);
                showMovie(picBtn, m.titel, m.aarstal, m.rating);
            } catch (Exception e) {
                System.out.println("Kunne ikke loade " + m.titel);
                }
            }

        for (Medie m : arrMedie.get(1)) {
            try {
                BufferedImage image = ImageIO.read(new File("src/forsider/"+m.titel+".jpg"));
                JButton picBtn = new JButton(new ImageIcon(image.getScaledInstance(200,300,Image.SCALE_SMOOTH)));
                serieLabel = new JLabel(m.titel);
                arrBtnSerier.add(picBtn);
                arrLabelTitel.add(serieLabel);
                showMovie(picBtn, m.titel, m.aarstal, m.rating);
            } catch (Exception e) {
                System.out.println("Kunne ikke loade " + m.titel);
            }
        }

        try {
            BufferedImage image = ImageIO.read(new File("src/other/title.png"));
            titleBtn = new JButton(new ImageIcon(image.getScaledInstance(200,100,Image.SCALE_SMOOTH)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Vi kalder alle vores metoder i vores konstruktør så det er mere organiseret
        framePanels();
        frameButtons();
        frameTabs();
        frameMethods();

    }
    public void framePanels() {
        /* Vi har alle vores paneler.
           Det er her vi ændrer og definerer hvordan vores paneler skal se ud */
        navPanel.setBackground(Color.green);
        forsidePanel.setBackground(new Color(32,32,32));
        seriePanel.setBackground(Color.yellow);
        filmPanel.setBackground(new Color(32,32,32));
        minListePanel.setBackground(Color.red);
        watchPanel.setBackground(new Color(32,32,32));
//        watchPanel.setLayout(null);

        for (JPanel panel: arrPanel) {
            panel.setBounds(0,100,1920,1980);
        }
        navPanel.setBounds(0,0,1920,100);


    }
    public void frameButtons() {
        titleBtn.setBounds(0,0,200,100);
        titleBtn.setBackground(Color.black);
        titleBtn.setOpaque(true); //Sæt den her til true, for at for et farvet baggrund
        titleBtn.setBorderPainted(false);
        titleBtn.setFocusable(false);

        navPanel.add(titleBtn);
        for (JButton button: arrNavBtn) {
            // Her definerer vi knappernes dimensioner og egenskaber. Det er kun x værdien der ændres for hver knap
            button.setBounds(0,0,200,25);
            // Focusable gør knapperne pæne (hvis focusable er true, vil der være en grim firkant rundt om teksten)
            button.setFocusable(false);
            button.setBackground(Color.black);
            button.setForeground(Color.white);
            button.setOpaque(true); //Sæt den her til true, for at for et farvet baggrund
            button.setBorderPainted(false);
//           "Arial" is obviously the name of the font being used.
//           Font.PLAIN means plain text (as opposed to bold or italic).
//           40 is the font size (using the same numbering system for font size as Microsoft Word)
            button.setFont(new Font("Arial", Font.PLAIN, 25));

            // Her tilføjer vi knapperne til vores frame
            navPanel.add(button);

        }
    }
    public void frameTabs() {
        /* Der er hernede vi tilføjer funktionalitet til hver af vores knapper
           Den fremviser den pågældende panel og sætter visibility af de andre paneler til false */

        titleBtn.addActionListener(e -> {
//            displayPanel((forsidePanel));
            displayPanel(forsidePanel);

        });

        forsideBtn.addActionListener(e -> {
            displayPanel(forsidePanel);
        });
        serierBtn.addActionListener(e -> {
            displayPanel(seriePanel);
//            seriePanel.setLayout(null);

            int x = 0;
            int y = 0;
            int width = 140;
            int height = 260;
            int yText = 240;
            for(int i = 0; i < arrBtnMedie.size(); i++) {
                if(x == 1400){
                    y+=height;
                    x=0;
                    yText+=yText+25;
                }
                //indlæser fra arrLabel og display hver film ud
                arrBtnSerier.get(i).setBounds(x,y,width,height);
                arrLabelTitel.get(i).setBounds(x,yText,width,25);
                seriePanel.add(arrBtnSerier.get(i));
//            filmPanel.add(arrLabelTitel.get(i));
                x+= 140;
            }
            serieLabel.setBounds(100,50,100,50);
            seriePanel.add(serieLabel);

        });
        filmBtn.addActionListener(e -> {
            displayPanel(filmPanel);
            filmPanel.setLayout(new GridLayout(5,50));
            int x = 0;
            int y = 0;
            int width = 140;
            int height = 260;
            int yText = 240;
            for(int i = 0; i < arrBtnMedie.size(); i++) {
                if(x == 1400){
                    y+=height;
                    x=0;
                    yText+=yText+25;
                }
                //indlæser fra arrLabel og display hver film ud
                arrBtnMedie.get(i).setBounds(x,y,width,height);
                arrLabelTitel.get(i).setBounds(x,yText,width,25);
                filmPanel.add(arrBtnMedie.get(i));
//            filmPanel.add(arrLabelTitel.get(i));
                x+= 140;
            }

        });
        minListeBtn.addActionListener(e -> {

            displayPanel(minListePanel);
//            minListePanel.setLayout(null);

            listeLabel.setBounds(100,50,100,50);
            minListePanel.add(listeLabel);
        });

    }
    public void frameMethods() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,700);
//        frame.setLayout(null);
        frame.setVisible(true);

        //Addere alle panelerne til frame med for each loop
        for (JPanel panel: arrPanel) {
//            Adder scrollbar på hvert panel
            frame.add(panel);
        }
        JScrollPane scroll = new JScrollPane(filmPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.add(filmPanel);
        frame.setBackground(new Color(0, 89, 255));
        navPanel.setLayout(new GridLayout(1,1));
        //navPanel er ikke en del af arrPanel, der den altid skal vises, så vi kalder bare add metoden for sig selv
        frame.add(navPanel);
    }

    public void displayPanel(JPanel currentPanel) {

        //Viser kun den panel man vælger via action listener, og sætter de andre paneler visibility til false
        for(JPanel panel: arrPanel) {
            //Sæt panel til at være usynligt hvis panel ikke er lige med current panel
            panel.setVisible(panel == currentPanel);
        }
    }

    public void showMovie(JButton btn, String title, String aarstal, String rating) {

        ArrayList<String> arrInfo = new ArrayList<>(Arrays.asList("Titel: " +title,"Årstal: " +aarstal,"Rating: " +rating));
        btn.addActionListener(e -> {
        watchPanel.removeAll();
        int y = 10;
            for (String info : arrInfo) {
                JLabel infoLabel = new JLabel(info);
                infoLabel.setBounds(250,y,500,100);
                infoLabel.setForeground(Color.WHITE);
                infoLabel.setFont(new Font("Serif", Font.PLAIN, 28));
                watchPanel.add(infoLabel);
                y+= 100;
            }

            displayPanel(watchPanel);
            btn.setBounds(0,0,200,300);
            watchPanel.add(btn);
        });
    }


}
