package methodferences;

public class MethodReferenceExample {


    public static void main(String[] args) {

        //Thread t = new Thread(() -> printMessage());
        /*
        * MethodReferenceExample::printMessage === () -> printMessage()
        * */
        Thread t = new Thread(MethodReferenceExample::printMessage);
        t.start();
    }


    public static void printMessage() {
        System.out.println("Hello");
    }

}
