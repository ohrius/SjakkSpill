package sjakkspill;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import static sjakkspill.Brett.brikkene;

/**
 *
 * @author Ohrius
 */
public class SjakkFlate extends JPanel {

    private final int BREDDE = 800;
    private final int HØYDE = 800;
    private final Color grå = Color.GRAY;
    private final Color lysegrå = Color.LIGHT_GRAY;
    private int xx = -800;
    private int yy = 0;

    /**
     * Tegner sjakkbrettet og alle brikkene.
     */
    public SjakkFlate() {
        super();
        Dimension dim = new Dimension(BREDDE, HØYDE);
        setPreferredSize(dim);
    }

    @Override
    public void paintComponent(Graphics g) {

        for (int i = 1; i < 9; i++) {
            for (int u = 1; u < 9; u++) {
                if ((i + u) % 2 == 0) {
                    g.setColor(grå);
                    g.fillRect(xx, yy, BREDDE / 8, HØYDE / 8);
                }
                if ((i + u) % 2 != 0) {
                    g.setColor(lysegrå);
                    g.fillRect(xx, yy, BREDDE / 8, HØYDE / 8);
                }

                int i1 = i - 1 + 97;
                int u1 = u - 1;

                String a = (char) i1 + Integer.toString(u1);

                //Denne setter opp rutenavn
                g.setColor(Color.BLACK);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
                g.drawString(a, xx + 5, yy + 10);

                //denne tegner brikkene
                Brikke b = brikkene[u - 1][i - 1];
                if (b != null) {
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
                    String ut = b.getNavn();
                    g.setColor(b.getFarge());
                    g.drawString(ut, xx + 35, yy + 60);

                }
                yy = yy + 100;
            }
            yy = 0;
            xx = xx + 100;
        }
    }

}
