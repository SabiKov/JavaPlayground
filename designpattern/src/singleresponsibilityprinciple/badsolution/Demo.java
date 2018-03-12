package singleresponsibilityprinciple.badsolution;

import java.util.ArrayList;
import java.util.List;

interface MyLambda {
    void foo();
}

class Journal {

    private final List entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text) {
        entries.add("" + (++count) + ": " + text);
    }

    public void removeEntry(int index) {
        entries.remove(index);
    }

    MyLambda myLambda = () -> System.out.println("lambda");

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }
}

public class Demo {

    public static void main(String[] args) {
        Journal j = new Journal();
        j.addEntry("I cried today");
        j.addEntry("I ate a bug");
        System.out.println(j);

        MyLambda lambda = () -> System.out.println("lambda");
    }
}

