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


        GUI forside = new GUI(arrFilm, arrSerier);
    }

}