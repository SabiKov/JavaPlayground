package exceptionhandling;

import java.net.Inet4Address;
import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

    public static void main(String[] args) {

        int[] someNumbers = {1, 2, 3, 4};
        int key = 0;

        process(someNumbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));
    }

    private static void process(
            int[] someNumber
            , int key
            , BiConsumer<Integer, Integer> biConsumer) {
        for(int i : someNumber) {
            biConsumer.accept(i, key);
        }
    }

    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biConsumer) {
        return (v, k) -> {
            try {
                biConsumer.accept(v, k);
            } catch(ArithmeticException e) {
                System.out.println("Exception caught in wrapper lambda");
            }
        };
    }
}
