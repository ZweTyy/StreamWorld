import java.util.*;
import java.io.*;
public class Film extends Medie{


    Film(String titel, String aarstal, String rating, String genre, boolean minliste){
        super(titel, aarstal, rating, genre, minliste);
    }

//    public static void sort(){
//        test_sortering("src/txt/film.txt");
//
//        for(String i : (test_sortering("src/txt/film.txt")).keySet()){
//            System.out.println("key: " + i + " value: " + (test_sortering("src/txt/film.txt")).get(i));
//
//        }
//    }


//    public static ArrayList<String> alle_serier() {
//        Medie m = new Film();
//        m.vis_medie("src/txt/film.txt");
//        return  m.vis_medie("src/txt/film.txt");
//    }
}
