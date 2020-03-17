public class Line implements BasicShape {
    private double length;

    public Line(double length){
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    @Override
    public void draw() {
        System.out.println("Line");
    }
}
