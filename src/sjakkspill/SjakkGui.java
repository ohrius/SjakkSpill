/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sjakkspill;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static sjakkspill.Brett.brikkene;

/**
 * Setter opp gui med knapper og sjakkbrett
 *
 * @author Ohrius
 */
public class SjakkGui extends JFrame implements ActionListener {

    private String oppdatert = "Neste trekk:";
    private JTextField fraTxt, tilTxt, toppTxt;
    private JButton flytt, lagre, nyttSpill;
    private JTextField txtFra, txtTil;
    private SjakkFlate Sjakk;

    public SjakkGui() {
        lagGui1();
    }

    private void lagGui1() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        String tittel = "Sjakk   spillNr: " + Brett.spillNr;
        setTitle(tittel);
        BorderLayout bl = new BorderLayout();
        bl.setHgap(0);
        bl.setVgap(0);
        setLayout(bl);
        
        JLabel lblTopp = new JLabel(oppdatert);
        add(lblTopp, BorderLayout.NORTH);
        Sjakk = new SjakkFlate();
        add(Sjakk, BorderLayout.CENTER);
        
        JPanel resPanel = new JPanel();
        resPanel.setLayout(new GridLayout(1, 1, 1, 1));

        JLabel lblFra = new JLabel("Fra rute:");
        lblFra.setHorizontalAlignment(JLabel.RIGHT);
        resPanel.add(lblFra);
        txtFra = new JTextField(2);
        resPanel.add(txtFra);

        JLabel lblTil = new JLabel("Til rute:");
        lblTil.setHorizontalAlignment(JLabel.RIGHT);
        resPanel.add(lblTil);
        txtTil = new JTextField(2);
        resPanel.add(txtTil);

        flytt = new JButton("FLYTT");
        flytt.addActionListener(this);
        resPanel.add(new JPanel());
        resPanel.add(flytt);

        lagre = new JButton("Lagre");
        //lagre.addActionListener(this);
        resPanel.add(new JPanel());
        resPanel.add(lagre);

        nyttSpill = new JButton("Nytt spill");
        //nyttSpill.addActionListener(this);
        resPanel.add(new JPanel());
        resPanel.add(nyttSpill);

        add(resPanel, BorderLayout.SOUTH);
        setResizable(false);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fraRute = new String(txtFra.getText());
        String tilRute = new String(txtTil.getText());
        if (Brett.erLovligRutenavn(fraRute) && Brett.erLovligRutenavn(tilRute)) {
            if (brikkene[0][0].getBrikke(fraRute) != null) {
                Brikke b = brikkene[0][0].getBrikke(fraRute);
                if (b.getFarge() == Color.WHITE) {
                    b.flyttBrikke(fraRute, tilRute);
                    oppdatert = "Neste trekk";
                } else {
                    System.out.println("feil farge");
                }
                oppdatert = "Brikken må være hvit";
            }else {
            System.out.println("ingen brikke i frarute");
            oppdatert = "Det må være en brikke i fraRute";
        }

        System.out.println("Rutenavnene fungerer");

    }

    
        else{
        System.out.println("Ugyldig rutenavn");
        oppdatert = "Ugyldig trekk.";
    }

    System.out.println (fraRute 

    + "  " + tilRute);
    //Sjakk.validate();
    //Sjakk.repaint();
}
}
