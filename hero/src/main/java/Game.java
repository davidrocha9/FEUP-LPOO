import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    private Screen screen = new TerminalScreen(terminal);
    Arena arena = new Arena(40, 15);
    public Game() throws IOException {
        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }
    public void run() throws IOException {
        while(true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                System.out.println(key);
            }
            else if (key.getKeyType() == KeyType.EOF){
                break;
            }
            if (this.arena.verifyMonsterCollisions()) {
                this.screen.close();
                System.out.println("Mission Failed, we'll get'em next time");
            }
            if (this.arena.getCoins().size() == 0) {
                this.screen.close();
                System.out.println("Mission Passed! Respect+");
            }
        }
    }
    private boolean processKey(KeyStroke key) {
        return arena.processKey(key);
    }
}
