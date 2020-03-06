import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {
    Monster(Position position) {
        this.position = position;
    }

    public Position move() {
        Random rand = new Random();
        switch (rand.nextInt(4)) {
            case 0:
                return new Position(position.getX(), position.getY() - 1);
            case 1:
                return new Position(position.getX() - 1, position.getY());
            case 2:
                return new Position(position.getX(), position.getY() + 1);
            case 3:
                return new Position(position.getX() + 1, position.getY());
        }
        return new Position(position.getX(), position.getY());
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(),position.getY()), "O");
    }
}
