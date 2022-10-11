package web.dao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;

// Слой DAO отвечает за взаимодействие с БД/создаём список
// ТЗ: создайте список из 5 машин (используем блок инициализации)

@Repository
public class CarDaoImpl implements CarDao {
    List<Car> cars;
    {
        cars = new ArrayList<>(5);

        cars.add(new Car("car1", 1, "red"));
        cars.add(new Car("car2", 2, "orange"));
        cars.add(new Car("car3", 3, "yellow"));
        cars.add(new Car("car4", 4, "green"));
        cars.add(new Car("car5", 5, "blue"));
    }

    @Override
    public List<Car> getCars(int count) {
        return count < 5 ? cars.stream().limit(count).toList() : cars;
    }
}