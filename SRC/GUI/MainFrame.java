package GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame {

    private JFrame jf;


    public MainFrame() {
        Components();
    }

    public void Components(){
        jf = new JFrame("Monopoly");
        //jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jf.setSize(new Dimension(500,500));
        jf.dispose();
        jf.setUndecorated(false);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLayout(new FlowLayout());

        pStreet p1 = new pStreet(0,"North Station", 250, Color.WHITE, true);
        pStreet p2 = new pStreet(0,"Electric Company ", 60, Color.PINK, false);
        p1.setLocation(5,5);
        p2.setLocation(87,5);
        jf.add(p1);
        jf.add(p2);
    }


}
