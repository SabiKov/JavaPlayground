package closures;

public class ClosuresExmaple {

    public static void main(String[] args) {
        int a  = 10;
        int b  = 20; // do not have to declare as final, but this variable is final!
        doProcess(a, i -> System.out.println(i + b));


    }

    public static void doProcess(int i, Process p) {
        p.process(i);
    }
}

interface Process {
    void process(int i);
}
