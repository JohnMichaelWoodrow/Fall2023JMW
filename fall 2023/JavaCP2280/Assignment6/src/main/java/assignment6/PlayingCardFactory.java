package assignment6;

import java.util.Random;

/**
 * Constructs a new card deck with implementation of cards list and discarded pile list
 */
public class PlayingCardFactory {
    /**
     * Generates a random playing card
     * @return A random PlayingCard
     */
    public static PlayingCard generateRandomCard() {
        Random random = new Random();
        PlayingCard.Suit[] suits = PlayingCard.Suit.values();
        PlayingCard.Value[] values = PlayingCard.Value.values();
        PlayingCard.Suit suit = suits[random.nextInt(suits.length)];
        PlayingCard.Value value = values[random.nextInt(values.length)];
        return new PlayingCard(suit, value);
    }

    /**
     * Generates a random playing card from a specific suit
     * @param suit which suit to return
     * @return random PlayingCard
     */
    public static PlayingCard generateRandomCardSuit(PlayingCard.Suit suit) {
        Random rand = new Random();
        PlayingCard.Value[] values = PlayingCard.Value.values();
        PlayingCard.Value value = values[rand.nextInt(values.length)];
        return new PlayingCard(suit, value);
    }
}
