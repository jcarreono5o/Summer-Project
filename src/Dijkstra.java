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

    public void dijkstra() {

    }

    private void adjacentNodes() {

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


