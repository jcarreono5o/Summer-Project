import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataParser {
    private String destination1;
    private String destination2;
    private String file;

    private boolean found = false;
    private String nextStation;
    private String stationLine;
    private String travelTimeString;

    private List<List<String>> MetroList = new ArrayList<>();
    private String line;
    private String delimiter = ",";

    public DataParser(String destination1, String destination2, String file)
    {
        this.destination1 = destination1;
        this.destination2 = destination2;
        this.file = file;
    }

    public void parse()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(file)) )
        {
            while ((line = reader.readLine()) != null)
            {
                String[] values = line.split(delimiter);
                MetroList.add(Arrays.asList(values));
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        for (List<String> FromToLineTime : MetroList)
        {
            System.out.println(FromToLineTime);
        }
    }

    public String[] searchFromDestination()
    {
        for(List<String> FromToLineTime : MetroList)
        {
            if (FromToLineTime.contains(destination1))
            {
                found = true;
                nextStation = FromToLineTime.get(1);
                stationLine = FromToLineTime.get(2);
                travelTimeString = FromToLineTime.get(3);


            }
        }
        if (!found)
        {
            System.out.println("no file found ERROR");
        }
        return new String[]{nextStation, stationLine, travelTimeString};

    }
}
