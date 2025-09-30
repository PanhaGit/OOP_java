package OOP;

public class super_class {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;

        // Create objects
        A _a = new A(a);
        C _c = new C(a, b, c);

        // Display values
        _a.display();  // Output: A: 10
        _c.display();  // Output: A: 10, B: 20, C: 30
    }
}

// Parent class
class A {
    int a;

    A(int a) {
        this.a = a;
    }

    void display() {
        System.out.println("A: " + a);
    }
}

// Child class of A
class B extends A {
    int b;

    B(int a, int b) {
        super(a);   // Calls A's constructor
        this.b = b;
    }

    @Override
    void display() {
        super.display();   // Calls A's display method
        System.out.println("B: " + b);
    }
}

// Child class of B
class C extends B {
    int c;

    C(int a, int b, int c) {
        super(a, b);   // Calls B's constructor
        this.c = c;
    }

    @Override
    void display() {
        super.display();  // Calls B's display method
        System.out.println("C: " + c);
    }
}
