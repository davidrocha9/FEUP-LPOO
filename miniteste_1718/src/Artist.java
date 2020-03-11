public class Artist extends Person {
    public Artist(String name) {
        super(name);
    }

    public Artist(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public int compareTo(Person person) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
