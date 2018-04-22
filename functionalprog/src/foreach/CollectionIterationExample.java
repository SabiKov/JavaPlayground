package foreach;

import lambda_exercise.Vehicle;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {

    public static void main(String[] args) {
        List<Vehicle> vehicles = Arrays.asList(
                new Vehicle("Car", "Toyota", 2012),
                new Vehicle("Buggy", "Pamper", 2014),
                new Vehicle("Track", "Volvo", 2010),
                new Vehicle("Motorbike", "Honda", 2016),
                new Vehicle("Wheelbarrow", "Wang", 2009),
                new Vehicle("Scooter", "Piaggio", 2017),
                new Vehicle("Lorry", "Scania", 2018)
        );

        System.out.println("Using for loop");
        for(int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i));
        }

        System.out.println("Using for in loop");
        for(Vehicle v : vehicles) {
            System.out.println(v);
        }

        System.out.println("Using lambda foreach");
        vehicles.forEach(System.out::println);

    }
}
