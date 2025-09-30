package OOP;

public class Task3 {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Tho Panha");
        s.setMathMark(70);
        s.setEnglishMark(100);

        System.out.println("name: " + s.getName());
        System.out.println("avg: " + s.calculateAverage());
    }
}

class Student {
    private String name;
    private double mathMark;
    private double englishMark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMathMark() {
        return mathMark;
    }

    public void setMathMark(double mark) {
        validateMark(mark);
        this.mathMark = mark;
    }

    public double getEnglishMark() {
        return englishMark;
    }

    public void setEnglishMark(double mark) {
        validateMark(mark);
        this.englishMark = mark;
    }

    public double calculateAverage() {
        return (mathMark + englishMark) / 2.0;
    }

    private void validateMark(double mark) {
        if (mark < 0 || mark > 100) {
            System.out.println("only allow marks 0-100");
        }
    }
}
