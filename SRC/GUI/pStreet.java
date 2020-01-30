package GUI;

import LOGIC.Options;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class pStreet extends JPanel {

    public pStreet(int orientation, String name, double prize, Color c){
        JPanel pColor = new JPanel();
        JLabel pName = new JLabel();
        JLabel pName2 = new JLabel();
        JLabel pPrize = new JLabel();

        switch (orientation){
            case 0:{
                this.setSize(new Dimension(85,150));

                pColor.setSize(new Dimension(75,30));
                pColor.setLocation(5,115);

                pName.setLocation(5,5);
                pName2.setLocation(5,15);
                pPrize.setLocation(25,35);
                break;
            }
            case 1:{
                this.setSize(new Dimension(150,85));

                pColor.setSize(new Dimension(30,75));
                pColor.setLocation(115,5);

                pName.setLocation(5,35);
                pPrize.setLocation(17,60);
                break;
            }
            case 2:{
                this.setSize(new Dimension(150,85));

                pColor.setSize(new Dimension(30,75));
                pColor.setLocation(5,5);

                pName.setLocation(52,35);
                pPrize.setLocation(75,60);
                break;
            }
            case 3:{
                this.setSize(new Dimension(85,150));

                pColor.setSize(new Dimension(75,30));
                pColor.setLocation(5,5);

                pName.setLocation(5,100);
                pPrize.setLocation(25,125);
                break;
            }
        }


        this.setBackground(Color.WHITE);
        this.setVisible(true);
        this.setOpaque(true);
        this.setBorder(new CompoundBorder(this.getBorder(), new LineBorder(Color.BLACK, 3)));

        pColor.setBackground(c);
        pColor.setBorder(new CompoundBorder(pColor.getBorder(), new LineBorder(Color.BLACK, 2)));

        pName.setSize(new Dimension(75,10));
        pName.setFont(new Font("Arial", Font.PLAIN, 10));
        pName.setSize(new Dimension(75,10));
        pName.setFont(new Font("Arial", Font.PLAIN, 10));

        if (name.length() >= 14){
            String[] text = name.split("\\s+");
            String text1;
            String text2;
            if(text[0].length() + text[1].length() <14) {
                text1 = text[0] + " " + text[1];
                text2 = "";
                if(!text[2].isEmpty()) text2 = text[2];
            }
            else{
                text1 = text[0];
                if(!text[1].isEmpty() && !text[2].isEmpty()){
                    if(text[1].length() + text[2].length() <14) {
                        text2 = text[1] + " " + text[2];
                    }
                    else text2 = text[1];
                }
                else text2 = text[1];
            }
            pName.setText(text1);
            pName2.setText(text2);
        }
        else pName.setText(name);

        pPrize.setText("("+ (int)prize + Options.moneySpecifier + ")");
        pPrize.setSize(new Dimension(40,20));
        pPrize.setFont(new Font("Arial", Font.PLAIN, 10));

        this.add(pColor);
        this.add(pName);
        this.add(pName2);
        this.add(pPrize);
    }
}
