package LOGIC;

public class City {

    public static Field[] field;

    public City(){
        Dice die = new Dice();

        field = new Field[39];
        field[0] = new LOS_Field();
        field[2] = new COMUNITY_Field();
        field[4] = new PAY_Field();
        field[7] = new EVENT_Field();
        field[9] = new PRISON_Field();
        field[17] = new COMUNITY_Field();
        field[20] = new PARK_Field();
        field[22] = new EVENT_Field();
        field[30] = new GoToP_Field();
        field[33] = new COMUNITY_Field();
        field[36] = new EVENT_Field();
        field[38] = new PAY_Field();



    }
}
