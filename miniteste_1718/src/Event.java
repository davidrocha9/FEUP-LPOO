import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Event {
    private String title, date, description;
    private List<Person> people = new ArrayList<Person>();

    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
        this.description = "";
    }

    public Event(String title) {
        this.title = title;
        this.date = "";
        this.description = "";
    }

    public Event(Event e) {
        this.title = e.getTitle();
        this.date = e.getDate();
        this.description = e.getDescription();
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.title + " is a " + this.description + " and will be held at " + this.date + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) &&
                Objects.equals(date, event.date) &&
                Objects.equals(description, event.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date, description);
    }

    public void addPerson(Person person) {
        for (Person x: people){
            if(x.getName() == person.getName())
                return;
        }
        people.add(person);
    }

    public int getAudienceCount() {
        return people.size();
    }

    protected List<Person> getPeople() {
        return people;
    }
}
