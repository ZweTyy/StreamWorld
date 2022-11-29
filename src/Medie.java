import java.util.*;
import java.io.*;

public class Medie {
    String titel;
    //billeder;
    //ArrayList<String> genre; //liste over de forskellige genrer der er.
    //HashMap<String,List<String>> genre_map; //hashmap der mapper genre til arrayliste der indeholder genren.
    //ArrayList<String> specifik_genre_liste; //genreliste for de specifikke genre.

    Medie(){//konstruktør

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


                    String arrOfStr[] = str.split(";",4);



                    //System.out.println(arrOfStr[0]); //det er navnet og arrOfStr(2) er genrene
                    String genrestring[]= arrOfStr[2].split(",",20);
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








}
