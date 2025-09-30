package OOP;

class Person {
    protected int age;
    private String name;

    int getAge() {
        return age;
    }

    String getName() {
        return name;
    }

    int setAge(int age) {
        return this.age = age;
    }

    String setName(String name) {
        return this.name = name;
    }

    void printerTitle() {
        System.out.println("Hello From Class Person");
    }
}

class Car extends Person {
    int yearCar;
    double carPrice;

    public int getYearCar() {
        return yearCar;
    }

    public void setYearCar(int yearCar) {
        this.yearCar = yearCar;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    @Override
    String getName() {
        return super.getName();
    }

    @Override
    String setName(String name) {
        return super.setName(name);
    }

    @Override
    void printerTitle() {
        super.printerTitle();
        System.out.println("Hello From Car");
    }
}

class InfoPerson extends Person {

    @Override
    void printerTitle() {
        super.printerTitle();
        System.out.println("Hello, TOTO");
    }
}

public class ClassObject {
    public static void main(String[] args) {
        Person obj = new Person();
        Car objCar = new Car();
        InfoPerson infoPerson = new InfoPerson();

        obj.setAge(25);
        obj.setName("JAVA");

        System.out.println(obj.getAge());
        System.out.println(obj.getName());
        System.out.println("========== Car ============");

        objCar.setName("GTR");
        objCar.setYearCar(2025);
        objCar.setCarPrice(1111.12);

        System.out.println(objCar.getName());
        System.out.println(objCar.getYearCar());
        System.out.println(objCar.getCarPrice());

        System.out.println("========== Info Person ============");

    }
}
