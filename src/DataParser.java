import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataParser {
    private String file;
    private String delimiter = ",";
    private String line;
    private List<String[]> result = new ArrayList<>();

    // Constructor that only takes the file path as input
    public DataParser(String file) {
        this.file = file;
    }

    // Parse the entire file and return a List of all routes
    public List<String[]> parseAllLines() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(delimiter);
                result.add(values);  // Add each line (as a string array) to the result list
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return result;
    }

    // This method could also be used if you want to search for specific stations
    // For now, it just returns everything as an array of string arrays (one for each line)
}