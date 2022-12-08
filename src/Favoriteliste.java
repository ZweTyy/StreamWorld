import java.io.*;
import java.util.*;

class Favoritliste {

    File favoritliste = new File("src/txt/favoritliste.txt");
    ArrayList<String> gemte_medier = new ArrayList<>(); //arrayliste med de filfoejede titler

    public ArrayList<String> indlaes_medier() {
        gemte_medier.clear(); //den rydder arraylisten, således der ikke bliver tilfoejet samme titler på listen
        try {
            Scanner s = new Scanner(favoritliste);
            while (s.hasNextLine()) {//der gås igennem txt dokumentet, og tilføjet til listen
                String str = s.nextLine();
                gemte_medier.add(str);
                ;
            }
        } catch (FileNotFoundException e) {
            e.getMessage();

        }
        return gemte_medier;
    }




    public void tilføj_medie(String titel) {
        indlaes_medier(); //her er listen over de medier der er på favoritlisten, det er metoden ovenfor
        try {

            Writer overskriv = new FileWriter("src/txt/favoritliste.txt");

            if (gemte_medier.contains(titel)) {
                //sørger for samme titel ikke sættes ind flere gange
            } else {
                overskriv.write(titel);//titel skrives ind i til txt dokumentet
                overskriv.write(System.lineSeparator()); //sørger for mellemrum
            }
            if (gemte_medier.size() > 0) {
                for (String element : gemte_medier) {
                    overskriv.write(element);//titlerne fra det tidligere txt dokument skrives ind
                    overskriv.write(System.lineSeparator()); //sørger for mellemrum på listen
                }
            }

            overskriv.close();
        } catch (IOException e) {
            e.getMessage();
        }

    }

    public void fjern_medie(String titel) {
        indlaes_medier();
        try {
            Scanner s = new Scanner(favoritliste);
            while (s.hasNextLine()) {//går igennem filen
                String str = s.nextLine();
                if (str.matches(titel)) { //hvis filen indeholder titlen ,fjernes den fra arraylisten gemte medier.
                    try {
                        Writer overskriv = new FileWriter("src/txt/favoritliste.txt");
                        if (gemte_medier.size() > 0) {
                            gemte_medier.remove(str);
                            for (String element : gemte_medier) {
                                overskriv.write(element); //gemte medier overskriver med den opdaterede version af filen
                                overskriv.write(System.lineSeparator()); //sørger for mellemrum på listen
                            }
                        }
                        overskriv.close();
                    } catch (IOException e) {
                        e.getMessage();
                    }
                }
            }
            gemte_medier.clear();
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    public void udskriv() { //blot en hjælpemetode, for at teste det virker. den fjernes i den endelige kode
        try {
            Scanner s = new Scanner(favoritliste);
            while (s.hasNextLine()) {
                String str = s.nextLine();

                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

}