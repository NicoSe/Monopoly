package GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame {

    private JFrame jf;
    private JRootPane jrp;
    private JLayeredPane jlp;


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


        jf.add(new pStreet(0,"North Carolina Avenue", 800, Color.BLUE));
    }


}
