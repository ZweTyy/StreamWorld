import java.util.*;
import java.io.*;

public abstract class Medie {
    String titel;
    String aarstal;
    String rating;
    boolean minListe; //True hvis det er i min liste
    String  genre;
    boolean minliste;
    //konstruktør
    Medie(String titel, String aarstal, String rating, String genre, boolean minliste) {
        this.aarstal = aarstal;
        this.titel = titel;
        this.rating = rating;
        this.genre = genre;
        this.minliste = minliste;

    }



    public ArrayList<Medie> arrList(Medie obj, String filenavn) {
        ArrayList<Medie> arrObj = new ArrayList<>();

        try {
            File file = new File("src/txt/" + filenavn + ".txt");
            Scanner s = new Scanner(file);

            while (s.hasNextLine()) {

                String str = s.nextLine();
                String[] arrOfStr = str.split(";", 5);
                // 0 = titel 1 = aarstal 2 = genre 3 = rating
                titel = arrOfStr[0];
                aarstal = arrOfStr[1].replace(" ", "");
                genre = arrOfStr[2].replace(" ", "");
                rating = arrOfStr[3].replace(" ", "").replace(";", "");
                Favoritliste fav = new Favoritliste();
                if(fav.indlaes_medier().contains(titel)) minListe = true;
                else minListe = false;

                Film f = new Film(titel, aarstal, rating, genre, minListe);

                arrObj.add(f);

                // en arrayliste med instanser af filmobjekter

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
                return arrObj;
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

    }


