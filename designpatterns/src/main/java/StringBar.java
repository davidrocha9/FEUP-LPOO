import java.util.ArrayList;

public class StringBar extends Bar {
    private boolean happyhour;

    public StringBar(){
        happyhour = false;
        observers = new ArrayList<>();
    }

    @Override
    public boolean isHappyHour() {
        return happyhour;
    }

    @Override
    public void startHappyHour() {
        happyhour = true;
        super.notifyObservers();
    }

    @Override
    public void endHappyHour() {
        happyhour = false;
        super.notifyObservers();
    }
}
