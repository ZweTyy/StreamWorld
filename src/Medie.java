import java.util.*;
import java.io.*;

public abstract class Medie {
    String titel;
    String aarstal;
    String rating;

    //konstruktør
    Medie(String titel, String aarstal, String rating) {
        this.aarstal = aarstal;
        this.titel = titel;
        this.rating = rating;
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
                String titel = arrOfStr[0];
                String aarstal = arrOfStr[1].replace(" ", "");
                String rating = arrOfStr[3].replace(" ", "").replace(";", "");

                if (!Objects.equals(obj, new Film("Hej", "med", "dig"))) {
                    Film f = new Film(titel, aarstal, rating);
                    arrObj.add(f);
                }

                // en arrayliste med instanser af filmobjekter

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
                return arrObj;
    }



    public HashMap<String,List<String>> test_sortering(String filename){
        ArrayList<String> genre = new ArrayList<>(Arrays.asList("Crime","War","Drama","Family","Romance","Sci-fi","Biography","Musical","Adventure","Action","Thriller","Mystery","History","Fantasy","Comedy","Film-Noir","Horror","Western","Sport","Music"));
        HashMap<String,List<String>> genre_map = new HashMap<>();
        ArrayList<String> specifik_genre_liste;
        try{


            for(String genren : genre){
                specifik_genre_liste = new ArrayList<>();
                File file = new File(filename);
                Scanner s = new Scanner(file);

                while(s.hasNextLine()){
                    //System.out.println(s.nextLine());
                    String str = s.nextLine();


                    String[] arrOfStr = str.split(";",4);

                    //System.out.println(arrOfStr[0]); //det er navnet og arrOfStr(2) er genrene
                    String[] genrestring= arrOfStr[2].split(",",20);
                    for(String element : genrestring){ //den her opdeler genre tilhørende en film
                        element = element.replace(" ", "");

                        if(element.equals(genren)){
                            specifik_genre_liste.add(arrOfStr[0]);

                        }

                    }

                }
                genre_map.put(genren,specifik_genre_liste);

            }

            return genre_map;

        }
        catch(FileNotFoundException e){
            System.out.println("*** filen findes ikke!");
            return null;
        }


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


