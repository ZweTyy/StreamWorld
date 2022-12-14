
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static ArrayList<Medie> arrFilm = new ArrayList<>();
    static ArrayList<Medie> arrSerier = new ArrayList<>();
    public static void main(String[] args) {



        arrFilm = arrList("film");
        arrSerier = arrList("serier");

        GUI forside = new GUI(arrFilm, arrSerier);
    }

    public static ArrayList<Medie> arrList(String filnavn) {
        int filmtaeller = 0; //film id tæller
        int serietaeller = 100; //serie id tæller
        ArrayList<Medie> arrObj = new ArrayList<>();
        boolean minListe;

        try {
            File file = new File("src/txt/" + filnavn + ".txt");
            Scanner s = new Scanner(file);

            while (s.hasNextLine()) {

                Medie m;
                String str = s.nextLine();
                String[] arrOfStr = str.split(";", 5);
                // 0 = titel 1 = aarstal 2 = genre 3 = rating
                String titel = arrOfStr[0];
                String aarstal = arrOfStr[1].replace(" ", "");
                String genre = arrOfStr[2].replace(" ", "");
                String rating = arrOfStr[3].replace(" ", "").replace(";", "");
                Favoritliste fav = new Favoritliste();
                if(fav.indlaes_medier().contains(titel)) minListe = true;
                else minListe = false;

                if (filnavn.equals("film")) {
                    m = new Film(titel, aarstal, rating, genre, minListe ,filmtaeller);
                    filmtaeller = filmtaeller + 1;

                }
                else {
                    String[] arrSerier = arrOfStr[4].split(",");
                    HashMap<String, Integer> saeson_episode = new HashMap<>();
                    for(String saeson_og_episoder : arrSerier){
                       String[] saeson = saeson_og_episoder.split("-"); //0 index er sæson, og 1 index er antal episoder
                       saeson_episode.put("Sæson "+saeson[0].replace(" ", ""),Integer.parseInt(saeson[1].replace(" ", "").replace(";", "")));
//                    System.out.println(titel + " og antallet af sæsoner og episoder" + saeson_episode);
                    }
                    m = new Serier(titel, aarstal, rating, genre, minListe,serietaeller, saeson_episode);
                    serietaeller = serietaeller + 1;
                }
                arrObj.add(m);

                // en arrayliste med instanser af filmobjekter

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Kunne ikke finde fil: " + filnavn + ".txt");
            throw new RuntimeException(e);
        }
        return arrObj;
    }


}