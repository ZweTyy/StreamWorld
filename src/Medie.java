import java.util.*;
import java.io.*;

public abstract class Medie {
    String titel;
    String aarstal;
    String rating;
    boolean minListe; //True hvis det er i min liste
    String  genre;
    boolean minliste;
    int ID;
    //konstruktør
    Medie(String titel, String aarstal, String rating, String genre, boolean minliste, int ID) {
        this.aarstal = aarstal;
        this.titel = titel;
        this.rating = rating;
        this.genre = genre;
        this.minliste = minliste;
        this.ID = ID;

    }


    public static ArrayList<String> vis_medie(String filename){
        ArrayList<String> medie_navn = new ArrayList<>();
       try {
           File file = new File(filename);
           Scanner s = new Scanner(file);

           while (s.hasNextLine()) {
               String[] arrOfStrings = (s.nextLine()).split(";",4);
               medie_navn.add(arrOfStrings[0]);

           }
           return medie_navn;
       }
       catch(FileNotFoundException e){
            System.out.println("*** filen findes ikke!");
            return null;
        }
        }

    public static ArrayList<String> display_medie(String filename) {

        vis_medie("src/txt/"+filename+".txt");
        return  vis_medie("src/txt/"+filename+"..txt");
    }

    public HashMap<String, Integer> getSaeson_episode(){
        return null;
    }

    }


