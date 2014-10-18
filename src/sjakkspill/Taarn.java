package sjakkspill;

import java.awt.Color;

/**
 *
 * @author Ohrius
 */
public class Taarn extends Offiser {

    public Taarn(String rutenavn, int x, int y, Color farge) {
        super(rutenavn, x, y, "T", farge);
    }

    //Sjekker om tårnet beveger seg kun en vei og ikke støter på brikker på veien.
    @Override
    public boolean erLovligTrekk(String rutenavn) {
        rutenavn.toLowerCase();
        int r1 = this.rutenavn.charAt(0) - 'a';
        int r2 = this.rutenavn.charAt(1) - 48;
        int l1 = rutenavn.charAt(0) - 'a';
        int l2 = rutenavn.charAt(1) - 48;
        
        //Tårn flytter opp.
        if (r1 == l1 && r2 > l2) {
            for (int i = l2; i < r2; i++) {
        System.out.println("Fungerte i nr 1   " + r1 + "   " + r2 + "   " + l1 + "   " + l2);
                if (brikkene[i][r1] != null) {
                    return false;
                }
                return true;
            }
        }
        //Tårn flytter ned.
        if (r1 == l1 && r2 < l2) {
            for (int i = r2; i < l2; i++) {
        System.out.println("Fungerte i nr 2   " + r1 + "   " + r2 + "   " + l1 + "   " + l2);
                if (brikkene[i][r1] != null) {
                    return false;
                }
                return true;
            }
        }
        //Tårn flytter til venstre.
        if (r2 == l2 && r1 > l1) {
        System.out.println("Fungerte i nr 3   " + r1 + "   " + r2 + "   " + l1 + "   " + l2);
            for (int i = l1; i < r1;i++) {
                if (brikkene[r2][i] == null) {
                    return false;
                }
                return true;
            }
        }
        //Tårn flytter til høyre
        if (r2 == l2 && r1 < l1) {
        System.out.println("Fungerte i nr 4   " + r1 + "   " + r2 + "   " + l1 + "   " + l2);
            for (int i = r1; i < l1; i++) {
                if (brikkene[r2][i] == null) {
                    return false;
                }
                return true;
            }
        }
        System.out.println("Fungerte ikke" + r1 + r2 + l1 + l2);
        return false;
    }

}
