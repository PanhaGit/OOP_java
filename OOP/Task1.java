package OOP;

class Animal {
    String name;

    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

public class Task1 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "Buddy";
        dog.eat();
        dog.bark();
        System.out.println("Dog name is: " + dog.name);
    }
}
