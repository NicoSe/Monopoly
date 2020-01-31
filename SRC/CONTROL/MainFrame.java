package CONTROL;

import javax.swing.*;

public class MainFrame {

    private JPanel MainPanel;
    private JPanel Street21;
    private JLabel lbNStreet21;
    private JLabel lbPStreet21;
    private JLabel lbNStreet23;
    private JLabel lbPStreet23;
    private JPanel Street23;
    private JPanel Street20;
    private JPanel Street19;
    private JLabel lbPStreet19;
    private JLabel lbNStreet19;
    private JPanel Board;
    private JPanel Street22;
    private JPanel Street24;
    private JLabel lbPStreet24;
    private JLabel lbNStreet25;
    private JLabel lbPStreet25;
    private JPanel Street25;
    private JPanel Street26;
    private JLabel lbNStreet26;
    private JLabel lbPStreet26;
    private JPanel Street27;
    private JLabel lbNStreet27;
    private JLabel lbPStreet27;
    private JLabel lbNStreet24;
    private JPanel Street28;
    private JLabel lbNStreet28;
    private JLabel lbPStreet28;
    private JPanel Street29;
    private JLabel lbNStreet29;
    private JLabel lbPStreet29;
    private JPanel Street30;
    private JPanel Street18;
    private JLabel lbNStreet18;
    private JLabel lbPStreet18;
    private JPanel Street17;
    private JPanel Street16;
    private JLabel lbNStreet16;
    private JLabel lbPStreet16;
    private JPanel Street15;
    private JLabel lbNStreet15;
    private JLabel lbPStreet15;

    public static void main(String[] args) {
        JFrame jf = new JFrame("Monopoly");
        jf.setContentPane(new MainFrame().MainPanel);
        jf.setSize(800,800);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
