import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Daniel Bojic
 * Date: 2020-10-22
 * Time: 10:24
 * Project: StenSaxPåse
 * Copyright: MIT
 */
public class Game extends JFrame implements ActionListener {
    JButton sten = new JButton("Sten");
    JButton sax = new JButton("Sax");
    JButton påse = new JButton("Påse");

    JPanel knapper = new JPanel();

    JButton sten2 = new JButton("Sten");
    JButton sax2 = new JButton("Sax");
    JButton påse2 = new JButton("Påse");

    JPanel knappar2 = new JPanel();

    JLabel meddelande = new JLabel("Välj en knapp", JLabel.CENTER);

    int vinst;
    int förlust;

    JLabel vinstL = new JLabel("Antal vinster: 0");
    JLabel förlustL = new JLabel("Antal förluster: 0");

    JPanel statistik = new JPanel();

    Game(){
        knapper.setLayout(new GridLayout(1,4));
        knapper.add(new JLabel("Ditt val ", JLabel.RIGHT));
        knapper.add(sten);
        knapper.add(sax);
        knapper.add(påse);

        knappar2.setLayout(new GridLayout(1,4));
        knappar2.add(new JLabel("Datorns val", JLabel.RIGHT));
        knappar2.add(sten2);
        knappar2.add(sax2);
        knappar2.add(påse2);

        statistik.setLayout(new GridLayout(1,2));
        statistik.add(vinstL);
        statistik.add(förlustL);

       setLayout(new GridLayout(4,0));
        add(knapper);
        add(knappar2);
        add(meddelande);
        add(statistik);

        sten.addActionListener(this);
        sax.addActionListener(this);
        påse.addActionListener(this);

        setSize(300,200);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final int STEN=0;
        final int SAX=1;
        final int PÅSE=2;
        int val;
        if (e.getSource() == sten){
            val=STEN;
            sten.setBackground(Color.BLUE);
            sten.setOpaque(true);
            sax.setBackground(Color.lightGray);
            påse.setBackground(Color.lightGray);
        } else if (e.getSource() == sax){
            val = SAX;
            sten.setBackground(Color.lightGray);
            sax.setBackground(Color.BLUE);
            sax.setOpaque(true);
            påse.setBackground(Color.lightGray);
        } else {
            val = PÅSE;
            sten.setBackground(Color.lightGray);
            sax.setBackground(Color.lightGray);
            påse.setBackground(Color.BLUE);
            påse.setOpaque(true);
        }

        int val2 = (int) (Math.random()*3);
        if (val2 == STEN){
            sten2.setBackground(Color.blue);
            sten2.setOpaque(true);
            sax2.setBackground(Color.lightGray);
            påse2.setBackground(Color.lightGray);
        } else if (val2 == SAX){
            sten2.setBackground(Color.lightGray);
            sax2.setBackground(Color.BLUE);
            sax2.setOpaque(true);
            påse2.setBackground(Color.lightGray);
        }else {
            sten2.setBackground(Color.lightGray);
            sax2.setBackground(Color.lightGray);
            påse2.setBackground(Color.BLUE);
            påse2.setOpaque(true);
        }

        if (val == val2){
            meddelande.setText("Oavgjort! Försök igen!");
        }else if (val == STEN && val2 == SAX ||
                  val == SAX && val2 == PÅSE ||
                val == PÅSE && val2 == STEN){
            meddelande.setText("Du vann! LATA BITCH! Ajde en gång till!");
            vinstL.setText("Antal vinster: " + ++vinst);
        }else {
            meddelande.setText("RIP! En gång till!");
            förlustL.setText("Antal förluster: " + ++förlust);
        }



    }
}
