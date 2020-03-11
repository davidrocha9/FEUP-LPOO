import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class Attendee extends Person {
    private boolean paid;
    public Attendee(String name) {
        super(name);
    }

    public Attendee(String name, int age) {
        super(name, age);
        this.paid = false;
    }

    public boolean hasPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return "Attendee " + super.getName() + (this.paid ? " has" : " hasn't") + " paid its registration.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Attendee attendee = (Attendee) o;
        return paid == attendee.paid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), paid);
    }

    @Override
    public int compareTo(Person person) {
        return 0;
    }
}
