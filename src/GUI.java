import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    // Opretter vores frame instans og alle knapper
    JFrame frame = new JFrame();
    JButton forside = new JButton("Forside");
    JButton serier = new JButton("Serier");
    JButton film = new JButton("Film");
    JButton minListe = new JButton("Min Liste");
    public GUI (){
        // Her definerer vi knappernes dimensioner og egenskaber
        forside.setBounds(200,25,100,20);
        forside.setFocusable(false);
        serier.setBounds(325, 25, 100, 20);
        serier.setFocusable(false);
        film.setBounds(450,25,100,20);
        film.setFocusable(false);
        minListe.setBounds(575,25,100,20);
        minListe.setFocusable(false);

        // Her tilføjer vi funktionalitet til knapperne når de bliver trykket på
        // Den skaber en ny instans af den pågældende knap
        serier.addActionListener(e -> {
            frame.dispose();
            Serier serieSide = new Serier();
        });
        film.addActionListener(e -> {
            frame.dispose();
            Film filmSide = new Film();
        });
        minListe.addActionListener(e -> {
            frame.dispose();
            MinListe favoritSide = new MinListe();
        });

        // Her tilføjer vi knapperne til vores frame
        frame.add(minListe);
        frame.add(film);
        frame.add(forside);
        frame.add(serier);

        // Default frame metoder
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
