import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Destinations Destinations = new Destinations("X:\\Lancaster\\Year1Academic\\SCCx1A\\Summer_project\\summer_Project_2_39439453\\src\\Metrolink_times_linecolour.csv");
        String[] destinations = Destinations.GetDestinations();
        String FromDestination = destinations[0];
        String ToDestination = destinations[1];

        Route route = new Route(FromDestination, ToDestination, "X:\\Lancaster\\Year1Academic\\SCCx1A\\Summer_project\\summer_Project_2_39439453\\src\\Metrolink_times_linecolour.csv");
        route.findRoute();

        //Deploy Dijkstra
        //set as number of total unique stations in a file
        int verticies = 100;
        //change 100

        //from station is source
        int source = 0;

    }
}