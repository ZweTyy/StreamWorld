import java.util.*;
public class Film extends Medie{


    public static void sort(){
        Medie m = new Film();
        m.test_sortering("./txtfiler-kopi/film.txt");

        for(String i : (m.test_sortering("./txtfiler-kopi/film.txt")).keySet()){
            System.out.println("key: " + i + " value: " + (m.test_sortering("./txtfiler-kopi/film.txt")).get(i));
        }
    }
}
