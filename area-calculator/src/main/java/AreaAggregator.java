import java.util.ArrayList;
import java.util.List;

public class AreaAggregator implements SumProvider{
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public double sum(){
        double res = 0.0;
        for (Shape shape: shapes){
            res += shape.getArea();
        }
        return res;
    }
}