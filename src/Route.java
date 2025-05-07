import java.sql.SQLOutput;
import java.util.Scanner;

public class Route
{
private String Destination1;
private String Destination2;
private String File;
private float ChangeTimeMinutes = 2;
private String line = "";

    public Route(String destination1, String destination2, String file) {
        Destination1 = destination1;
        Destination2 = destination2;
        File = file;
    }

    void findRoute()
    {
        System.out.println("Finding the best route from " + Destination1 + " to " + Destination2 + ":");
        //read file
        try{
            Scanner scan = new Scanner(File);

            while(scan.hasNext())
            {
                //print all line to test    System.out.println(scan.nextLine());
                String[] values = scan.nextLine().split("\n");
                System.out.println(values[0]);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        //find shortest path, each node connects and takes +2
        //get route
        //multiple routes, pick any and print
        //output with stations in between adn lines then print overall journey time
        //explicit indication of where changes are needed when outputted, "change line to-"
    }

}
