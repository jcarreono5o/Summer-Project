import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Destinations Destinations = new Destinations("X:\\Lancaster\\Year1Academic\\SCCx1A\\Summer_project\\summer_Project_2_39439453\\src\\Metrolink_times_linecolour.csv");
        Destinations.GetDestinations();
        String[] destinations = Destinations.GetDestinations();
        String FromDestination = destinations[0];
        String ToDestination = destinations[1];

        Route Route = new Route(FromDestination, ToDestination);
    }
}