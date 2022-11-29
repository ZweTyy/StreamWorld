import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class TestGUI {
    private JFrame Frame;
    private JPanel MainPanel;
    private JPanel NavPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JComboBox comboBox1;
    private JPanel Editor;
    private JPanel FilmPanels;
    protected JLabel filmLabel;
    protected ArrayList<JLabel> arrLabel= new ArrayList<>();
    protected ArrayList<JLabel> arrLabelTitel= new ArrayList<>();

    public TestGUI() {
        Frame = new JFrame();
        Frame.setSize(1920,1080);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setVisible(true);
        Frame.setContentPane(MainPanel);

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
            FilmPanels.add(arrLabel.get(i));
            FilmPanels.add(arrLabelTitel.get(i));
            x+= 140;
        }
        button1.addActionListener(e -> {

}
