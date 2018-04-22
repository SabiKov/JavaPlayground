package solid.isp;

class Document {

}

/* Many interfaces far better than one fat interface
* because the class will be forced to implement all
* method of that interface even if that object
* cannot have that feature. If there are many interfaces,
* only relevant interface */
/*interface Machine {
    void print(Document d);
    void fax(Document d);
    void scan(Document d);
}*/

interface Printer {
    void print(Document d);
}
interface Fax {
    void fax(Document d);
}
interface Scanner {
    void scan(Document d);
}
/*
class MultiFunctionPrinter implements Machine {
    @Override
    public void print(Document d) { }
    @Override
    public void fax(Document d) { }
    @Override
    public void scan(Document d) { }
}*/
class JustAPrinter implements Printer {

    @Override
    public void print(Document d) {

    }
}

//YAGNI = You A'int Going to Need It -- only need relevant method!!
class Photocopier implements  Printer, Scanner {

    @Override
    public void print(Document d) { }

    @Override
    public void scan(Document d) { }

}
/* Also can have an interface which
* gathers few of them interfaces
* based on functionality e.g MultiFunctionDevice
*/
interface MultifunctionDevice extends Printer, Scanner {}

class MultifunctionMachine implements MultifunctionDevice {

    private Printer printer;
    private Scanner scanner;

    public MultifunctionMachine(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void print(Document d) {
        printer.print(d);
    }

    @Override
    public void scan(Document d) {
        scanner.scan(d);
    }
}



public class InterfaceSegregationPrinciple {
}
