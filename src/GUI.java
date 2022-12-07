import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import  java.util.*;

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
    JPanel searchPanel = new JPanel();

    JScrollPane activePanel;
    JButton currentMedia;

    JButton titleBtn;
    JButton forsideBtn = new JButton("Forside");
    JButton serierBtn = new JButton("Serier");
    JButton filmBtn = new JButton("Film");
    JButton minListeBtn = new JButton("Min Liste");
    JTextField searchField = new JTextField();
    protected JButton searchButton = new JButton("Søg");
    protected JLabel filmLabel;
    protected JLabel serieLabel = new JLabel("Serier!");
    protected JLabel listeLabel = new JLabel("Din Liste er tom");

    //    Array list a film som knapper

    protected ArrayList<JButton> arrBtnSerier = new ArrayList<>(), arrBtnFilm = new ArrayList<>(), arrBtnAlle = new ArrayList<>();


    //Array liste af film titler
    protected ArrayList<JLabel> arrLabelTitel= new ArrayList<>();

    //Array liste af JButton knapper
    protected  ArrayList<JButton> arrButtons = new ArrayList<>(Arrays.asList(forsideBtn,serierBtn,filmBtn,minListeBtn));

    //scroll bar
    protected JScrollPane forsideScroll, filmScroll,serierScroll, minListeScroll, watchScroll, searchScroll = new JScrollPane();

    protected ArrayList<Medie> arrFilm = new ArrayList<>();

    protected ArrayList<Medie> arrAlle = new ArrayList<>();
    public GUI (ArrayList<Medie> arrFilm,ArrayList<Medie> arrSerier ){

        this.arrFilm = arrFilm;

        arrAlle.addAll(arrFilm);
        arrAlle.addAll(arrSerier);
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
        searchPanel.setBackground(new Color(32,32,32));
        searchPanel.setLayout(new FlowLayout());
        watchScroll = new JScrollPane(watchPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        searchScroll = new JScrollPane(searchPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        mainPanel.setLayout(new BorderLayout());

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
        searchButton.setFocusable(false);
        searchButton.setBounds(0,0,200,25);
        searchButton.setBackground(Color.black);
        searchButton.setForeground(Color.white);
        searchButton.setOpaque(true);
        searchButton.setBorderPainted(false);
        searchButton.setFont(new Font("Arial", Font.PLAIN, 25));
        navPanel.add(searchButton);
        navPanel.add(searchField);
    }
    public void ActionListener() {
        /* Der er hernede vi tilføjer funktionalitet til hver af vores knapper
           Den fremviser den pågældende panel og sætter visibility af de andre paneler til false */
        titleBtn.addActionListener(e -> {
//            displayPanel((forsidePanel));
        });

        forsideBtn.addActionListener(e -> display(forsideScroll));
        serierBtn.addActionListener(e -> display(serierScroll));
        filmBtn.addActionListener(e -> display(filmScroll));
        minListeBtn.addActionListener(e -> {
        });
        searchButton.addActionListener(e -> {
            display(searchScroll);
            searchPanel.removeAll();
            search(arrAlle,arrBtnAlle,filmLabel, searchPanel);
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

    public void btnMovie(JButton btn, String title, String aarstal, String rating, JButton btnWatch) {

        ArrayList<String> arrInfo = new ArrayList<>(Arrays.asList("Titel: " +title,"Årstal: " +aarstal,"Rating: " +rating+"/10"));
        btn.addActionListener(e -> {
            JButton bb;
            watchPanel.removeAll();
            display(watchScroll);
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout( new GridLayout(5,1));
            infoPanel.setBackground(new Color(32,32,32));
            btnWatch.setBackground(new Color(32,32,32));
            watchPanel.add(btnWatch);
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

        });
    }


    public void readFile(ArrayList<Medie> arrMedie, ArrayList<JButton> arrBtn,JLabel label, JPanel panel){
        for (Medie m : arrMedie) {
            try {
                BufferedImage image = ImageIO.read(new File("src/forsider/"+m.titel+".jpg"));
                JButton picBtn = new JButton(new ImageIcon(image.getScaledInstance(300,400,Image.SCALE_DEFAULT)));
                JButton picBtnWatch = new JButton(new ImageIcon(image.getScaledInstance(300,400,Image.SCALE_DEFAULT)));
                picBtn.setBackground(new Color(32,32,32));
                picBtn.setFocusable(false);
                picBtn.setBackground(Color.black);
                picBtn.setOpaque(true);
                picBtn.setBorderPainted(false); //Sæt den her til true, for at for et farvet baggrund
                picBtnWatch.setBackground(new Color(32,32,32));
                picBtnWatch.setFocusable(false);
                picBtnWatch.setBackground(Color.black);
                picBtnWatch.setOpaque(true);
                picBtnWatch.setBorderPainted(false);
                label = new JLabel(m.titel);
                arrBtn.add(picBtn);
                arrLabelTitel.add(label);
                picBtn.setForeground(new Color(32,32,32));
                panel.add(picBtn);
                btnMovie(picBtn, m.titel, m.aarstal, m.rating,picBtnWatch);
            } catch (FileNotFoundException fnfe) {
                System.out.println("Der fandtes ingen resultater for " + m.titel);
            } catch (Exception e) {
                System.out.println("Noget gik galt");
            }
        }
//        for (JButton jButton : arrBtn) {
//            jButton.setForeground(new Color(32,32,32));
//            panel.add(jButton);
//        }

    }
    public void search(ArrayList<Medie> arrMedie, ArrayList<JButton> arrBtn, JLabel label, JPanel panel) {
//        Sætter arrayliste til at være tomt, så medier ikke kan duplikieres hvis man søger igen
        arrBtn.clear();
        int totalMedie = 0;
        for (Medie m : arrMedie) {
            //Viser kun film og serier titel til contains søge felt
            if (m.titel.toLowerCase().contains(searchField.getText().toLowerCase())) {
                try {
                    BufferedImage image = ImageIO.read(new File("src/forsider/"+m.titel+".jpg"));
                    JButton picBtn = new JButton(new ImageIcon(image.getScaledInstance(300,400,Image.SCALE_SMOOTH)));
                    JButton picBtnWatch = new JButton(new ImageIcon(image.getScaledInstance(300,400,Image.SCALE_DEFAULT)));
                    picBtn.setBackground(new Color(32,32,32));
                    picBtn.setFocusable(false);
                    picBtn.setBackground(Color.black);
                    picBtn.setOpaque(true);
                    picBtn.setBorderPainted(false); //Sæt den her til true, for at for et farvet baggrund
                    picBtnWatch.setBackground(new Color(32,32,32));
                    picBtnWatch.setFocusable(false);
                    picBtnWatch.setBackground(Color.black);
                    picBtnWatch.setOpaque(true);
                    picBtnWatch.setBorderPainted(false);
                    label = new JLabel(m.titel);
                    arrBtn.add(picBtn);
                    arrLabelTitel.add(label);
                    btnMovie(picBtn, m.titel, m.aarstal, m.rating,picBtnWatch);
                    totalMedie++;
                } catch (FileNotFoundException fnfe) {
                    System.out.println("Der fandtes ingen resultater for " + m.titel);
                } catch (Exception e) {
                    System.out.println("Noget gik galt");
                }
            }
            if (totalMedie >= 5) searchPanel.setLayout(new GridLayout(20,5));
        }
        for (JButton jButton : arrBtn) {
            jButton.setForeground(new Color(32,32,32));
            panel.add(jButton);
        }
    }

}
