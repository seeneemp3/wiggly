package practice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SortedCars {
    public static class Car{
        private LocalDate date;

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public Car(LocalDate date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "date=" + date +
                    '}';
        }
    }

    public static void main(String[] args) {
        Car c1 = new Car(LocalDate.of(1998,12,1));
        Car c2 = new Car(LocalDate.of(1981,12,1));
        Car c3 = new Car(LocalDate.of(2003,12,1));

        List <Car> carList = new ArrayList<>();
        carList.add(c1);
        carList.add(c2);
        carList.add(c3);

        Optional<Car> maxcar = carList.stream()
                .max(Comparator.comparing(Car::getDate));

        System.out.println(maxcar);
    }
}
