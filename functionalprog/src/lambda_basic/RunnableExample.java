package lambda_basic;

public class RunnableExample {

    public static void main(String[] args) {
        Thread mythread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("xPrinted inside Runnable");
            }
        });

        mythread.run();

        Thread myLambdaThread = new Thread(() -> System.out.println("Printed Lambda Runnable"));
        myLambdaThread.run();
    }
}
