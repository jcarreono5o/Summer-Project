import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

public class Route
{
private String Destination1;
private String Destination2;
private String File;

    public Route(String destination1, String destination2, String file)
    {
        Destination1 = destination1;
        Destination2 = destination2;
        File = file;
    }

    //read file
    void CSVtoList()
    {
        List<List<String>> MetroList = new ArrayList<>();
        String line;
        String delimiter = ",";

        try(BufferedReader reader = new BufferedReader(new FileReader(File)) )
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

    //find shortest path, each node connects and takes +2
    //get route
    void findRoute()
    {
        System.out.println("Finding the best route from " + Destination1 + " to " + Destination2 + ":");


    }

    //multiple routes, pick any and print
    //output with stations in between adn lines then print overall journey time
    //explicit indication of where changes are needed when outputted, "change line to-"

}
