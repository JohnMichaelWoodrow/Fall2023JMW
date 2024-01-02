package assignment4;

/**
 * Assignment 4
 *
 * A class to represent Prime Number & Factorization Calculation
 *
 * @author john-michael.woodrow
 */

public class PrimeNumberCalculator {

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String getUniquePrimeFactorization(int n) {
        String factorization = "";

        for (int i = 2; i <= n; i++) {
            while (isPrime(i) && n % i == 0) {
                factorization += i + " ";
                n /= i;
            }
        }
        return factorization;
    }
}
