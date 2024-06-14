public class Ticket {

    private char row;
    private int seat;
    private int price;
    Person person;

    public Ticket (char row, int seat, int price,Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public char getRow(){
        return row;
    }

    public void setRow(){
        this.row = row;
    }

    public int getSeat(){
        return seat;
    }

    public void printInfo(){
        System.out.println("Ticket Info");
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: " + price);
        person.printInfo();
    }

}
