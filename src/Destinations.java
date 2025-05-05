import java.io.File;
import java.util.Scanner;

public class Destinations {
    private String FilePath;

    public Destinations(String filePath) {
        FilePath = filePath;
    }

    public void GetDestinations() {
        try{
        File file = new File(FilePath);
        Scanner sc = new Scanner(file);
        String destination1;
        String destination2;
        boolean checkDestination1True = false;
        boolean checkDestination2True = false;

        while (sc.hasNext()) {
            String[] values = sc.nextLine().split(",");
            String station = values[0].trim();
            System.out.println(values[0]);
        }
        } catch (Exception e) {
            System.out.println(e);
        }finally{

        }
    }
}
