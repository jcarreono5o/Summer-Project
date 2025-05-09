import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Route {
    private String destinationBase;
    private String destinationAdjacent;
    private String distance;
    private String file;

    public Route(String destinationBase, String destinationAdjacent, String distance, String file)
    {
        this.destinationBase = destinationBase;
        this.destinationAdjacent = destinationAdjacent;
        this.distance = distance;
        this.file = file;
    }

    public void RouteFind() {
    }

}

