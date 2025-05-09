public class Node implements Comparable<Node> {
    public int node;
    public double cost;
    public String line;

    public Node(int node, double cost, String line) {
        this.node = node;
        this.cost = cost;
        this.line = line;
    }

    public int compareTo(Node other) {
        return Double.compare(this.cost, other.cost);
    }
}
