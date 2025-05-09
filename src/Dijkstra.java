

import java.util.*;
// Dijkstra priority queue

public class Dijkstra {
    private int shortDistance[];
    private Set<Integer> settledNodes;
    private PriorityQueue<Node> pq;
    private int verticies;
    List<List<Node>> AdjacencyList;
    private List<List<Node>> adj;
    private double changePenalty = 2;

    public Dijkstra(List<List<Node>> adj)
    {
        this.adj = adj;
        settledNodes = new HashSet<Integer>();
    }

    public Dijkstra(List<List<Node>> adj, double changePenalty) {
        this.adj = adj;
        this.changePenalty = changePenalty;
    }

    /*public void dijkstra(List<List<Node>>adjacencyList, int source)
    {
        //initialise adjacency list
        this.AdjacencyList = adjacencyList;
        //first/source node is 0 distance, put in queue
        for(int i = 0; i< verticies; i++)
        {
            //set all distances of node to infinite
            shortDistance[i] = Integer.MAX_VALUE;
        }
        shortDistance[source] = 0;

        while(settledNodes.size() != verticies)
        {
            if (pq.isEmpty())
            {
                return;
            }
            //check empty queue

            int u = pq.remove().node;
            //remove min node from queue

            if (settledNodes.contains(u))
            {
                continue;
            }

            //add node with finished distance
            settledNodes.add(u);

            adjacentNodes(u);
        }


    }

    public void adjacentNodes(int u)
    {
        //set distances
        int edgeDistance = -1;
        int newDistance = -1;
        //get neighbours
        for (int i=0; i<AdjacencyList.get(u).size(); i++)
        {
            Node v = AdjacencyList.get(u).get(i);

        }
    }*/

    public List<Node> findPath(int src, int dst) {
        int Verticies = adj.size();
        Map<Integer, Map<String, Double>> dist = new HashMap<>();
        for (int index = 0; index < Verticies; index++) {
            dist.put(index, new HashMap<>());
        }
        Map<Lines, Lines> parent = new HashMap<>();
        //for lines class, see previous
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0, ""));
        dist.get(src).put("", 0.0); //must be double xlear
        Lines bestStation = null;
        //for backtracking to shortest path

        while (!pq.isEmpty())
        {
            Node current = pq.remove();
            if (current.node == dst) {
                bestStation = new Lines(current.node, current.line);
                break;
            }
            double currentlyOptimal = dist.get(current.node).get(current.line);
            if (current.cost > currentlyOptimal) continue;

            for (Node edge : adj.get(current.node)) {
                double penalty = (current.line.isEmpty() || edge.line.equals(current.line)) ? 0.0 : changePenalty;
                double newCost = current.cost + edge.cost + penalty;

                Map<String, Double> m = dist.get(edge.node);
                double prev = m.getOrDefault(edge.line, Double.POSITIVE_INFINITY);
                if (newCost < prev) {
                    m.put(edge.line, newCost);
                    parent.put(new Lines(edge.node, edge.line), new Lines(current.node, current.line));
                    pq.add(new Node(edge.node, newCost, edge.line));
                }
            }
        }

        if (bestStation == null) return Collections.emptyList();
        LinkedList<Node> path = new LinkedList<>();
        Lines currentStationLine = bestStation;
        while (!(currentStationLine.station == src && currentStationLine.line.isEmpty())) {
            double c = dist.get(currentStationLine.station).get(currentStationLine.line);
            path.addFirst(new Node(currentStationLine.station, c, currentStationLine.line));
            currentStationLine = parent.get(currentStationLine);
        }
        path.addFirst(new Node(src, 0.0, ""));
        return path;
    }
}


