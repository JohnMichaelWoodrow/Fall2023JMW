package assignment2;

/**
 * Assignment 2 Part 1
 *
 * @author john-michael.woodrow
 */

public class Employee {
    private String firstName;
    private String lastName;
    private double annualSalary;

    public Employee(String firstName, String lastName, double annualSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public void giveRaise(double percent){
        this.annualSalary = this.annualSalary * (1 + percent);
    }
}

