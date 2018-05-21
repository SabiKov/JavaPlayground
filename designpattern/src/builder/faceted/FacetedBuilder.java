package src.builder.faceted;

class Person {
    public String streetAddress, postcode, city;

    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("streetAddress='").append(streetAddress).append('\'');
        sb.append(", postecode='").append(postcode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", position='").append(position).append('\'');
        sb.append(", annualIncome=").append(annualIncome);
        sb.append('}');
        return sb.toString();
    }
}
// Using two different builder in
// tandem the builder facade need to be implemented
class PersonBuilder {
    protected Person person = new Person();

    public Person build() {
        return person;
    }

    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person);
    }

    public PersonJobBuilder works() {
        return new PersonJobBuilder(person);
    }
}
class PersonAddressBuilder extends PersonBuilder {

    public PersonAddressBuilder(Person person) {
        this.person = person;
    }

    public PersonAddressBuilder at(String streeAddress) {
        person.streetAddress = streeAddress;
        return this;
    }

    public PersonAddressBuilder in(String city) {
        person.city = city;
        return this;
    }


    public PersonAddressBuilder withPosteCode(String postecode) {
        person.postcode = postecode;
        return this;
    }
}
class PersonJobBuilder extends PersonBuilder {
    public PersonJobBuilder(Person person) {
        this.person = person;
    }

    public PersonJobBuilder at(String companyName) {
        person.companyName = companyName;
        return this;
    }

    public PersonJobBuilder asA(String position) {
        person.position = position;
        return this;
    }

    public PersonJobBuilder earning(int annualIncome) {
        person.annualIncome = annualIncome;
        return this;
    }
}
public class FacetedBuilder {
    public static void main(String[] args) {
       PersonBuilder pb = new PersonBuilder();
       Person person = pb
               .lives()
               .at("20 St. Steven street")
               .in("Budapest")
               .withPosteCode("1052")
           .works()
               .at("Fabrikam")
               .asA("Engineer")
               .earning(12345)
           .build();

        System.out.println(person);
    }
}
