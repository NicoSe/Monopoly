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

public class OptionsUI {
    private JRadioButton DOLLARradio;
    private JRadioButton EUROradio;
    private JRadioButton YENradio;
    private JRadioButton BTCradio;
    private JRadioButton Kradio;
    private JRadioButton MIOradio;
    private JRadioButton MRDradio;
    private JSlider slider1;
    private JPanel MainPanel;
    private JButton SAVECHANGESButton;
    private JCheckBox RollCheck;

    public OptionsUI() {
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //TODO: update music
                Options.volume = slider1.getValue();
            }
        });
        RollCheck.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                Options.rollSelf = !Options.rollSelf;
            }
        });
        DOLLARradio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DOLLARradio.setSelected(true);
                EUROradio.setSelected(false);
                YENradio.setSelected(false);
                BTCradio.setSelected(false);
                Options.occurency = Occurency.$;
            }
        });
        EUROradio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DOLLARradio.setSelected(false);
                EUROradio.setSelected(true);
                YENradio.setSelected(false);
                BTCradio.setSelected(false);
                Options.occurency = Occurency.€;
            }
        });
        YENradio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DOLLARradio.setSelected(false);
                EUROradio.setSelected(false);
                YENradio.setSelected(true);
                BTCradio.setSelected(false);
                Options.occurency = Occurency.¥;
            }
        });
        BTCradio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DOLLARradio.setSelected(false);
                EUROradio.setSelected(false);
                YENradio.setSelected(false);
                BTCradio.setSelected(true);
                Options.occurency = Occurency.Ƀ;
            }
        });

        Kradio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Kradio.setSelected(true);
                MIOradio.setSelected(false);
                MRDradio.setSelected(false);
                Options.moneySpecifier = MoneySpecifier.K;
            }
        });
        MIOradio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Kradio.setSelected(false);
                MIOradio.setSelected(true);
                MRDradio.setSelected(false);
                Options.moneySpecifier = MoneySpecifier.Mio;
            }
        });
        MRDradio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Kradio.setSelected(false);
                MIOradio.setSelected(false);
                MRDradio.setSelected(true);
                Options.moneySpecifier = MoneySpecifier.Mrd;
            }
        });

        SAVECHANGESButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Options.saveOptions();
                Main.getBackgroundPanel().removeAll();
                Main.getBackgroundPanel().add((new HomeUI().init()));
                Main.getJFrame().revalidate();
                Main.getJFrame().repaint();
            }
        });
    }

    public JPanel init(){
        MainPanel.setBounds(240,0,1920,1080);
        slider1.setValue((int)LOGIC.Options.volume);

        RollCheck.setSelected(Options.rollSelf);

        if(LOGIC.Options.occurency == Occurency.$) {
            DOLLARradio.setSelected(true);
            EUROradio.setSelected(false);
            YENradio.setSelected(false);
            BTCradio.setSelected(false);
        }
        else if(LOGIC.Options.occurency == Occurency.€) {
            DOLLARradio.setSelected(false);
            EUROradio.setSelected(true);
            YENradio.setSelected(false);
            BTCradio.setSelected(false);
        }
        else if(LOGIC.Options.occurency == Occurency.¥) {
            DOLLARradio.setSelected(false);
            EUROradio.setSelected(false);
            YENradio.setSelected(true);
            BTCradio.setSelected(false);
        }
        else if(LOGIC.Options.occurency == Occurency.Ƀ) {
            DOLLARradio.setSelected(false);
            EUROradio.setSelected(false);
            YENradio.setSelected(false);
            BTCradio.setSelected(true);
        }

        if(LOGIC.Options.moneySpecifier == MoneySpecifier.K){
            Kradio.setSelected(true);
            MIOradio.setSelected(false);
            MRDradio.setSelected(false);
        }
        else if(LOGIC.Options.moneySpecifier == MoneySpecifier.Mio){
            Kradio.setSelected(false);
            MIOradio.setSelected(true);
            MRDradio.setSelected(false);
        }
        else if(LOGIC.Options.moneySpecifier == MoneySpecifier.Mrd){
            Kradio.setSelected(false);
            MIOradio.setSelected(false);
            MRDradio.setSelected(true);
        }
        return MainPanel;}
}
