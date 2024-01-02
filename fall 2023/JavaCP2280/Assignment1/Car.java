package assignment1;

public class Car {
    private String name;
    private String model;
    private int year;
    private double value;

    public Car(String name, String model, int year, double value) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

