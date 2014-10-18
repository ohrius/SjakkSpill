package sjakkspill;

import java.awt.Color;

/**
 *Abstrakt klasse til alle brikker på brettet.
 * @author Ohrius
 */
public abstract class Brikke extends Brett {

    protected final Color HVIT = Color.WHITE;
    protected final Color SVART = Color.BLACK;

    //variabler til brikke
    protected String rutenavn;
    protected int x;
    protected int y;
    protected String navn;
    protected Color farge;

    public Brikke(String rutenavn, int x, int y, String navn, Color farge) {
        this.rutenavn = rutenavn;
        this.x = x;
        this.y = y;
        this.navn = navn;
        this.farge = farge;
    }

    //Set/Get metoder

    public String getRutenavn() {
        return rutenavn;
    }

    public void setRutenavn(String rutenavn) {
        this.rutenavn = rutenavn;
    }

    public Color getFarge() {
        return farge;
    }

    public void setFarge(Color farge) {
        this.farge = farge;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    //ErLovligTrekk bruker subklassenes metoder istedenfor denne.
    public boolean erLovligTrekk(String rutenavn) {
        if (Brett.erLovligRutenavn(rutenavn)) {
            rutenavn.toLowerCase();
            int r1 = this.rutenavn.charAt(0);
            int r2 = this.rutenavn.charAt(1);
            int l1 = rutenavn.charAt(0);
            int l2 = rutenavn.charAt(1);
            if (r1 == l1) {
                if (r2 == (l2+1)) {
                    return true;
                }
            }
        }
        return false;
    }

    
    //flytter brikken fra rutenavnet og gir nytt rutenavn.
    //Setter også gammel posisjon til null
    public boolean flyttTil(String rutenavn) {
                String old = this.getRutenavn();
                int l = old.charAt(0)-97;
                int l1 = old.charAt(1)-48;
                this.setRutenavn(rutenavn);
                int r = rutenavn.charAt(0)-97;
                int r1 = rutenavn.charAt(1)-48;
                brikkene[r1][r] = this;
                brikkene[l1][l] = null;
                return true;
    }

}
