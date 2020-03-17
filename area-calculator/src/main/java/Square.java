public class Square implements Shape {
    double side;

    public Square(double side) {
        super();
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.pow(side, 2);
    }

    public double getSide() {
        return side;
    }

    @Override
    public void draw() {
        System.out.println("Square");
    }
}
