import org.w3c.dom.Node;

import java.util.*;
// Dijkstra priority queue
public class Dijkstra {
    private int ShortDistance[];
    private Set<Integer> settledNodes;
    private PriorityQueue<Node> pq;
    private int Verticies;
    List<List<Node>> AdjacencyList;

    public Dijkstra(int Verticies) {
        this.Verticies = Verticies;
        ShortDistance = new int[Verticies];
        settledNodes = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(Verticies, new Node());
    }

    public void dijkstra(List<List<Node>>adjacencyList, int source)
    {
        //initialise adjacency list
        //set all distances of node to infinite
        //first/source node is 0 distance, put in queue
        //check empty queue
        //remove min node from queue
        //add node with finished distance




    }

    private void adjacentNodes()
    {
        //set distances
        //get neighbours
        //check if settled
        //if new distance is less than old
        //add current node to queue
    }

    //for the custom sorting order
    //orders nodes for sorting
    //what is bigger is put further front of queue else equal
    class Node implements Comparator<Node> {
        public int node;
        public int cost;

        public Node() {
        }

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

     //or
        public int compare(Node node1, Node node2) {
            if (node1.cost < node2.cost)
                return -1;
            if (node1.cost > node2.cost)
                return 1;

            return 0;
        }

    }
}


