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
    /*@Override
     public boolean erLovligTrekk(String rutenavn){
     rutenavn = rutenavn.toLowerCase();
     int fromX = this.rutenavn.charAt(0) - 'a';
     int fromY = this.rutenavn.charAt(1) - 48;
     int toX = rutenavn.charAt(0) - 'a';
     int toY = rutenavn.charAt(1) - 48;

     //Tårn flytter opp.
     if ( fromX== toX && fromY > toY) {
     for (int i = fromY-1; i > toY; i--) {
     System.out.println("Fungerte i nr 1   " + fromX + "   " + fromY + "   " + toX + "   " + toY);
     if (brikkene[fromX][i] != null) {
     return false;
     }
     }
     return true;
     }
     //Tårn flytter ned.
     if (fromX == toX && fromY < toY) {
     for (int i = fromY; i < toY; i++) {
     System.out.println("Fungerte i nr 2   " + fromX + "   " + fromY + "   " + toX + "   " + toY);
     if (brikkene[fromX][i] != null) {
     return false;
     }
     return true;
     }
     }
     //Tårn flytter til venstre.
     if (fromY == toY && fromX > toX) {
     System.out.println("Fungerte i nr 3   " + fromX + "   " + fromY + "   " + toX + "   " + toY);
     for (int i = fromX; i > toY; i--) {
     if (brikkene[i][fromY] != null) {
     return false;
     }
     return true;
     }
     }
     //Tårn flytter til høyre
     if (fromY == toY && fromX < toX) {
     System.out.println("Fungerte i nr 4   " + fromX + "   " + fromY + "   " + toX + "   " + toY);
     for (int i = fromX; i < toX; i++) {
     if (brikkene[i][fromY] != null) {
     return false;
     }
     return true;
     }
     }
     System.out.println("Fungerte ikke" + fromX + "   " + fromY + "   " + toX + "   " + toY);
     return false;
     }
     */
    @Override
    public boolean erLovligTrekk(String rutenavn) {
        int fromX = this.rutenavn.charAt(0) - 'a';
        int fromY = this.rutenavn.charAt(1) - 48;
        int toX = rutenavn.charAt(0) - 'a';
        int toY = rutenavn.charAt(1) - 48;
        if (fromX == toX) {
            System.out.println("fromX == toX");
            if (fromY == toY) {
                return false; // Not a move
            }
            int dir = (int) Math.signum(toY - fromY);
            for (int y1 = fromY + dir; y1 != toY; y1 += dir) {
                if (brikkene[fromX][y1] != null) {
                    return false;
                }
            }
            return true;
        } else if (fromY == toY) {
            System.out.println("fromY == toY");
            int dir = (int) Math.signum(toX - fromX);
            for (int x1 = fromX + dir; x1 != toX; x1 += dir) {System.out.println(brikkene[x1][fromY].rutenavn + "         " + dir + "       " + fromX);
                if (brikkene[x1][fromY] != null) {
                    return false;
                }
            }
            return true;
        }
       
        return false;
    }

}
