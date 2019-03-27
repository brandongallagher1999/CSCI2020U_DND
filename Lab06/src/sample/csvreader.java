package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class csvreader {


    int flashFlood = 0;

    int severe_thunderstorm = 0;

    int special_marine = 0;

    int tornado = 0;

    public csvreader()
    {
    }

    public void setValues() {
        try{
            File file = new File("src/sample/weatherwarnings-2015.csv");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("FLASH FLOOD")) {
                    flashFlood++;
                }
                if (line.contains("TORNADO")) {
                    tornado++;
                }
                if (line.contains("SPECIAL MARINE")) {
                    special_marine++;
                }
                if (line.contains("SEVERE THUNDERSTORM")) {
                    severe_thunderstorm++;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getStackTrace());
        }


    }

    public int getFlashFlood()
    {
        return this.flashFlood;
    }

    public int getTornado()
    {
        return this.tornado;
    }

    public int getSpecial_marine()
    {
        return this.special_marine;
    }

    public int getSevere_thunderstorm()
    {
        return this.severe_thunderstorm;
    }


}
