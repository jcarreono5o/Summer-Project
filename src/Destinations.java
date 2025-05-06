import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Destinations {
    private String FilePath;

    public Destinations(String filePath) {
        FilePath = filePath;
    }

    public String[] GetDestinations() {

        File file = new File(FilePath);

        Scanner sc;
        //try statement, makes sure scanner does not cause get runtime error if no file
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String destination1;
        String destination2;
        boolean checkDestination1True = false;
        boolean checkDestination2True = false;

        do {

            System.out.print("Enter current station: ");
            destination1 = sc.nextLine();
            System.out.print("Enter target station: ");
            destination2 = sc.nextLine();
            try {
                while (sc.hasNext()) {
                    String[] values = sc.nextLine().split(",");
                    String station = values[0].trim();
                    System.out.println(values[0]);

                    if (station.equals(destination1)) {
                        checkDestination1True = true;
                        System.out.println("Destination 1: " + station);
                    }
                    if (station.equals(destination2)) {
                        checkDestination2True = true;
                        System.out.println("Destination 2: " + station);
                    }

                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                sc.close();
            }
        }
        while (!checkDestination1True || !checkDestination2True);

        if (checkDestination1True && checkDestination2True)
        {
            System.out.println("You are getting a train from " + destination1 + " to " + destination2);
            return new String[]{destination1, destination2};
        }
        return null;
    }

    }