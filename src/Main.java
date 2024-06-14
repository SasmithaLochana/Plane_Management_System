import java.util.Arrays;
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
        Object[] seatInfo = manage_seat();
        int[] seatsArray = (int[]) seatInfo[0];
        char row = (char) seatInfo[1];
        int seatNum = (int) seatInfo[2];

        if (seatsArray[seatNum] == 0) {
            seatsArray[seatNum] = 1;
            System.out.println("Your seats has been booked in row " + row + " and seat number " + (seatNum + 1));
        } else {
            System.out.println("Seat was already booked.");
        }
    }

    public static Object[] manage_seat() {
        System.out.println("Enter the seats row (A-D): ");
        Scanner scanner = new Scanner(System.in);
        char row = scanner.next().toUpperCase().charAt(0);
        System.out.println("Enter the seat number: ");
        int seatNum = scanner.nextInt() - 1;
        if (seatNum < 0 || seatNum >= 14) {
            System.out.println("Please enter a valid seat number and try again.");
        }
        int[] seatsArray = getSeatRow(row);
        if (seatsArray == null) {
            System.out.println("Invalid row. Please enter a row between A-D. ");
        }
        return new Object[]{seatsArray, row, seatNum};
    }


    public static int[] getSeatRow(char row) {
        return switch (row) {
            case 'A' -> seatsA;
            case 'B' -> seatsB;
            case 'C' -> seatsC;
            case 'D' -> seatsD;
            default -> null;

        };
    }


    public static void cancel_seat() {
        Object[] seatInfo = manage_seat();
        int[] seatsArray = (int[]) seatInfo[0];
        char row = (char) seatInfo[1];
        int seatNum = (int) seatInfo[2];

        if (seatsArray[seatNum] == 1) {
            seatsArray[seatNum] = 0;
            System.out.println("Your booking in row " + row + " and seat number " + (seatNum + 1) + " has been canceled.");
        } else {
            System.out.println("Seat was not booked.");
        }
    }


    public static void find_first_available() {
        for (char row = 'A'; row <= 'D'; row++) {
            int[] seatsArray = getSeatRow(row);
            if (seatsArray != null) {
                for (int i = 0; i < seatsArray.length; i++) {
                    if (seatsArray[i] == 0) {
                        System.out.println("First available seat is in row. " + row + ", seat number " + (i + 1));
                        break;
                    } else {
                        System.out.println("All the seats are booked.");
                    }
                }
            }
        }

    }

    public static void show_seating_plan() {
        System.out.println("Seating Plan");

        System.out.println("\nRow A: " + Arrays.toString(seatsA).replace("0", "O").
                replace("1", "X").replace("[", " ").replace("]", " ")
                .replace(", ", " "));

        System.out.println("Row B: " + Arrays.toString(seatsB).replace("0", "O").
                replace("1", "X").replace("[", " ").replace("]", " ")
                .replace(", ", " "));

        System.out.println("Row C: " + Arrays.toString(seatsC).replace("0", "O").
                replace("1", "X").replace("[", " ").replace("]", " ")
                .replace(", ", " "));

        System.out.println("Row B: " + Arrays.toString(seatsD).replace("0", "O").
                replace("1", "X").replace("[", " ").replace("]", " ")
                .replace(", ", " "));
    }

    public static void print_tickets_info() {

    }

    public static void search_Ticket() {

    }
}
