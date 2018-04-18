package solid.dip;

import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * A. High-level modules should not depend on low-level modules.
 * Both should depend on Abstractions.
 *
 * B. Abstraction should not depend on details.
 * Details should depend on abstraction.
 */

interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}

enum Relationship {
    PARENT,
    CHILD,
    SIBLING
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}
// low-level, has not got any business logic just a storage
class Relationships implements RelationshipBrowser {
    private List<Triplet<Person, Relationship, Person>> relations
            = new ArrayList<>();

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    public String getSome() {
        return "";
    }

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream()
                .filter(x -> Objects.equals(x.getValue0().name, name)
                        && x.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }
}
// High-level module because allows us to do some sort of operation on low-level module (Relationships
class Research {

    //should be in this class the filter function,
/*    public Research(Relationships relationships) {
        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
        relations.stream()
                .filter(x -> x.getValue0().name.equals("John")
                && x.getValue1() == Relationship.PARENT)
                .forEach(ch -> System.out.println(
                        "John has child called " + ch.getValue2().name
                ));
    }*/

    public Research(RelationshipBrowser browser) {
       List<Person> childer = browser.findAllChildrenOf("John");
       for(Person child : childer) {
           System.out.println("John has child called " + child.name);
       }
    }

}
public class DependencyInversionPrinciple {

    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);
    }
}
