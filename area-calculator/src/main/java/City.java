import java.util.List;

public class City implements SumProvider{
    List<House> houses;

    public City(List<House> houses){
        this.houses = houses;
    }

    public List<House> getHouses() {
        return houses;
    }
    public double sum(){
        double res = 0.0;
        for (House houses: houses)
            res += houses.getArea();
        return res;
    }
}
