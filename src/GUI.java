import javax.swing.*;
import java.awt.*;
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
    public GUI (){
        //Kalder fra film
        Film f= new Film();
        for (String film : f.alle_film()) {

        filmLabel = new JLabel(film);
        arrLabel.add(filmLabel);
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

            int x = 150;
            int y = 50;
            for(int i = 0; i < arrLabel.size(); i++) {
            if(x%900 == 0){
                y+=50;
                x=150;
            }
          //indlæser fra arrLabel og display hver film ud
            arrLabel.get(i).setBounds(x,y,150,50);
            filmPanel.add(arrLabel.get(i));
            x+= 150;
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
