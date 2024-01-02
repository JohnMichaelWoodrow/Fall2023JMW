package assignment3;
import java.util.Scanner;

public class funWithFibPattern {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Maximum: ");
        int loopMax = input.nextInt();
        int firstNumber = 0;
        int secondNumber = 1;
        for (int i = 1; i <= loopMax; i = firstNumber+secondNumber) {
            if (i == 1){
                System.out.printf("0, 1, %d", i);
            } else{
                System.out.printf(", %d", i);
            }
            firstNumber = secondNumber;
            secondNumber = i;
        }

    }
}
