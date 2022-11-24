import javax.swing.*;
import java.awt.*;

public class GUI {
    // Opretter vores frame instans og alle knapper
    JFrame frame = new JFrame();
    JPanel forsidePanel = new JPanel();
    JPanel seriePanel = new JPanel();
    JPanel filmPanel = new JPanel();
    JPanel listePanel = new JPanel();
    JButton forside = new JButton("Forside");
    JButton serier = new JButton("Serier");
    JButton film = new JButton("Film");
    JButton minListe = new JButton("Min Liste");
    protected JLabel serieLabel = new JLabel("Serier!");
    protected JLabel filmLabel = new JLabel("Film!");
    protected JLabel listeLabel = new JLabel("Min Liste!");
    public GUI (){
        framePanels();
        frameButtons();
        frameTabs();
        frameMethods();

        frame.add(forsidePanel);
        frame.add(seriePanel);
        frame.add(filmPanel);
        frame.add(listePanel);
    }
    public void framePanels() {
        forsidePanel.setBackground(Color.white);
        seriePanel.setBackground(Color.yellow);
        filmPanel.setBackground(Color.blue);
        listePanel.setBackground(Color.red);

        forsidePanel.setBounds(0,0,1920,1080);
        seriePanel.setBounds(0,0,1920,1080);
        filmPanel.setBounds(0,0,1920,1080);
        listePanel.setBounds(0,0,1920,1080);
    }
    public void frameButtons() {
        // Her definerer vi knappernes dimensioner og egenskaber
        forside.setBounds(200,25,100,20);
        forside.setFocusable(false);
        serier.setBounds(325, 25, 100, 20);
        serier.setFocusable(false);
        film.setBounds(450,25,100,20);
        film.setFocusable(false);
        minListe.setBounds(575,25,100,20);
        minListe.setFocusable(false);

        // Her tilføjer vi knapperne til vores frame
        frame.add(minListe);
        frame.add(film);
        frame.add(forside);
        frame.add(serier);
    }
    public void frameTabs() {
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

            serieLabel.setBounds(100,50,100,50);
            seriePanel.add(serieLabel);

        });
        film.addActionListener(e -> {
            forsidePanel.setVisible(false);
            seriePanel.setVisible(false);
            listePanel.setVisible(false);
            filmPanel.setVisible(true);

            filmLabel.setBounds(100,50,100,50);
            filmPanel.add(filmLabel);
        });
        minListe.addActionListener(e -> {

            forsidePanel.setVisible(false);
            filmPanel.setVisible(false);
            seriePanel.setVisible(false);
            listePanel.setVisible(true);

            listeLabel.setBounds(100,50,100,50);
            listePanel.add(listeLabel);
        });
    }
    public void frameMethods() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
