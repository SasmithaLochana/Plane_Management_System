import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static int[] seatsA = new int[14];
    static int[] seatsB = new int[12];
    static int[] seatsC = new int[12];
    static int[] seatsD = new int[14];

    public static void main(String[] args) {

        System.out.println("Welcome to the Plane Management application.");

        while (true) {
            System.out.println("""
                    \n******************************
                    *        MENU OPTIONS        *
                    ******************************
                    \s
                    1) Buy a Seat
                    2) Cancel a ticket
                    3) Find first available seat
                    4) Show seating plan
                    5) Print tickets information and total sales
                    6) Search ticket
                    0) Quit
                    ******************************
                    \s
                    Please select an option:\s""");
            try {
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        buy_Seat();
                        break;

                    case 2:
                        cancel_seat();
                        break;

                    case 3:
                        find_first_available();
                        break;

                    case 4:
                        show_seating_plan();
                        break;

                    case 5:
                        print_tickets_info();
                        break;

                    case 6:
                        search_Ticket();
                        break;

                    case 0: {
                        System.out.println("Exiting from plane manager. Goodbye, Have a Nice Day! 👋");
                        System.exit(0);
                    }

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    public static void buy_Seat() {
        System.out.println("Enter the seats row (A-D): ");
        Scanner scanner = new Scanner(System.in);
        char row = scanner.next().toUpperCase().charAt(0);
        System.out.println("Enter the seat number: ");
        int seatNum = scanner.nextInt();

        switch (row) {
            case 'A':
                if (seatsA[seatNum] == 0) {
                    seatsA[seatNum] = 1;
                    System.out.println("Your Seat has been booked in row " + (row) + " and seat number " + seatNum);
                } else {
                    System.out.println("Seat was already booked.");
                } break;

            case 'B':
                if (seatsB[seatNum] == 0) {
                    seatsB[seatNum] = 1;
                    System.out.println("Your Seat has been booked in row " + (row) + " and seat number " + seatNum);
                } else {
                    System.out.println("Seat was already booked.");
                } break;

            case 'C':
                if (seatsC[seatNum] == 0) {
                    seatsC[seatNum] = 1;
                    System.out.println("Your Seat has been booked in row " + (row) + " and seat number " + seatNum);
                } else {
                    System.out.println("Seat was already booked.");
                } break;

            case 'D':
                if (seatsD[seatNum] == 0) {
                    seatsD[seatNum] = 1;
                    System.out.println("Your Seat has been booked in row " + (row) + " and seat number " + seatNum);
                } else {
                    System.out.println("Seat was already booked.");
                } break;
        }
    }

    public static void cancel_seat() {
        System.out.println("Enter the seat row (A-D)");
        Scanner scanner = new Scanner(System.in);



    }

    public static void find_first_available() {
    }

    public static void print_tickets_info() {
    }

    public static void show_seating_plan() {
    }

    public static void search_Ticket() {
    }
}
