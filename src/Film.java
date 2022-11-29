import java.util.*;
public class Film extends Medie{


    public static void sort(){
        Medie m = new Film();
        m.test_sortering("./txt/film.txt");

        for(String i : (m.test_sortering("./txt/film.txt")).keySet()){
            System.out.println("key: " + i + " value: " + (m.test_sortering("./txt/film.txt")).get(i));
        }
    }
}
