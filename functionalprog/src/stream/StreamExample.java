package stream;

import lambda_exercise.Vehicle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

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

        vehicles.stream()
                .filter(v -> v.getBrand().startsWith("P"))
                .forEach(v -> System.out.println(v.getBrand()));


        long count = vehicles.stream()
                .filter(v -> v.getBrand().startsWith("P"))
                .count();
        System.out.println(count);

    }
}
