import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();

        Square square1 = new Square(1);
        Circle circle1 = new Circle(1);
        Ellipse ellipse1 = new Ellipse(1, 1);
        Rectangle rectangle1 = new Rectangle(1 , 2);
        Triangle triangle1 = new Triangle(2, 1);

        aggregator.addShape(square1);
        aggregator.addShape(circle1);
        aggregator.addShape(ellipse1);
        aggregator.addShape(rectangle1);
        aggregator.addShape(triangle1);

        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        AreaXMLOutputter  xmlOutputter = new AreaXMLOutputter(aggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());

        List<House> houses = new ArrayList<>();
        houses.add(new House(50));
        houses.add(new House(150));

        City city = new City(houses);

        AreaStringOutputter cityStringOutputter = new AreaStringOutputter(city);
        AreaXMLOutputter cityXmlOutputter = new AreaXMLOutputter(city);

        System.out.println(cityStringOutputter.output());
        System.out.println(cityXmlOutputter.output());
    }
}
