package LOGIC;

interface Field {

    String getName();

    //execute the spezific action an the player who moved, e.g. buy a street
    void action(Player player);
}
