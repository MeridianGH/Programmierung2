package uebung1;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Hans", "T", 25);

        System.out.println(person.getName());
        System.out.println(person.getSurname());
        person.setSurname("Karl");
        System.out.println(person.getName());
        System.out.println(person.getSurname());
        System.out.println(person);
    }
}
