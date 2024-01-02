package assignment2;

import java.util.Scanner;

/**
 * Assignment 2 Part 2
 *
 * @author john-michael.woodrow
 */
public class FunWithEmployees {

    public static void main(String[] args) {
        double salaryTotal = 0;
        int employeeCounter = 0;
        int NUM_EMPLOYEES = 3;

        while (employeeCounter < NUM_EMPLOYEES) {
            Scanner input = new Scanner(System.in);

            System.out.println("Enter First Name: ");
            String firstNameInput = input.next();

            System.out.println("Enter Last Name: ");
            String lastNameInput = input.next();

            System.out.println("Enter Salary: ");
            double salaryInput = input.nextDouble();

            Employee employee = new Employee(firstNameInput, lastNameInput, salaryInput);

            double percent = 0.08;
            employee.giveRaise(percent);

            System.out.printf("First Name: %s Last Name: %s Salary: %,.2f \n", employee.getFirstName(), employee.getLastName(), employee.getAnnualSalary());

            salaryTotal = salaryTotal + employee.getAnnualSalary();

            employeeCounter++;

        }
        System.out.printf("Average Salary: %,.2f ", (salaryTotal / NUM_EMPLOYEES));

    }
}
