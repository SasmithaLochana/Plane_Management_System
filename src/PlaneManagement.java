import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlaneManagement {

    static int[] seatsA = new int[14];
    static int[] seatsB = new int[12];
    static int[] seatsC = new int[12];
    static int[] seatsD = new int[14];
    static Ticket[] tickets = new Ticket[62];

    static double price1 = 200;
    static double price2 = 150;
    static double price3 = 180;

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
//        while (true) {
        try {
            Object[] seatInfo = manage_seat();
            int[] seatsArray = (int[]) seatInfo[0];
            char row = (char) seatInfo[1];
            int seatNum = (int) seatInfo[2];

            if (seatsArray[seatNum] == 0) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter your name: ");
                String name = scanner.nextLine();
                System.out.println("Enter your surname: ");
                String surname = scanner.nextLine();
                System.out.println("Enter your e-mail: ");
                String email = scanner.nextLine();
                Person person = new Person(name, surname, email);
                double price = getTicketPrice(seatNum);
                Ticket ticket = new Ticket(row, seatNum, price, person);
                for (int i = 0; i < tickets.length; i++) {
                    if (tickets[i] == null) {
                        tickets[i] = ticket;
                        break;
                    }
                }
                seatsArray[seatNum] = 1;
                System.out.println("Your seats has been booked in row " + row + " and seat number " + (seatNum + 1));
            } else {
                System.out.println("Seat was already booked.");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("PLease enter a valid input.");
        }
    }
//    }

    public static double getTicketPrice(int seat) {
        if (seat < 5) {
            return price1;
        } else if (seat < 9) {
            return price2;
        } else {
            return price3;
        }
    }

    public static Object[] manage_seat() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the seats row (A-D): ");
        char row = scanner.next().toUpperCase().charAt(0);
        int[] seatRow = getSeatRow(row);
        while (true) {
            System.out.println("Enter the seat number: ");
            int seatNum = scanner.nextInt() - 1;
            if (seatNum < 0 || seatNum >= 14) {
                System.out.println("Please enter a valid seat number and try again.");
                continue;
            }
            return new Object[]{seatRow, row, seatNum};
        }
    }

    public static int[] getSeatRow(char row) {
        return switch (row) {
            case 'A' -> seatsA;
            case 'B' -> seatsB;
            case 'C' -> seatsC;
            case 'D' -> seatsD;
            default -> throw new InputMismatchException();
        };
    }

    public static void cancel_seat() {
        while (true) {
            try {
                Object[] seatInfo = manage_seat();
                int[] seatsArray = (int[]) seatInfo[0];
                char row = (char) seatInfo[1];
                int seatNum = (int) seatInfo[2];

                if (seatsArray[seatNum] == 1) {
                    for (int i = 0; i < tickets.length; i++) {
                        if (tickets[i].getRow() == row && tickets[i].getSeat() == seatNum) {
                            tickets[i] = null;
                            break;
                        }
                    }
                    seatsArray[seatNum] = 0;
                    System.out.println("Your booking in row " + row + " and seat number " + (seatNum + 1) + " has been canceled.");
                    return;
                } else {
                    System.out.println("Seat was not booked.");
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    public static void find_first_available() {
        for (char row = 'A'; row <= 'D'; row++) {
            int[] seatsArray = getSeatRow(row);
            if (seatsArray != null) {
                for (int i = 0; i < seatsArray.length; i++) {
                    if (seatsArray[i] == 0) {
                        System.out.println("First available seat is in row. " + row + ", seat number " + (i + 1));
                        return;

                    }
                }
            }
        }
        System.out.println("All the seats are booked.");
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
        double totalPrice = 0;
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                System.out.println("Ticket Information");
                System.out.println("-------------------------------");
                System.out.println("Name: " + ticket.person.getName());
                System.out.println("Surname: " + ticket.person.getSurname());
                System.out.println("E-mail: " + ticket.person.getEmail());
                System.out.println("--------------------------------");
                System.out.println("Row: " + ticket.getRow() + " | Seat: " + ticket.getSeat() + " | Ticket Price: " + ticket.getPrice());
                System.out.println();
                totalPrice += ticket.getPrice();
            }
        }
        System.out.println("Total Tickets Price: " + totalPrice);
    }

    public static void search_Ticket() {
        Object[] seatInfo = manage_seat();
        int[] seatArray = (int[]) seatInfo[0];
        char row = (char) seatInfo[1];
        int seatNum = (int) seatInfo[2];

        if (seatArray[seatNum] == 1) {
            print_tickets_info();
        } else {
            System.out.println("The Seat is available");
        }
    }
}
