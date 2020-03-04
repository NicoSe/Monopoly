package GUI;

import CONTROL.Main;
import LOGIC.MoneySpecifier;
import LOGIC.Occurency;
import LOGIC.Options;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameOptionsUI {
    private JPanel MainPanel;
    private JSlider slider1;
    private JSlider slider2;
    private JRadioButton BTCradio;
    private JButton ContinueButton;
    private JRadioButton YENradio;
    private JRadioButton EUROradio;
    private JRadioButton DOLLARradio;
    private JRadioButton Kradio;
    private JRadioButton MIOradio;
    private JRadioButton MRDradio;
    private JButton BACKButton;


    public JPanel init(){
        MainPanel.setBounds(240,0,1920,1080);


        // initialize mouse click
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                slider1.setToolTipText(String.valueOf(slider1.getValue()));
                int playerCount = slider1.getValue();
                slider2.setMaximum(6 - playerCount);
                slider2.setValue(0);
                if(slider1.getValue() == 1){
                    slider2.setMinimum(1);
                    slider2.setMaximum(5);
                    slider2.setValue(2);
                }
                slider1.setToolTipText(String.valueOf(slider1.getValue()));
            }
        });
        slider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                slider2.setToolTipText(String.valueOf(slider2.getValue()));
            }
        });
        DOLLARradio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DOLLARradio.setSelected(true);
                EUROradio.setSelected(false);
                YENradio.setSelected(false);
                BTCradio.setSelected(false);
            }
        });
        EUROradio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DOLLARradio.setSelected(false);
                EUROradio.setSelected(true);
                YENradio.setSelected(false);
                BTCradio.setSelected(false);
            }
        });
        YENradio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DOLLARradio.setSelected(false);
                EUROradio.setSelected(false);
                YENradio.setSelected(true);
                BTCradio.setSelected(false);
            }
        });
        BTCradio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DOLLARradio.setSelected(false);
                EUROradio.setSelected(false);
                YENradio.setSelected(false);
                BTCradio.setSelected(true);
            }
        });

        Kradio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Kradio.setSelected(true);
                MIOradio.setSelected(false);
                MRDradio.setSelected(false);
            }
        });
        MIOradio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Kradio.setSelected(false);
                MIOradio.setSelected(true);
                MRDradio.setSelected(false);
            }
        });
        MRDradio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Kradio.setSelected(false);
                MIOradio.setSelected(false);
                MRDradio.setSelected(true);
            }
        });

        ContinueButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Main.getBackgroundPanel().removeAll();
                Main.getBackgroundPanel().add((new GamePlayerManager(slider1.getValue(), slider2.getValue()).init()));
                Main.getJFrame().revalidate();
                Main.getJFrame().repaint();
            }
        });
        BACKButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Main.getBackgroundPanel().removeAll();
                Main.getBackgroundPanel().add((new HomeUI().init()));
                Main.getJFrame().revalidate();
                Main.getJFrame().repaint();
            }
        });

        // initialize default values
        if(Options.occurency == Occurency.$) {
            DOLLARradio.setSelected(true);
            EUROradio.setSelected(false);
            YENradio.setSelected(false);
            BTCradio.setSelected(false);
        }
        else if(Options.occurency == Occurency.€) {
            DOLLARradio.setSelected(false);
            EUROradio.setSelected(true);
            YENradio.setSelected(false);
            BTCradio.setSelected(false);
        }
        else if(Options.occurency == Occurency.¥) {
            DOLLARradio.setSelected(false);
            EUROradio.setSelected(false);
            YENradio.setSelected(true);
            BTCradio.setSelected(false);
        }
        else if(Options.occurency == Occurency.Ƀ) {
            DOLLARradio.setSelected(false);
            EUROradio.setSelected(false);
            YENradio.setSelected(false);
            BTCradio.setSelected(true);
        }

        if(Options.moneySpecifier == MoneySpecifier.K){
            Kradio.setSelected(true);
            MIOradio.setSelected(false);
            MRDradio.setSelected(false);
        }
        else if(Options.moneySpecifier == MoneySpecifier.Mio){
            Kradio.setSelected(false);
            MIOradio.setSelected(true);
            MRDradio.setSelected(false);
        }
        else if(Options.moneySpecifier == MoneySpecifier.Mrd){
            Kradio.setSelected(false);
            MIOradio.setSelected(false);
            MRDradio.setSelected(true);
        }
        return MainPanel;}
}
