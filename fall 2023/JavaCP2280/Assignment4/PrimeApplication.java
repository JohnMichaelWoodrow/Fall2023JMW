package assignment4;

/**
 * Assignment 4
 *
 * A class to test the Prime Number Calculator
 *
 * @author john-michael.woodrow
 */

import java.util.Scanner;

public class PrimeApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrimeNumberCalculator calculator = new PrimeNumberCalculator();

        int choice = 0;

        while (choice != 5) {
            System.out.println("\nSelect an option:");
            System.out.println("1) Print all primes up to a number");
            System.out.println("2) Print all primes between two numbers");
            System.out.println("3) Print the prime factorization of a number");
            System.out.println("4) Print the prime factorization of all numbers up to a limit");
            System.out.println("5) Exit");
            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter a number: ");
                int limit = scanner.nextInt();
                for (int i = 2; i <= limit; i++) {
                    if (calculator.isPrime(i)) {
                        System.out.println(i);
                    }
                }
            } else if (choice == 2) {
                System.out.println("Enter start number: ");
                int start = scanner.nextInt();
                System.out.println("Enter end number: ");
                int end = scanner.nextInt();
                for (int i = start; i <= end; i++) {
                    if (calculator.isPrime(i)) {
                        System.out.println(i);
                    }
                }
            } else if (choice == 3) {
                System.out.println("Enter a number: ");
                int num = scanner.nextInt();
                System.out.printf("Prime Factorization: %s\n", calculator.getUniquePrimeFactorization(num));
            } else if (choice == 4) {
                System.out.println("Enter a limit: ");
                int maxLimit = scanner.nextInt();
                for (int i = 2; i <= maxLimit; i++) {
                    System.out.printf("Prime Factorization: %d = %s\n", i, calculator.getUniquePrimeFactorization(i));
                }
            } else if (choice == 5) {
                System.out.println("Goodbye");
            } else {
                System.out.println("Invalid entry");
            }
        }
    }
}
