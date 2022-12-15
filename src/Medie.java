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

    public HashMap<String, Integer> getSaeson_episode(){
        return null;
    }

    }


