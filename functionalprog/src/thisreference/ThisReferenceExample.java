package thisreference;

public class ThisReferenceExample {

    public void doProcess(int i, Process p) {
        p.process(i);
    }

    public void  execute() {
        // this === reference points to thisReferenceExample object, it is instance of that object
        doProcess(10, i -> {
            System.out.println("Value of u is " + i);
            System.out.println(this);
        });
    }

    public static void main(String[] args) {
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();

        //Java 7 classic way
        /*        thisReferenceExample.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println("Value of u is " + i);
                System.out.println(this); // this reference of new Process() anonymous inner class
            }

            public String toString() {
                return "This is the anonymous inner class";
            }
        });*/

        thisReferenceExample.doProcess(10, i -> {
            System.out.println("Value of u is " + i);
            //System.out.println(this); // this reference will not work

        });

        System.out.println("doExecute Method");
        thisReferenceExample.execute();
    }

    public String toString() {
        return "This is the main ThisReferenceExample class instance";
    }
}

interface Process {
    void process(int i);
}
