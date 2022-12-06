
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Medie> arrFilm = new ArrayList<>();
    static ArrayList<Medie> arrSerier = new ArrayList<>();
    public static void main(String[] args) {

        Medie m = new Film("string","string","string");
        Medie n = new Serier("string","string","string");
        arrFilm = m.arrList(m, "film");
        arrSerier = n.arrList(m, "serier");


//        Pcroll p = new Pcroll(arrFilm,arrSerier);
        GUI forside = new GUI(arrFilm, arrSerier);

//        CardLayoutExample cl = new CardLayoutExample();
//        cl.setSize(300, 300);
//        cl.setVisible(true);
//        cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Scroll scroll = new Scroll();
    }

}