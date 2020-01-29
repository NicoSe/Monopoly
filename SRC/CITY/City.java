package CITY;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class City {

    public static Field[] field;

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

    public Field getField(int pos){
        return field[pos];
    }

    public boolean loadCity(){
        if(!loadIndustry()) return false;
        if(!loadStations()) return false;
        if(!loadStreets()) return false;
        return true;
    }

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
                field[i] = new STREET(e[0], Double.parseDouble(e[1]), Integer.parseInt(e[2]), Double.parseDouble(e[3]), c,
                        Double.parseDouble(e[5]), Double.parseDouble(e[6]), Double.parseDouble(e[7]), Double.parseDouble(e[8]),
                        Double.parseDouble(e[9]), Double.parseDouble(e[10]), Double.parseDouble(e[11]));
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

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
            field[5] = new STATION_Field(e[0], Double.parseDouble(e[1]), Integer.parseInt(e[2]), Double.parseDouble(e[3]), Color.WHITE,
                     Double.parseDouble(e[5]), Double.parseDouble(e[6]), Double.parseDouble(e[7]), Double.parseDouble(e[8]));

            line = r.readLine();
            e = line.split(",");
            field[15] = new STATION_Field(e[0], Double.parseDouble(e[1]), Integer.parseInt(e[2]), Double.parseDouble(e[3]), Color.WHITE,
                     Double.parseDouble(e[5]), Double.parseDouble(e[6]), Double.parseDouble(e[7]), Double.parseDouble(e[8]));

            line = r.readLine();
            e = line.split(",");
            field[25] = new STATION_Field(e[0], Double.parseDouble(e[1]), Integer.parseInt(e[2]), Double.parseDouble(e[3]), Color.WHITE,
                    Double.parseDouble(e[5]), Double.parseDouble(e[6]), Double.parseDouble(e[7]), Double.parseDouble(e[8]));

            line = r.readLine();
            e = line.split(",");
            field[35] = new STATION_Field(e[0], Double.parseDouble(e[1]), Integer.parseInt(e[2]), Double.parseDouble(e[3]), Color.WHITE,
                    Double.parseDouble(e[5]), Double.parseDouble(e[6]), Double.parseDouble(e[7]), Double.parseDouble(e[8]));
        } catch (IOException e) {
            return false;
        }
        return true;
    }

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
            field[12] = new INDUSTRY_Field(e[0], Double.parseDouble(e[1]), Integer.parseInt(e[2]), Double.parseDouble(e[3]), Color.GRAY);

            line = r.readLine();
            e = line.split(",");
            field[28] = new INDUSTRY_Field(e[0], Double.parseDouble(e[1]), Integer.parseInt(e[2]), Double.parseDouble(e[3]), Color.GRAY);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
