package LOGIC;

public class City {

    public static Field[] field;

    public City(){
        field = new Field[39];

        field[0] = new LOS_Field();
        field[1] = new Field();
        field[2] = new COMMUNITY_Field();
        field[3] = new Field();
        field[4] = new PAY_Field("Income Tax", 2000);
        field[5] = new Field();
        field[6] = new Field();
        field[7] = new EVENT_Field();
        field[8] = new Field();
        field[9] = new PRISON_Field();
        field[10] = new Field();
        field[11] = new Field();
        field[12] = new Field();
        field[13] = new Field();
        field[14] = new Field();
        field[15] = new Field();
        field[16] = new Field();
        field[17] = new COMMUNITY_Field();
        field[18] = new Field();
        field[19] = new Field();
        field[20] = new PARK_Field();
        field[21] = new Field();
        field[22] = new EVENT_Field();
        field[23] = new Field();
        field[24] = new Field();
        field[25] = new Field();
        field[26] = new Field();
        field[27] = new Field();
        field[28] = new Field();
        field[29] = new Field();
        field[30] = new GoToP_Field();
        field[31] = new Field();
        field[32] = new Field();
        field[33] = new COMMUNITY_Field();
        field[34] = new Field();
        field[35] = new Field();
        field[36] = new EVENT_Field();
        field[37] = new Field();
        field[38] = new PAY_Field("Luxury Tax", 1000);
    }

    public Field getField(int pos){
        return field[pos];
    }

    public boolean loadCity(){
        return true;
    }
}
