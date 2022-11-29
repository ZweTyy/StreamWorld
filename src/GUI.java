import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import  java.util.*;

public class GUI {
    // Opretter vores frame, panel og label instanser + alle knapper
    JFrame frame = new JFrame();
    JPanel navPanel = new JPanel();
    JPanel forsidePanel = new JPanel();
    JPanel seriePanel = new JPanel();
    JPanel filmPanel = new JPanel();
    JPanel listePanel = new JPanel();
    JButton forside = new JButton("Forside");
    JButton serier = new JButton("Serier");
    JButton film = new JButton("Film");
    JButton minListe = new JButton("Min Liste");
    protected JLabel filmLabel;
    protected JLabel serieLabel = new JLabel("Serier!");
    protected JLabel listeLabel = new JLabel("Min Liste!");

//    Array list a film
    protected ArrayList<JLabel> arrLabel= new ArrayList<>();
    protected ArrayList<JLabel> arrLabelTitel= new ArrayList<>();

    //load image
    private BufferedImage image;

    public GUI (){
        //Kalder fra film
        Film f= new Film();
        for (String film : f.alle_film()) {


        try {
            BufferedImage myPicture = ImageIO.read(new File("src/filmplakater/"+film+".jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
//            forsidePanel.add(picLabel);
        filmLabel = new JLabel(film);
        arrLabel.add(picLabel);
        arrLabelTitel.add(filmLabel);
        } catch (Exception e) {
            System.out.println("Kunne ikke finde billedet");
        }
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
        navPanel.setBackground(Color.black);
        forsidePanel.setBackground(Color.white);
        seriePanel.setBackground(Color.yellow);
        filmPanel.setBackground(Color.blue);
        listePanel.setBackground(Color.red);

        navPanel.setBounds(0,0,1920,100);
        forsidePanel.setBounds(0,100,1920,980);
        seriePanel.setBounds(0,100,1920,980);
        filmPanel.setBounds(0,100,1920,980);
        listePanel.setBounds(0,100,1920,980);

        navPanel.setVisible(true);
    }
    public void frameButtons() {
        // Her definerer vi knappernes dimensioner og egenskaber
        forside.setBounds(200,37,100,25);
        serier.setBounds(325, 37, 100, 25);
        film.setBounds(450,37,100,25);
        minListe.setBounds(575,37,100,25);

        // Focusable gør knapperne pæne (hvis focusable er true, vil der være en grim firkant rundt om teksten)
        forside.setFocusable(false);
        serier.setFocusable(false);
        film.setFocusable(false);
        minListe.setFocusable(false);

        // Her tilføjer vi knapperne til vores frame
        frame.add(minListe);
        frame.add(film);
        frame.add(forside);
        frame.add(serier);
    }
    public void frameTabs() {
        /* Der er hernede vi tilføjer funktionalitet til hver af vores knapper
           Den fremviser den pågældende panel og sætter visibility af de andre paneler til false */
        forside.addActionListener(e -> {
            seriePanel.setVisible(false);
            filmPanel.setVisible(false);
            listePanel.setVisible(false);
            forsidePanel.setVisible(true);
        });
        serier.addActionListener(e -> {
            forsidePanel.setVisible(false);
            filmPanel.setVisible(false);
            listePanel.setVisible(false);
            seriePanel.setVisible(true);
            seriePanel.setLayout(null);

            serieLabel.setBounds(100,50,100,50);
            seriePanel.add(serieLabel);

        });
        film.addActionListener(e -> {
            forsidePanel.setVisible(false);
            seriePanel.setVisible(false);
            listePanel.setVisible(false);
            filmPanel.setVisible(true);
            filmPanel.setLayout(null);

            int x = 0;
            int y = 0;
            int width = 140;
            int height = 260;
            int yText = 240;
            for(int i = 0; i < arrLabel.size(); i++) {
            if(x == 1400){
                y+=height;
                x=0;
                yText+=yText+25;
            }
          //indlæser fra arrLabel og display hver film ud
            arrLabel.get(i).setBounds(x,y,width,height);
            arrLabelTitel.get(i).setBounds(x,yText,width,25);
            filmPanel.add(arrLabel.get(i));
            filmPanel.add(arrLabelTitel.get(i));
            x+= 140;
            }

        });
        minListe.addActionListener(e -> {

            forsidePanel.setVisible(false);
            filmPanel.setVisible(false);
            seriePanel.setVisible(false);
            listePanel.setVisible(true);
            listePanel.setLayout(null);

            listeLabel.setBounds(100,50,100,50);
            listePanel.add(listeLabel);
        });
    }
    public void frameMethods() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.add(navPanel);
        frame.add(forsidePanel);
        frame.add(seriePanel);
        frame.add(filmPanel);
        frame.add(listePanel);
    }
}
