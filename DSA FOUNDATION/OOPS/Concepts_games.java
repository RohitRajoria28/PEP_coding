import java.util.*;

public class Main {

    public static class Person {

        // program adds default constructor
        Person() {
            this.age = 10;
            this.name = "pepcoder";
            System.out.println("object creation");
        }

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        void saysHi() {
            System.out.println(this.name + " [" + this.age + "] says hi ");
        }

        int age;
        String name;
    }

    public static void main(String[] args) {

        Person p1 = new Person();
        // p1.saysHi();
        // p1.age = 10;
        // p1.name = "rohit";

        Person p2 = new Person(20, "alex");
        // p2.age = 20;
        // p2.name = "alex";

        // p1.saysHi();
        p2.saysHi();
        // game8(p1,p2);
        // p1.saysHi();
        // p2.saysHi();

    }

    public static void game8(Person psn1, Person psn2) {
        psn2 = new Person();
        int age = psn1.age;
        Person tmp = psn1;
        psn1 = psn2;
        psn1.age = psn2.age;
        psn2.age = age;

        psn2 = tmp;
        String name = psn1.name;
        psn1.name = psn2.name;
        psn1 = psn2;
        psn2.name = name;
    }

    public static void game7(Person psn1, Person psn2) {
        int age = psn1.age;
        psn1 = new Person();
        psn1.age = psn2.age;
        psn2 = new Person();
        psn2.age = age;

        String name = psn1.name;
        psn1.name = psn2.name;
        psn2.name = name;
    }

    public static void game6(Person psn1, Person psn2) {
        int age = psn1.age;
        psn1 = new Person();
        psn1.age = psn2.age;
        psn2.age = age;

        psn2 = new Person();
        String name = psn1.name;
        psn1.name = psn2.name;
        psn2.name = name;
    }

    public static void game5(Person psn1, Person psn2) {
        psn1 = new Person();
        psn2 = new Person();

        int age = psn1.age;
        psn1.age = psn2.age;
        psn2.age = age;

        String name = psn1.name;
        psn1.name = psn2.name;
        psn2.name = name;
    }

    public static void game4(Person psn1, Person psn2) {
        psn1 = new Person();
        int age = psn1.age;
        psn1.age = psn2.age;
        psn2.age = age;

        psn2 = new Person();
        String name = psn1.name;
        psn1.name = psn2.name;
        psn2.name = name;
    }

    public static void game3(Person psn1, Person psn2) {
        psn1 = new Person();
        int age = psn1.age;
        psn1.age = psn2.age;
        psn2.age = age;

        String name = psn1.name;
        psn1.name = psn2.name;
        psn2.name = name;
    }

    public static void game2(Person psn1, Person psn2) {
        int age = psn1.age;
        psn1.age = psn2.age;
        psn2.age = age;

        String name = psn1.name;
        psn1.name = psn2.name;
        psn2.name = name;
    }

    public static void game1(Person psn1, Person psn2) {
        Person temp = psn1;
        psn1 = psn2;
        psn2 = temp;
    }
}