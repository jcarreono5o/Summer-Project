import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String destination1;
        String destination2;

        System.out.print("Enter current station: ");
        destination1 = sc.nextLine();
        System.out.print("Enter target station: ");
        destination2 = sc.nextLine();



        System.out.println("You are getting a train from " + destination1 + " to " + destination2);
        sc.close();
    }
}