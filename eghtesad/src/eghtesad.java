import java.util.ArrayList;
public class eghtesad {
    class Car{
        Integer price;
        boolean owned;
    }
    public class streamAPI {
        ArrayList<Car> cars = new ArrayList<car>();
        Integer least_price = cars.stream()
                .filter(carexp -> carexp.owned)
                .mapToInt(carprice -> carprice.price)
                .min()
                .getAsInt();

    }
}

