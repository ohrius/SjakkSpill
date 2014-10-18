package sjakkspill;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Ohrius
 */
class Brett {

    public static final int BRETTSTORRELSE = 8;
    protected static int spillNr;
    public static Brikke[][] brikkene;
    protected static Color hvit = Color.WHITE;
    protected static Color svart = Color.BLACK;
    private static int x = 0;
    private static int y = 0;
    private static int ii;

    //Oppretter brikkene-tabellen. setter bonder og tårn i posisjoner.
    //Oppretter tilfeldig spillNr.
    public static void lagBrett() {
        brikkene = new Brikke[BRETTSTORRELSE][BRETTSTORRELSE];
        for (int i = 0; i < BRETTSTORRELSE; i++) {

            //Lager hvite bonder
            if (i == 1) {
                for (int u = 0; u < BRETTSTORRELSE; u++) {
                    ii = u + 97;
                    String a = (char) ii + Integer.toString(i);
                    brikkene[i][u] = new Bonde(a, x, y, svart);
                }
            }

            //lager svarte bonder
            if (i == 6) {
                for (int u = 0; u < BRETTSTORRELSE; u++) {
                    ii = u + 97;
                    String a = (char) ii + Integer.toString(i);
                    brikkene[i][u] = new Bonde(a, x, y, hvit);
                }
                y += 100;
            }
            y = 0;
            x += 100;
        }
        //Lager tårn og gir de farge.
        brikkene[0][0] = new Taarn("a0", -800, 0, svart);
        brikkene[0][7] = new Taarn("h0", 0, 0, svart);
        brikkene[7][7] = new Taarn("h7", 0, 800, hvit);
        brikkene[7][0] = new Taarn("a7", -800, 800, hvit);

        //Oppretter tilfeldig spillnr
        Random randomGenerator = new Random();
        spillNr = randomGenerator.nextInt(100000);
    }

    //metode for å se om bruker har skrivd inn ett lovlig rutenavn
    //a-h og 1-8
    public static boolean erLovligRutenavn(String rutenavn) {
        rutenavn = rutenavn.toLowerCase();

        if (rutenavn.length() < 2) {
            return false;
        }

        int ascii = rutenavn.charAt(0);
        int tall = rutenavn.charAt(1) - 48;
        if (tall >= BRETTSTORRELSE || tall < 0) {
            return false;
        }
        if (ascii < 97 || ascii > 104) {
            return false;
        }

        return true;
    }

    //Henter brikke fra rutenavn
    public Brikke getBrikke(String rutenavn) {
        char kolonnebokstav = rutenavn.charAt(0);
        int kolonne = kolonnebokstav - 97;
        int rad = rutenavn.charAt(1) - 48;
        Brikke b = brikkene[rad][kolonne];
        if (b == null) {
            return null;
        }
        return b;
    }

    //Flytter brikke hvis det er lovlig. 
    public Boolean flyttBrikke(String fraRute, String tilRute) {
        Brikke b = getBrikke(fraRute);
        if (b.erLovligTrekk(tilRute)) {
            b.flyttTil(tilRute);
            System.out.println("Flyttbrikke fungerer");
            return true;
        }
        String test = b.getRutenavn();
            System.out.println("Noe gikk feil med Flyttbrikke  " + test);
        return false;
    }
}
