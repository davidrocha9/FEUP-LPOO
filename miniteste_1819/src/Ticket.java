import java.util.Objects;

public class Ticket {
    private int number;
    private Concert concert;
    public Ticket(int number, Concert concert) throws InvalidTicket {
        if (number > 0)
            this.number = number;
        else
            throw new InvalidTicket(number);
        this.concert = concert;
    }

    public int getNumber() {
        return number;
    }

    public Concert getConcert() {
        return concert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return number == ticket.number &&
                Objects.equals(concert, ticket.concert);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, concert);
    }
}
