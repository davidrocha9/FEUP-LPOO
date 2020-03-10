import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract public class Act {
    protected String name, country;
    protected List<Artist> artists = new ArrayList<>();
    public Act(String name, String country){
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void addArtist(Artist artist){
        artists.add(artist);
    }

    public List<Artist> getArtists(){
        return artists;
    }

    public boolean containsArtist(Artist artist){
        for (Artist x: artists){
            if (x.getCountry() == artist.getCountry())
                if (x.getName() == artist.getName())
                    if (x.getArtists().size() == artist.getArtists().size())
                        return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Act act = (Act) o;
        return Objects.equals(name, act.name) &&
                Objects.equals(country, act.country) &&
                Objects.equals(artists, act.artists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, artists);
    }
}
