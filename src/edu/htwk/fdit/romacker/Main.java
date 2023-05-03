package edu.htwk.fdit.romacker;

public class Main {
    public static void main(String[] args) {
/*      Task 1
        Fraction a = new Fraction(1, 4);
        Fraction b = new Fraction(2, 10);
        Fraction c = new Fraction(1, -3);

        // Basic arithmetic operations.

        System.out.println(a);
        System.out.println(b + ", " + b.reduce());
        Fraction d = Fraction.multiply(a, b.reciprocal());
        System.out.println(d + ", " + d.toMixedString());

        // Static methods.
        System.out.println(Fraction.add(a, b));

        // Most methods of Fraction allow for chaining:
        System.out.println(a.add(b).subtract(c).multiply(a).divide(b));
 */

        // Task 2
        SimpleLinkedList list = new SimpleLinkedList("a", "b", "c", "d");
        System.out.println(list + " | " + list.size());

        list.append("e");
        System.out.println(list + " | " + list.size());

        list.insert("f", 3);
        System.out.println(list + " | " + list.size());

        list.delete(2);
        System.out.println(list + " | " + list.size());

        System.out.println(list.findFirst("d"));
        System.out.println(list.get(3));
        System.out.println(list.last());

        SimpleLinkedList emptyList = new SimpleLinkedList();
        System.out.println(emptyList);
        emptyList.append(1);
        System.out.println(emptyList);
    }
}
