package GUI;

import LOGIC.Options;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class pStreet extends JPanel {

    public pStreet(Color c, String name, double prize){
        this.setSize(new Dimension(100,170));
        this.setBackground(Color.WHITE);
        this.setVisible(true);
        this.setOpaque(true);
        this.setBorder(new CompoundBorder(this.getBorder(), new LineBorder(Color.BLACK, 3)));

        JPanel pColor = new JPanel();
        pColor.setBackground(c);
        pColor.setSize(new Dimension(90,30));
        pColor.setLocation(5,5);
        pColor.setBorder(new CompoundBorder(pColor.getBorder(), new LineBorder(Color.BLACK, 2)));

        JLabel pName = new JLabel();
        pName.setText(name);
        pName.setSize(new Dimension(80,30));
        pName.setLocation(10,90);
        pName.setAlignmentX(CENTER_ALIGNMENT);

        JLabel pPrize = new JLabel();
        pPrize.setText("( "+ prize + Options.moneySpecifier + " )");
        pPrize.setSize(new Dimension(80,30));
        pPrize.setLocation(10,120);

        this.add(pColor);
        this.add(pName);
        this.add(pPrize);
    }
}
