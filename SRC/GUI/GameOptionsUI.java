package GUI;

import CITY.City;
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
    private JButton startGameButton;
    private JRadioButton YENradio;
    private JRadioButton EUROradio;
    private JRadioButton DOLLARradio;
    private JRadioButton Kradio;
    private JRadioButton MIOradio;
    private JRadioButton MRDradio;

    public GameOptionsUI() {
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int playerCount = slider1.getValue();
                slider2.setMaximum(6 - playerCount);
                slider2.setValue(0);
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
        startGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new City();
                Main.getBackgroundPanel().removeAll();
                Main.getBackgroundPanel().add((new GameUI().init()));
                Main.getJFrame().revalidate();
                Main.getJFrame().repaint();
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
    }

    public JPanel init(){
        int playerCount = slider1.getValue();
        slider2.setMaximum(6 - playerCount);
        slider2.setValue(0);

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
