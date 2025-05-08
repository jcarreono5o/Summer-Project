import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

//IMPORTANT: CHANGE FILE PATHNAME BEFORE LAB DEMONSTRATION

public class WalkFileReader {
    public static void main(String[] args) throws FileNotFoundException
    {
        String line = "";
        File file = new File("X:\\Lancaster\\Year1Academic\\SCCx1A\\Summer_project\\summer_Project_2_39439453\\src\\Metrolink_times_linecolour.csv");
        Scanner scan = new Scanner(file);

        while(scan.hasNext())
        {
        //print all line to test    System.out.println(scan.nextLine());
            String[] values = scan.nextLine().split("\n");
            System.out.println(values[0]);
        }
    }
}
