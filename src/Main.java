import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        String file = "X:\\Lancaster\\Year1Academic\\SCCx1A\\Summer_project\\summer_Project_2_39439453\\src\\Metrolink_times_linecolour.csv";
        DataParser parser = new DataParser(file);
        //Deploy Dijkstra
        //set as number of total unique stations in a file
        //change 100
        //from station is source
        int source = 0;

        List<String[]> MetrolinkList = parser.parseAllLines();
        if (MetrolinkList.isEmpty())
        {
            System.out.println("No data found");
            return;
        }

    Map<String, Integer > StringtoIntStation = new HashMap<>();
        for (String[] StationToFromLineTime : MetrolinkList)
        {
        String from = StationToFromLineTime[0].trim(), to = StationToFromLineTime[1].trim();
        StringtoIntStation.putIfAbsent(from,StringtoIntStation.size());

        StringtoIntStation.putIfAbsent(to,StringtoIntStation.size());
    }

    int noOfStations = StringtoIntStation.size();
    String[] InttoStringStation = new String[noOfStations];
        for (Map.Entry<String, Integer> e :
                StringtoIntStation.entrySet())

        {
        InttoStringStation[e.getValue()] = e.getKey();
    }

    // adjacency list
    List<List<Node>> adjacencyList = new ArrayList<>();
        //list of list of nodes
        for (int i = 0; i < noOfStations; i++) adjacencyList.add(new ArrayList<>());
        //initialisse list, emopty
        for (String[] StationToFromLineTime : MetrolinkList)
        {
        String from = StationToFromLineTime[0].trim(), to = StationToFromLineTime[1].trim(), lineName = StationToFromLineTime[2].trim();
        double time = Double.parseDouble(StationToFromLineTime[3].trim());
        int originIndex = StringtoIntStation.get(from), destinationIndex = StringtoIntStation.get(to);

        adjacencyList.get(originIndex).add(new Node(destinationIndex, time, lineName));
        adjacencyList.get(destinationIndex).add(new Node(originIndex, time, lineName));
    }

    // user input into int ids, conversion
    Destinations dest = new Destinations(StringtoIntStation.keySet());
        //Map java, keyset for stationnames
    String[] choices = dest.getDestinations();

    int src = StringtoIntStation.get(choices[0]);
    int destination = StringtoIntStation.get(choices[1]);

    Scanner sc = new Scanner(System.in);
        System.out.println("1 for shortest route\n2 for fewest changes");
        int option = sc.nextInt();

//from source node to node we want, double check if route there exits
        Dijkstra dj;
        double penalty;
        if (option == 2)
        {
            System.out.println("*** Route with Fewest Changes ***");
            penalty = 3141589;
            dj = new Dijkstra(adjacencyList, penalty);
        } else {
            System.out.println("*** Route with Minimal Time ***");
            penalty = 2.0;
            dj = new Dijkstra(adjacencyList);
        }
        List<Node> path = dj.findPath(src, destination);

        if (path.isEmpty())
        {
            System.out.println("ERROR: Impossible route");
            return;
        }
        
    String previousLineSentence = "";
        for (Node step : path)
        {
        if (!previousLineSentence.isEmpty() && !step.line.equals(previousLineSentence))
        {
            System.out.println("*** Change line to " + step.line + " line ***");
        }
        String on = step.line.isEmpty() ? "go " : step.line + " line";
        System.out.println(InttoStringStation[step.node] + "  to  " + on);
        previousLineSentence = step.line;
    }

        double totalCost = path.get(path.size() - 1).cost;
        long changes = path.stream().map(p -> p.line).distinct().count() - 1;

        if (option == 2)
        {
            double actualTime = totalCost - penalty * changes;
            System.out.println("Total travel time = " + actualTime + "minutes");
        }
        else
        {
            System.out.println("Total traveltime= " + totalCost + "minutes");
        }
        
        System.out.println("Number of line changes= " + Math.max(0, changes));
    }
}