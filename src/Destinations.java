import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class Destinations
{
    private String file;
    private final Set<String> stations;
    private String destination1;
    private String destination2;
    private int lineCount = -1;
    private boolean checkDestination1True;
    private boolean checkDestination2True;

    public Destinations(Set<String> stations)
    {
        this.stations = stations;
        this.file = file;
    }

    public String[] getDestinations()
    {

        Scanner scanInput = new Scanner(System.in);
        String from; //DESTINATION 1 AND 2 variables from destination bugfix, refactored name watch for missing
        String to;
        checkDestination1True = false;
        checkDestination2True = false;

        while (true)
        {
            System.out.print("Enter current station: ");
            from = scanInput.nextLine().trim();
            System.out.print("Enter target station: ");
            to = scanInput.nextLine().trim();
            lineCount += 1;

            if (!stations.contains(from))
            {
                System.out.println("ERROR NO STATION: " + from);
                continue;

            }
            if (!stations.contains(to))
            {
                System.out.println("ERROR NO STATION: " + to);
                continue;
        }
        break;
    }
        System.out.println("You are getting a train from " + from + " to " + to);
        return new String[]{from, to};
    }
}