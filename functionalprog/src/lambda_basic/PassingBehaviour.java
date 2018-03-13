package lambda_basic;

public class PassingBehaviour {

    //old way
    public void behaviour() {
        System.out.println("Hello Behaviour OOP concept way");
    }

    // java 7 way
    public void behaviour(Passing passing) {
        passing.perform();
    }

    /**
     * Lambda creates some sort of expression such as
     * public void behaviour(action) {
     *     action();
     * }
     * but not exactly...
     */
    public static void main(String[] args) {
        System.out.println("Hello Lambda");

        PassingBehaviour passingBehaviour = new PassingBehaviour();
        passingBehaviour.behaviour();

        Passing helloPassingBehaviourImp = new HelloPassingBehaviourImp();
        passingBehaviour.behaviour(helloPassingBehaviourImp);

    /**
     * behaviourFunction = () -> System.out.println("Hello World");
     *
     * NOT a lambda expression
     * doubleNumberFunction = public int double(int a) {
     *     return a * 2;
     * }
     * //Convert it to Lambda expression
     * doubleNumberFunction = (int a) -> a * 2;
     *
     * addFunction = (int a, int b) -> a + b;
     *
     * safeDivideFunction = (int a, int b) -> {
     *      if(b == 0) return 0;
     *      return a / b
     * };
     *
     * stringLengthCountFunction = (String s) -> s.length();
     */

        // in order to run this need to create interface
        MyLambda myLambdaFunction = () -> System.out.println("Hello World in Lambda globe");

        MyLambdaAddFunction addFunction = (int a ,int b) -> a + b;

        Passing myLambdaPassingInterface = ()
                -> System.out.println("First Lambda Implementation");


        myLambdaPassingInterface.perform();

        //inner anonymous class
        Passing innerClassGreeting = new Passing() {
            @Override
            public void perform() {
                System.out.println("Hello inner anonymous class");
            }
        };

        System.out.println("***********************");
        passingBehaviour.behaviour(myLambdaPassingInterface);
        passingBehaviour.behaviour(innerClassGreeting);


    }
}
@FunctionalInterface
interface MyLambda {
    void foo();
}

@FunctionalInterface
interface MyLambdaAddFunction {
    int add(int x, int y);
}