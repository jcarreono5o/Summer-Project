
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Task1 {
    private static String[] args;
    public static void main(String[] args) throws FileNotFoundException
    {
        Task1.args = args;

        Scanner sc = new Scanner(System.in);

        String destination1;
        String destination2;
        boolean checkDestination1True = false;
        boolean checkDestination2True = false;
        File file = new File("X:\\Lancaster\\Year1Academic\\SCCx1A\\Summer_project\\summer_Project_2_39439453\\src\\Metrolink_times_linecolour.csv");
        //Scanner scan = new Scanner(file);

        {
do {
    Scanner scan = new Scanner(file);
    System.out.print("Enter current station: ");
    destination1 = sc.nextLine();
    System.out.print("Enter target station: ");
    destination2 = sc.nextLine();
    try {
        while (scan.hasNext()) {
            //print all line to test    System.out.println(scan.nextLine());
            String[] values = scan.nextLine().split(",");
            String station = values[0].trim();


            if (station.equals(destination1)) {
                checkDestination1True = true;
                System.out.println("Found from-station: " + station);
            }
            if (station.equals(destination2)) {
                checkDestination2True = true;
                System.out.println("Found to-station: " + station);
            }
            //System.out.println(values[0]);
        }
    } catch (Exception e) {
        System.out.println(e);
    } finally {
        scan.close();
    }
}
            while(checkDestination1True == false || checkDestination2True == false);

            if (checkDestination1True == true && checkDestination2True == true) {
                System.out.println("You are getting a train from " + destination1 + " to " + destination2);
                sc.close();
            }
        }
    }
}