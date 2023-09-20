import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address=null;

    public Person(String name, String surname, OptionalInt age, String address) {
        this.name=name;
        this.surname=surname;
        this.age=age;
        this.address=address;
    }

    public Person(String name, String surname) {
        this.name=name;
        this.surname=surname;
    }

    public Person(String name, String surname, OptionalInt age) {
        this.name=name;
        this.surname=surname;
        this.age=age;
    }

    public Person(String name, String surname, String address) {
        this.name=name;
        this.surname=surname;
        this.address=address;
    }


    public int happyBirthday() {
        int newAge=age.getAsInt();
        return newAge++;
    }

    public boolean hasAge() {
        return age != null;

    }

    public boolean hasAddress() {
        return address != null;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child=new PersonBuilder();
        child.setSurname(surname);
        if (hasAddress()) child.setAddress(address);
        return child;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address=address;
    }

    @Override
    public String toString() {
        if (!hasAge() && !hasAddress()) return " " + name + " " + surname;

        if (hasAge() && !hasAddress()) return " " + name + " " + surname +
                " " + age.getAsInt();

        if (!hasAge() && hasAddress()) return " " + name + " " + surname +
                " г.  " + address;

        return " " + name + " " + surname +
                " " + age.getAsInt() +
                " г. " + address;
    }
}