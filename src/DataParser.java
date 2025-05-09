import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataParser {
    private final String file;
    private final String delimiter = ",";

    public DataParser(String file)
    {
        this.file = file;
    }

    public List<String[]> parseAllLines()
    {
        List<String[]> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            boolean skimTopFile = false;
            while ((line = reader.readLine()) != null)
            {
                if (!skimTopFile)
                {
                    skimTopFile = true;
                    continue;
                }
                String[] values = line.split(delimiter);
                if (values.length < 4) continue;//perhaps add constant for lab file
                result.add(values);
            }
        } catch (IOException e)
        {
            System.err.println("ERROR, CHECK LAB FILE IS CORRECT: " + e.getMessage());
        }
        return result;
    }
}