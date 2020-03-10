import java.util.*;

public class Concert {
    private String city, country, date;
    private List<Act> acts = new ArrayList<>();

    public Concert(String city, String country, String date) {
        this.city = city;
        this.country = country;
        this.date = date;
    }

    public List<Act> getActs() {
        return acts;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDate() {
        return date;
    }

    public void addAct(Act act) {
        acts.add(act);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Objects.equals(city, concert.city) &&
                Objects.equals(country, concert.country) &&
                Objects.equals(date, concert.date) &&
                Objects.equals(acts, concert.acts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, date, acts);
    }

    public boolean isValid(Ticket ticket) {
        if (ticket.getConcert().getCity() == city){
            if (ticket.getConcert().getCountry() == country){
                if (ticket.getConcert().getDate() == date)
                    return true;
            }
        }
        return false;
    }

    public boolean participates(Artist artist) {
        for (Act x: acts){
            if (x.getArtists().isEmpty()) {
                if (x.getName() == artist.getName())
                    if (x.getCountry() == artist.getCountry())
                        return true;
            }
            else{
                for (Artist y: x.getArtists()){
                    if (y.getName() == artist.getName())
                        if (y.getCountry() == artist.getCountry())
                            if (y.getArtists().size() == artist.getArtists().size())
                                return true;
                }
            }
        }
        return false;
    }
}
