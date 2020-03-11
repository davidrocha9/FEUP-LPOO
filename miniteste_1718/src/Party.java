import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Party extends Event{
    private String name, date, description;
    private List<Person> people = new ArrayList<Person>();
    private List<Event> events = new ArrayList<Event>();

    public Party(String name, String date, String description) {
        super(name, date, description);
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public int getAudienceCount() {
        return people.size();
    }

    public void addEvent(Event e) {
        List<Person> list = e.getPeople();
        people.addAll(list);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Party party = (Party) o;
        return Objects.equals(name, party.name) &&
                Objects.equals(date, party.date) &&
                Objects.equals(description, party.description) &&
                Objects.equals(people, party.people) &&
                Objects.equals(events, party.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, date, description, people, events);
    }
}
