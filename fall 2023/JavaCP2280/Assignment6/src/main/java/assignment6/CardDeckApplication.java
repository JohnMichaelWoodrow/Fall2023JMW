package assignment6;

import java.util.List;
import java.util.Scanner;
/**
 * Application for interacting with CardDeck, PlayingCard and PlayingCardFactory
 */
public class CardDeckApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardDeck deck = new CardDeck();
        //deck.shuffle();
        int choice = 0;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Draw a card");
            System.out.println("2. Draw a hand");
            System.out.println("3. Print the deck");
            System.out.println("4. Shuffle the deck");
            System.out.println("5. Draw a random card");
            System.out.println("6. Draw a random card by suit");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("You drew: " + deck.drawCard());
            } else if (choice == 2) {
                System.out.print("Enter number of cards to draw: ");
                int num = scanner.nextInt();
                List<PlayingCard> hand = deck.drawHand(num);
                System.out.println("Your hand: " + hand);
            } else if (choice == 3) {
                deck.printDeck();
            } else if (choice == 4) {
                deck.shuffle();
                System.out.println("Deck shuffled");
            } else if (choice == 5) {
                System.out.println("Random card: " + PlayingCardFactory.generateRandomCard());
            } else if (choice == 6) {
                System.out.println("Choose a suit (1: SPADES, 2: HEARTS, 3: DIAMONDS, 4: CLUBS): ");
                int suitChoice = scanner.nextInt();
                PlayingCard.Suit[] suits = PlayingCard.Suit.values();
                if (suitChoice >= 1 && suitChoice <= suits.length) {
                    System.out.println("Random card from suit: " + PlayingCardFactory.generateRandomCardSuit(suits[suitChoice - 1]));
                } else {
                    System.out.println("Invalid suit choice");
                }
            } else if (choice == 7) {
                System.out.println("Goodbye");
                scanner.close();
                return;
            } else {
                System.out.println("Invalid option");
            }
        } while (choice != 7);
    }
}

