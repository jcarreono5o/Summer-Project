import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Destinations {
    private String FilePath;

    public Destinations(String filePath)
    {
        FilePath = filePath;
    }

    public String[] GetDestinations()
    {

        Scanner scanInput = new Scanner(System.in);

        String destination1;
        String destination2;
        int lineCount = -1;
        boolean checkDestination1True;
        boolean checkDestination2True;
        do {
            checkDestination1True = false;
            checkDestination2True = false;

            System.out.print("Enter current station: ");
            destination1 = scanInput.nextLine();
            System.out.print("Enter target station: ");
            destination2 = scanInput.nextLine();

            File file = new File(FilePath);
            try (Scanner scanFile = new Scanner(file)) {
                while (scanFile.hasNext()) {
                    String[] values = scanFile.nextLine().split(",");
                    String station = values[0].trim();
                    lineCount += 1;

                    if (station.equals(destination1))
                    {
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
            }
        }
        while (!checkDestination1True || !checkDestination2True);

        System.out.println("You are getting a train from " + destination1 + " to " + destination2);
        System.out.println(lineCount);
        return new String[]{destination1, destination2, Integer.toString(lineCount)};
    }

    }