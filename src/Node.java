import java.util.Comparator;

class Node implements Comparator<Node>
{
    public int node;
    public double cost;
    public String line;

    public Node(int node, int newDistance) {}

    public Node(int node, double cost, String line)
    {
        this.node = node;
        this.cost = cost;
        this.line = line;
    }

    //or
    public int compare(Node node1, Node node2)
    {
        if (node1.cost < node2.cost)
            return -1;
        if (node1.cost > node2.cost)
            return 1;

        return Integer.compare(node1.node, node2.node);
    }

}