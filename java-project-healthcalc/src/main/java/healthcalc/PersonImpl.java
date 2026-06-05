package healthcalc;

public class PersonImpl implements Person {
    private double weight;
    private double height;
    private Gender gender;
    private int age;

    public PersonImpl(double weight, double height, Gender gender, int age) {
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public double height() {
        return this.height;
    }

    @Override
    public Gender gender() {
        return this.gender;
    }

    @Override
    public int age() {
        return this.age;
    }

}
