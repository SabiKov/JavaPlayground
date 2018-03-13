package lambda_basic;

public class TypeInterferenceExample {

    public static void main(String[] args) {
        StringLengthLambda myLambda = (String s) -> s.length();
        StringLengthLambda myLambda1 = (s) -> s.length();
        StringLengthLambda myLambda2 = s -> s.length();

        System.out.println(myLambda.getLength("Hello Lambda Length"));
        System.out.println(myLambda1.getLength("Hello Lambda Length"));
        System.out.println(myLambda2.getLength("Hello Lambda Length"));
    }


    public static void printLambda(StringLengthLambda l) {
        System.out.println(l.getLength(("Hello Lambda")));
    }

    interface StringLengthLambda {
        int getLength(String s );
    }


}

