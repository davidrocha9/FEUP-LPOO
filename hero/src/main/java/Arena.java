import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width, height;
    Hero hero = new Hero(new Position(5,5), 100);
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    public Arena(int width, int height){
        this.width = width;
        this.walls = createWalls();
        this.height = height;
        this.coins = createCoins(hero.getPosition());
        this.monsters = createMonsters();
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            monsters.add(new Monster(new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1)));
        }
        return monsters;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins(Position position) {
        Random random = new Random();
        boolean pass = false;
        Position pos;
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            while(!pass) {
                pos = new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
                if (pos.getX() == position.getX() && pos.getY() == position.getY())
                    pass = false;
                else {
                    pass = true;
                    coins.add(new Coin(pos));
                }
            }
            pass = false;
        }
        return coins;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#0000FF"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
        for (Monster monster: monsters)
            monster.draw(graphics);
    }

    public boolean processKey(KeyStroke key) {
        switch(key.getKeyType()){
            case ArrowUp:
                return update(hero.moveUp());
            case ArrowDown:
                return update(hero.moveDown());
            case ArrowRight:
                return update(hero.moveRight());
            case ArrowLeft:
                return update(hero.moveLeft());
            default:
                return true;
        }
    }

    private boolean update(Position position) {
        moveHero(position);
        retrieveCoins(position);
        moveMonsters();
        return true;
    }

    public boolean verifyMonsterCollisions() {
        for (Monster monster: monsters){
            if (monster.getPosition().equals(hero.getPosition()))
                return true;
        }
        return false;
    }

    private void moveMonsters() {
        for (Monster monster: monsters){
            Position pos = monster.move();
            if (canMonsterMove(pos))
                monster.setPosition(pos);
        }
    }

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    private boolean canHeroMove(Position position) {
        for (Wall wall: walls) {
            if(wall.getPosition().equals(position))
                return false;
        }
        return true;
    }

    private boolean canMonsterMove(Position position) {
        for (Wall wall: walls) {
            if(wall.getPosition().equals(position))
                return false;
        }
        for (Coin coin: coins) {
            if(coin.getPosition().equals(position))
                return false;
        }
        return true;
    }

    private void retrieveCoins(Position position) {
        Coin c1 = null;
        for (Coin coin: coins){
            if(coin.getPosition().equals(position)) {
                c1 = coin;
                break;
            }
        }
        if (c1 != null)
            coins.remove(c1);
    }

    public List<Coin> getCoins() {
        return coins;
    }
}
