package GUI;

import LOGIC.Options;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;

public class pStreet extends JPanel {

    public pStreet(int orientation, String name, double prize, Color c, boolean special_street){
        if(!special_street) {
            JPanel pColor = new JPanel();
            JLabel pName = new JLabel("", SwingConstants.CENTER);
            JLabel pName2 = new JLabel("", SwingConstants.CENTER);
            JLabel pPrize = new JLabel("", SwingConstants.CENTER);

            switch (orientation) {
                case 0: {
                    this.setSize(new Dimension(85, 150));

                    pColor.setSize(new Dimension(75, 30));
                    pColor.setLocation(5, 115);

                    pName.setLocation(5, 5);
                    pName2.setLocation(5, 15);
                    pPrize.setLocation(5, 95);
                    break;
                }
                case 1: {
                    this.setSize(new Dimension(150, 85));

                    pColor.setSize(new Dimension(30, 75));
                    pColor.setLocation(115, 5);

                    pName.setLocation(25, 5);
                    pName2.setLocation(25, 15);
                    pPrize.setLocation(25, 60);
                    break;
                }
                case 2: {
                    this.setSize(new Dimension(150, 85));

                    pColor.setSize(new Dimension(30, 75));
                    pColor.setLocation(5, 5);

                    pName.setLocation(55, 4);
                    pName2.setLocation(55, 15);
                    pPrize.setLocation(55, 60);
                    break;
                }
                case 3: {
                    this.setSize(new Dimension(85, 150));

                    pColor.setSize(new Dimension(75, 30));
                    pColor.setLocation(5, 5);

                    pName.setLocation(5, 40);
                    pName2.setLocation(5, 50);
                    pPrize.setLocation(5, 125);
                    break;
                }
            }


            this.setBackground(Color.WHITE);
            this.setVisible(true);
            this.setOpaque(true);
            this.setBorder(new CompoundBorder(this.getBorder(), new LineBorder(Color.BLACK, 3)));

            pColor.setBackground(c);
            pColor.setBorder(new CompoundBorder(pColor.getBorder(), new LineBorder(Color.BLACK, 2)));

            pName.setSize(new Dimension(75, 10));
            pName.setFont(new Font("Arial", Font.PLAIN, 10));
            pName2.setSize(new Dimension(75, 10));
            pName2.setFont(new Font("Arial", Font.PLAIN, 10));

            if (name.length() >= 14) {
                String[] text = name.split("\\s+");
                String text1;
                String text2;
                if (text[0].length() + text[1].length() < 14) {
                    text1 = text[0] + " " + text[1];
                    text2 = "";
                    if (!text[2].isEmpty()) text2 = text[2];
                } else {
                    text1 = text[0];
                    if (text.length > 2) {
                        if (text[1].length() + text[2].length() < 14) {
                            text2 = text[1] + " " + text[2];
                        } else text2 = text[1];
                    } else text2 = text[1];
                }
                pName.setText(text1);
                pName2.setText(text2);
            } else pName.setText(name);

            pPrize.setText("(" + (int) prize + Options.moneySpecifier + ")");
            pPrize.setSize(new Dimension(75, 20));
            pPrize.setFont(new Font("Arial", Font.PLAIN, 10));

            this.add(pColor);
            this.add(pName);
            this.add(pName2);
            this.add(pPrize);
        }
        else{
            JLabel png = new JLabel();
            JLabel pName = new JLabel("", SwingConstants.CENTER);
            JLabel pName2 = new JLabel("", SwingConstants.CENTER);
            JLabel pPrize = new JLabel("", SwingConstants.CENTER);

            switch (orientation) {
                case 0: {
                    this.setSize(new Dimension(85, 150));

                    try {
                        png.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/Sprites/station_icon2.png"))));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    png.setLocation(5, 30);
                    pName.setLocation(5, 5);
                    pName2.setLocation(5, 15);
                    pPrize.setLocation(5, 125);
                    break;
                }
                case 1: {
                    this.setSize(new Dimension(150, 85));

                    pName.setLocation(25, 5);
                    pName2.setLocation(25, 15);
                    pPrize.setLocation(25, 60);
                    break;
                }
                case 2: {
                    this.setSize(new Dimension(150, 85));

                    pName.setLocation(55, 4);
                    pName2.setLocation(55, 15);
                    pPrize.setLocation(55, 60);
                    break;
                }
                case 3: {
                    this.setSize(new Dimension(85, 150));

                    pName.setLocation(5, 40);
                    pName2.setLocation(5, 50);
                    pPrize.setLocation(5, 125);
                    break;
                }
            }


            this.setBackground(Color.WHITE);
            this.setVisible(true);
            this.setOpaque(true);
            this.setBorder(new CompoundBorder(this.getBorder(), new LineBorder(Color.BLACK, 3)));

            png.setLocation(5,5);
            png.setSize(new Dimension(75,50));

            pName.setSize(new Dimension(75, 10));
            pName.setFont(new Font("Arial", Font.PLAIN, 10));
            pName2.setSize(new Dimension(75, 10));
            pName2.setFont(new Font("Arial", Font.PLAIN, 10));

            if (name.length() >= 14) {
                String[] text = name.split("\\s+");
                String text1;
                String text2;
                if (text[0].length() + text[1].length() < 14) {
                    text1 = text[0] + " " + text[1];
                    text2 = "";
                    if (!text[2].isEmpty()) text2 = text[2];
                } else {
                    text1 = text[0];
                    if (text.length > 2) {
                        if (text[1].length() + text[2].length() < 14) {
                            text2 = text[1] + " " + text[2];
                        } else text2 = text[1];
                    } else text2 = text[1];
                }
                pName.setText(text1);
                pName2.setText(text2);
            } else pName.setText(name);

            pPrize.setText("(" + (int) prize + Options.moneySpecifier + ")");
            pPrize.setSize(new Dimension(75, 20));
            pPrize.setFont(new Font("Arial", Font.PLAIN, 10));

            this.add(png);
            this.add(pName);
            this.add(pName2);
            this.add(pPrize);
        }
    }
}
