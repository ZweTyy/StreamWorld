import java.util.*;

public class Serier extends Medie {
HashMap<String, Integer> saeson_episode;

    Serier(String titel, String aarstal, String rating, String genre, boolean minliste, int ID, HashMap<String, Integer> saeson_episode)  {
        super(titel, aarstal, rating, genre, minliste, ID);
        this.saeson_episode = saeson_episode;

    }
    @Override
    public HashMap<String, Integer> getSaeson_episode() {
        return saeson_episode;
    }
}
