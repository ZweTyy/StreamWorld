import javax.swing.*;

public class Film {
    protected JFrame frame = new JFrame();
    protected JButton forside = new JButton("Forside");
    protected JButton serier = new JButton("Serier");
    protected JButton film = new JButton("Film");
    protected JButton minListe = new JButton("Min Liste");
    protected JLabel label = new JLabel("Film!");
    public Film (){
        forside.setBounds(200,25,100,20);
        forside.setFocusable(false);
        serier.setBounds(325, 25, 100, 20);
        serier.setFocusable(false);
        film.setBounds(450,25,100,20);
        film.setFocusable(false);
        minListe.setBounds(575,25,100,20);
        minListe.setFocusable(false);
        label.setBounds(100,50,100,50);

        forside.addActionListener(e -> {
            frame.dispose();
            GUI forside = new GUI();
        });
        serier.addActionListener(e -> {
            frame.dispose();
            Serier serieSide = new Serier();
        });
        minListe.addActionListener(e -> {
            frame.dispose();
            MinListe favoritSide = new MinListe();
        });

        frame.add(label);
        frame.add(minListe);
        frame.add(film);
        frame.add(forside);
        frame.add(serier);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
