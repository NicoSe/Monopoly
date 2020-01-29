package CITY;


import LOGIC.Player;

import java.awt.*;

public interface Streets {
    Color getColor();
    void changeOwner(Player player);
    Player getOwner();
    void changeHypothekStatus();
    double getHypothek();
    boolean isHypothek();
    double getPrize();
    boolean buyStreet(Player player);
    boolean payTax(Player player);
    String getName();
    void action(Player player);

}
