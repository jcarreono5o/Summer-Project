

import java.util.*;
// Dijkstra priority queue
public class Dijkstra {
    private int shortDistance[];
    private Set<Integer> settledNodes;
    private PriorityQueue<Node> pq;
    private int verticies;
    List<List<Node>> AdjacencyList;

    public Dijkstra(int Verticies)
    {
        this.verticies = Verticies;
        shortDistance = new int[Verticies];
        settledNodes = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(Verticies, new Node());
    }

    public void dijkstra(List<List<Node>>adjacencyList, int source)
    {
        //initialise adjacency list
        this.AdjacencyList = adjacencyList;
        //first/source node is 0 distance, put in queue
        for(int i = 0; i< verticies; i++)
        {
            //set all distances of node to infinite
            shortDistance[i] = Integer.MAX_VALUE;
        }
        pq.add(new Node(source,0));
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

    private void adjacentNodes(int u)
    {
        //set distances
        int edgeDistance = -1;
        int newDistance = -1;
        //get neighbours
        for (int i=0; i<AdjacencyList.get(u).size(); i++)
        {
            Node v = AdjacencyList.get(u).get(i);

            //check if settled
            if (!settledNodes.contains(v.node))
            {
                edgeDistance = v.cost;
                newDistance = shortDistance[u] + edgeDistance;

                //if new distance is less than old
                if (newDistance < shortDistance[v.node])
                    shortDistance[v.node] = newDistance;
                //add current node to queue
                pq.add(new Node(v.node, newDistance));
            }
        }
    }




    //for the custom sorting order
    //orders nodes for sorting
    //what is bigger is put further front of queue else equal


}

class Node implements Comparator<Node>
{
    public int node;
    public int cost;

    public Node() {}

    public Node(int node, int cost)
    {
        this.node = node;
        this.cost = cost;
    }

    //or
    public int compare(Node node1, Node node2)
    {
        if (node1.cost < node2.cost)
            return -1;
        if (node1.cost > node2.cost)
            return 1;

        return 0;
    }

}


