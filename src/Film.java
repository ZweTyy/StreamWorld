import java.util.*;
import java.io.*;
public class Film extends Medie{


    public static void sort(){
        Medie m = new Film();
        m.test_sortering("src/txt/film.txt");

        for(String i : (m.test_sortering("src/txt/film.txt")).keySet()){
            System.out.println("key: " + i + " value: " + (m.test_sortering("src/txt/film.txt")).get(i));

        }
    }

    public static ArrayList<String> alle_film() {
        Medie m = new Film();
        m.vis_medie("src/txt/film.txt");
        return  m.vis_medie("src/txt/film.txt");
    }

//    public static ArrayList<String> alle_serier() {
//        Medie m = new Film();
//        m.vis_medie("src/txt/film.txt");
//        return  m.vis_medie("src/txt/film.txt");
//    }
}
