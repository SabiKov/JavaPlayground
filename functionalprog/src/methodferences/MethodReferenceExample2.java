package methodferences;

import lambda_exercise.Vehicle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {


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

        Collections.sort(vehicles, (v1, v2) -> v1.getBrand().compareTo(v2.getBrand()));

        System.out.println("Print out all vehicles");
        //if the method signature's param needs
        // parameter the jvm knows and automatically adds to method::reference
        performConditonally(vehicles, v -> true, System.out::println);
    }

    private static void performConditonally(List<Vehicle> vehicles, Predicate<Vehicle> predicate, Consumer<Vehicle> consumer) {
        for(Vehicle v : vehicles) {
            if(predicate.test(v)) {
                consumer.accept(v);
            }
        }
    }
}

