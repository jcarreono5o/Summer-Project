import java.util.*;

public class Main {
    public static void main(String[] args) {
        String file = "X:\\Lancaster\\Year1Academic\\SCCx1A\\Summer_project\\summer_Project_2_39439453\\src\\Metrolink_times_linecolour.csv";
        Destinations Destinations = new Destinations(file);
        String[] destinations = Destinations.GetDestinations();
        String fromDestination = destinations[0];
        String toDestination = destinations[1];

        int IntLineCount = Integer.parseInt(destinations[2]);
        String lineCount = destinations[2];

        //Deploy Dijkstra
        //set as number of total unique stations in a file
        int verticies = IntLineCount;
        //change 100
        //from station is source
        int source = 0;


        List<List<Node>> adjacencyList = new ArrayList<List<Node>>();
        for (int i = 0; i < verticies; i++) {
            adjacencyList.add(new ArrayList<Node>());
        }

    }

}