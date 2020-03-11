import java.util.ArrayList;
import java.util.List;

public class BoxOffice {
    static int ticketnr = 0;

    public static List<Ticket> buy(Concert concert, int nrs) throws InvalidTicket {
        List<Ticket> tickets = new ArrayList<Ticket>();
        int x;
        for (x = 1; x <= nrs; x++){
            tickets.add(new Ticket(ticketnr + x, concert));
        }
        ticketnr = nrs;
        return tickets;
    }
}
