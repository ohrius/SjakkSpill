/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sjakkspill;

import java.awt.Color;

/**
 *
 * @author Ohrius
 */
public class Bonde extends Brikke {

    public Bonde(String rutenavn, int x, int y, Color farge) {
        super(rutenavn, x, y, "B", farge);
    }

    //Sjekker om det er lovlig for bonde å bevege seg.
    //(Feil ifølge sjakkregler. Denne funker kun framover.
    public boolean erLovligTrekk(String rutenavn) {
        rutenavn.toLowerCase();
        int r1 = this.rutenavn.charAt(0);
        int r2 = this.rutenavn.charAt(1);
        int l1 = rutenavn.charAt(0);
        int l2 = rutenavn.charAt(1);
        if (r1 == l1) {
            if (r2 == (l2 + 1)) {
                System.out.println("erLovligTrekk fungerer (bonde)");
                return true;
            }
        }

        String test = r1 + "  " + r2 + "  " + l1 + "  " + l2;
        System.out.println("noe gikk feil med erLovligTrekk (bonde)" + test);
        return false;

    }
}
