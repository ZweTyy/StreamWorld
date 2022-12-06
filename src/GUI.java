
import com.sun.jdi.BooleanType;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import  java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class GUI {
    // Opretter vores frame, panel og label instanser + alle knapper
    JFrame frame = new JFrame("Stream World");

    JPanel mainPanel = new JPanel();
    JPanel navPanel = new JPanel();
    JPanel forsidePanel = new JPanel();
    JPanel seriePanel = new JPanel();
    JPanel filmPanel = new JPanel();
    JPanel minListePanel = new JPanel();

    JPanel watchPanel = new JPanel();

    JScrollPane activePanel;

    JButton titleBtn;
    JButton forsideBtn = new JButton("Forside");
    JButton serierBtn = new JButton("Serier");
    JButton filmBtn = new JButton("Film");
    JButton minListeBtn = new JButton("Min Liste");
    protected JLabel filmLabel;
    protected JLabel serieLabel = new JLabel("Serier!");
    protected JLabel listeLabel = new JLabel("Din Liste er tom");

    //    Array list a film som knapper
    protected ArrayList<JButton> arrBtnFilm = new ArrayList<>();

    protected ArrayList<JButton> arrBtnSerier = new ArrayList<>();

    //Array liste af film titler
    protected ArrayList<JLabel> arrLabelTitel= new ArrayList<>();

    //Arrayliste af JPaneler undtagen navPanel. Brug til display metode.
    protected ArrayList<JPanel> arrPanel = new ArrayList<>(Arrays.asList(forsidePanel,seriePanel,filmPanel,minListePanel));

    //Array liste af JButton knapper
    protected  ArrayList<JButton> arrButtons = new ArrayList<>(Arrays.asList(forsideBtn,serierBtn,filmBtn,minListeBtn));

    //scroll bar
    protected JScrollPane forsideScroll, filmScroll,serierScroll, minListeScroll, watchScroll = new JScrollPane();
    protected ArrayList<JScrollPane> arrScroll = new ArrayList<>(Arrays.asList(forsideScroll, filmScroll, serierScroll, minListeScroll));
    protected HashMap<JPanel,JScrollPane> hashScroll = new HashMap<>();
    protected JScrollPane scrollPanel = new JScrollPane();


    public GUI (ArrayList<Medie> arrFilm,ArrayList<Medie> arrSerier ){

//    readFile metoden læser alle film og serier fra /forsider/ mappen
      readFile(arrFilm,arrBtnFilm,filmLabel, filmPanel);
      readFile(arrSerier,arrBtnSerier,serieLabel, seriePanel);

        try {
            BufferedImage image = ImageIO.read(new File("src/other/title.png"));
            titleBtn = new JButton(new ImageIcon(image.getScaledInstance(200,100,Image.SCALE_SMOOTH)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Vi kalder alle vores metoder i vores konstruktør så det er mere organiseret
        framePanels();
        frameButtons();
        ActionListener();
        frameMethods();

    }
    public void framePanels() {
        /* Vi har alle vores paneler.
           Det er her vi ændrer og definerer hvordan vores paneler skal se ud */
        navPanel.setBackground(Color.black);
        navPanel.setLayout(new GridLayout(1,5,20,10));
        forsidePanel.setBackground(new Color(34,112,32));
        seriePanel.setBackground(Color.yellow);
        filmPanel.setBackground(new Color(44,2,100));
        minListePanel.setBackground(Color.red);
        watchPanel.setBackground(new Color(32,32,32));
        watchPanel.setLayout(new GridLayout(1,5));
        watchScroll = new JScrollPane(watchPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        mainPanel.setLayout(new BorderLayout());

//        for (JPanel panel: arrPanel) {
//            panel.setBounds(0,100,1920,1080);
//        }
        navPanel.setBounds(0,0,1920,100);
        navPanel.setVisible(true);
    }
    public void frameButtons() {
        titleBtn.setBounds(0,0,200,100);
        titleBtn.setBackground(Color.black);
        titleBtn.setOpaque(true); //Sæt den her til true, for at for et farvet baggrund
        titleBtn.setBorderPainted(false);
        titleBtn.setFocusable(false);

        navPanel.add(titleBtn);
        int x = 200;
        for (JButton button: arrButtons) {
            // Her definerer vi knappernes dimensioner og egenskaber. Det er kun x værdien der ændres for hver knap
            button.setBounds(x,37,200,25);
            x+= 200;
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
    public void ActionListener() {
        /* Der er hernede vi tilføjer funktionalitet til hver af vores knapper
           Den fremviser den pågældende panel og sætter visibility af de andre paneler til false */
        titleBtn.addActionListener(e -> {
//            displayPanel((forsidePanel));
        });

        forsideBtn.addActionListener(e -> {
            display(forsideScroll);
        });
        serierBtn.addActionListener(e -> {
            display(serierScroll);

        });
        filmBtn.addActionListener(e -> {
            display(filmScroll);

        });
        minListeBtn.addActionListener(e -> {

            display(minListeScroll);

            listeLabel.setBounds(100,50,100,50);
            minListePanel.add(listeLabel);
        });

    }
    public void frameMethods() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,700);
//        frame.setLayout(null);
        mainPanel.setBackground(new Color(217, 16, 16));
        mainPanel.add(navPanel, BorderLayout.NORTH);

        //Addere alle panelerne til frame med for each loop
        //navPanel er ikke en del af arrPanel, der den altid skal vises, så vi kalder bare add metoden for sig selv
        filmPanel.setLayout(new GridLayout(20,5));
        seriePanel.setLayout(new GridLayout(20,5));
        serierScroll = new JScrollPane(seriePanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        filmScroll = new JScrollPane(filmPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        mainPanel.add(filmScroll, BorderLayout.CENTER);
        activePanel = filmScroll;
//        mainPanel.remove(filmScroll);
//        filmScroll = new JScrollPane(filmPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//        mainPanel.add(filmScroll);

        frame.getContentPane().add(mainPanel);
        mainPanel.setVisible(true);
        frame.setVisible(true);

    }

    public void display(JScrollPane currentPanel) {

        activePanel.setVisible(false);
        mainPanel.remove(activePanel);
        mainPanel.add(currentPanel, BorderLayout.CENTER);
        currentPanel.setVisible(true);
        mainPanel.revalidate();
        activePanel = currentPanel;
    }

    public void btnMovie(JButton btn, String title, String aarstal, String rating) {

        ArrayList<String> arrInfo = new ArrayList<>(Arrays.asList("Titel: " +title,"Årstal: " +aarstal,"Rating: " +rating));
        btn.addActionListener(e -> {
            display(watchScroll);
            watchPanel.removeAll();
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout( new GridLayout(5,1));
            infoPanel.setBackground(new Color(32,32,32));
            btn.setBackground(new Color(32,32,32));
            btn.setBounds(0,0,200,300);
            watchPanel.add(btn);
            int y = 10;
            for (String info : arrInfo) {
                JLabel infoLabel = new JLabel(info);
                infoLabel.setBounds(250,y,500,100);
                infoLabel.setForeground(Color.WHITE);
                infoLabel.setFont(new Font("Serif", Font.PLAIN, 28));
                infoPanel.add(infoLabel);
                y+= 100;
            }
            watchPanel.add(infoPanel);
//            displayPanel(watchPanel);
        });
    }

    public void readFile(ArrayList<Medie> arrMedie, ArrayList<JButton> arrBtn,JLabel label, JPanel panel){
        for (Medie m : arrMedie) {
            try {
                BufferedImage image = ImageIO.read(new File("src/forsider/"+m.titel+".jpg"));
                JButton picBtn = new JButton(new ImageIcon(image.getScaledInstance(200,300,Image.SCALE_SMOOTH)));
                picBtn.setBackground(new Color(32,32,32));
                picBtn.setFocusable(false);
                picBtn.setBackground(Color.black);
                picBtn.setOpaque(true);
                picBtn.setBorderPainted(false); //Sæt den her til true, for at for et farvet baggrund
                label = new JLabel(m.titel);
                arrBtn.add(picBtn);
                arrLabelTitel.add(label);
                btnMovie(picBtn, m.titel, m.aarstal, m.rating);
            } catch (Exception e) {
                System.out.println("Kunne ikke loade " + m.titel);
            }
        }
        for (JButton jButton : arrBtn) {
            jButton.setForeground(new Color(32,32,32));
            panel.add(jButton);
        }

    }

}