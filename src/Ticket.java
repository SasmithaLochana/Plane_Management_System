
public class Ticket {

    private int row;
    private int seatNum;
    private double price;
    Person person;

    public Ticket(int row, int seat, double price, Person person) {
        this.row = row;
        this.seatNum = seat;
        this.price = price;
        this.person = person;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "row=" + row +
                ", seatNum=" + seatNum +
                ", price=" + price +
                ", person=" + person +
                '}';
    }
}

