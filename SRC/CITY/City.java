package CITY;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class City {

    // static field, can be seen in any other function to easy change and call values
    public static Field[] field;

    // initialize the whole field, based on the loaded csv data
    public City(){
        field = new Field[40];

        field[0] = new LOS_Field();
        field[2] = new COMMUNITY_Field();
        field[4] = new PAY_Field("Income Tax", 200);
        field[7] = new EVENT_Field();
        field[10] = new PRISON_Field();
        field[17] = new COMMUNITY_Field();
        field[20] = new PARK_Field();
        field[22] = new EVENT_Field();
        field[30] = new GoToP_Field();
        field[33] = new COMMUNITY_Field();
        field[36] = new EVENT_Field();
        field[38] = new PAY_Field("Luxury Tax", 100);

        loadCity();
    }

    // return true if all fields are loaded correctly
    public boolean loadCity(){
        if(!loadIndustry()) return false;
        if(!loadStations()) return false;
        if(!loadStreets()) return false;
        return true;
    }

    // load all streets from streets.csv
    private boolean loadStreets() {
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("CSV/streets.csv");
            InputStreamReader sr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader r = new BufferedReader(sr);
            r.readLine();

            int i = 0;
            while(field.length>i){
                if (field[i] != null) {
                    i++;
                    continue;
                }
                String line = r.readLine();
                String[] e = line.split(",");
                Color c;
                switch (e[4]){
                    case "brown": c = new Color(102,51,0);break;
                    case "cyan": c = Color.CYAN;break;
                    case "pink": c = Color.PINK;break;
                    case "orange": c = Color.ORANGE;break;
                    case "red": c = Color.RED;break;
                    case "yellow": c = Color.YELLOW;break;
                    case "green": c = Color.GREEN;break;
                    case "blue": c = Color.BLUE;break;
                    default:
                        return false;
                }
                field[i] = new STREET(e[0], Integer.parseInt(e[1]), Integer.parseInt(e[2]), Integer.parseInt(e[3]), c,
                        Integer.parseInt(e[5]), Integer.parseInt(e[6]), Integer.parseInt(e[7]), Integer.parseInt(e[8]),
                        Integer.parseInt(e[9]), Integer.parseInt(e[10]), Integer.parseInt(e[11]));
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    // load stations from statons.csv
    private boolean loadStations(){
        if(field[5] != null || field[15] != null || field[25] != null || field[35] != null) return false;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("CSV/stations.csv");
            InputStreamReader sr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader r = new BufferedReader(sr);
            r.readLine();

            String line = r.readLine();
            String[] e = line.split(",");
            field[5] = new STATION_Field(e[0], Integer.parseInt(e[1]), Integer.parseInt(e[2]), Integer.parseInt(e[3]), Color.WHITE,
                     Integer.parseInt(e[5]), Integer.parseInt(e[6]), Integer.parseInt(e[7]), Integer.parseInt(e[8]));

            line = r.readLine();
            e = line.split(",");
            field[15] = new STATION_Field(e[0], Integer.parseInt(e[1]), Integer.parseInt(e[2]), Integer.parseInt(e[3]), Color.WHITE,
                     Integer.parseInt(e[5]), Integer.parseInt(e[6]), Integer.parseInt(e[7]), Integer.parseInt(e[8]));

            line = r.readLine();
            e = line.split(",");
            field[25] = new STATION_Field(e[0], Integer.parseInt(e[1]), Integer.parseInt(e[2]), Integer.parseInt(e[3]), Color.WHITE,
                    Integer.parseInt(e[5]), Integer.parseInt(e[6]), Integer.parseInt(e[7]), Integer.parseInt(e[8]));

            line = r.readLine();
            e = line.split(",");
            field[35] = new STATION_Field(e[0], Integer.parseInt(e[1]), Integer.parseInt(e[2]), Integer.parseInt(e[3]), Color.WHITE,
                    Integer.parseInt(e[5]), Integer.parseInt(e[6]), Integer.parseInt(e[7]), Integer.parseInt(e[8]));
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    // load industry from industry.csv
    private boolean loadIndustry(){
        if(field[12] != null || field[28] != null) return false;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("CSV/industry.csv");
            InputStreamReader sr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader r = new BufferedReader(sr);

            r.readLine();
            String line = r.readLine();
            String[] e = line.split(",");
            field[12] = new INDUSTRY_Field(e[0], Integer.parseInt(e[1]), Integer.parseInt(e[2]), Integer.parseInt(e[3]), Color.GRAY);

            line = r.readLine();
            e = line.split(",");
            field[28] = new INDUSTRY_Field(e[0], Integer.parseInt(e[1]), Integer.parseInt(e[2]), Integer.parseInt(e[3]), Color.GRAY);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
