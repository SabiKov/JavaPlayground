package lambda_exercise;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaPractise {


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
        System.out.println("0: Java " + vehicles);

        //Step 1: Sort list by type
        //Java 7
/*        Collections.sort(vehicles, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.getType().compareTo(o2.getType());
            }
        });
        System.out.println("1: Java7" + vehicles);

        */
        //Java 8 Lambda
        Collections.sort(vehicles, (vehicle1, vehicle2) -> vehicle1.getType().compareTo(vehicle2.getType()));

        //Step 2: Create a method that prints all elements in the list
        vehicles.forEach(vehicle -> System.out.println("2: Java8" + vehicle));

        //Step 3: Create a method that prints all people that have last name beginning with P
        //Java 7
   /*     printConditionally(vehicles, new Condition() {

            @Override
            public boolean test(Vehicle p) {
                return p.getBrand().startsWith("T");
            }
        });
*/

        //Java 8
        System.out.println("Print all vehicle");
        printConditionally(vehicles, v -> true);


        System.out.println("Print conditionally vehicle");
        printConditionally(vehicles, v -> v.getBrand().startsWith("T"));
    }

    private static void printConditionally(List<Vehicle> vehicles, Condition condition) {
        for(Vehicle v : vehicles) {
            if(condition.test(v)) {
                System.out.println(v);
            }
        }
    }

}
interface Condition {
    boolean test(Vehicle p);
}
