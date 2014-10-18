package sjakkspill;

/**
 * Skal opprette et sjakkbrett med dens komponeneter og fungere enveis.(Kun hvit
 * som skal fungere i første omgang.
 *
 * @author Ohrius
 */
public class SjakkSpill {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Brett.lagBrett();
                SjakkGui gui = new SjakkGui();
                gui.setVisible(true);
            }
        });

    }

}
