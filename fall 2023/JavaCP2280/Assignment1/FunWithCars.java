/**
 * Assignment 1
 *
 * @author john-michael.woodrow
 */
package assignment1;
import java.util.Scanner;
public class FunWithCars {
    public static void main(String[] args) {
        System.out.println("Let’s have fun with cars!");

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the Name:");
        String nameInput = input.next();

        System.out.println("Enter the Model:");
        String modelInput = input.next();

        System.out.println("Enter the Year:");
        int yearInput = input.nextInt();

        System.out.println("Enter the Value:");
        double valueInput = input.nextDouble();

        Car newCar = new Car(nameInput, modelInput, yearInput, valueInput);

        System.out.printf("Car information: %s,%s from %d. Value: %.0f",newCar.getName(),newCar.getModel(),newCar.getYear(),newCar.getValue());
    }
}
