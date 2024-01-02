package assignment6;

/**
 * Constructs a new playing card with implementation of enums
 */
public class PlayingCard {
    /**
     * Enum representing the values of suits of cards in a standard deck, each value is represented by a symbol
     */
    public enum Suit {
        SPADES("♠"), HEARTS("♥"), DIAMONDS("♦"), CLUBS("♣");

        private final String symbol;

        /**
         * Constructs a Suit instance with a given symbol
         * @param symbol symbol representing the suit
         */
        Suit(String symbol) {
            this.symbol = symbol;
        }

        /**
         * Returns the symbol of the suit as a string
         * @return string representing the symbol
         */
        @Override
        public String toString() {
            return symbol;
        }
    }

    /**
     * Enum representing the values of cards in a standard deck, each value is represented by a symbol
     */
    public enum Value {
        TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"),
        SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"),
        JACK("J"), QUEEN("Q"), KING("K"), ACE("A");

        private final String symbol;

        /**
         * Constructs a Value instance with a given symbol
         * @param symbol Symbol representing the value
         */
        Value(String symbol) {
            this.symbol = symbol;
        }

        /**
         * Returns the symbol of the value as a string
         * @return string representing the symbol of the value
         */
        @Override
        public String toString() {
            return symbol;
        }
    }

    private Suit suit;
    private Value value;

    /**
     * Constructs a PlayingCard with the specified suit and value
     * @param suit Suit of the card
     * @param value Value of the card
     */
    public PlayingCard(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    /**
     * Returns the suit of the card
     * @return suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Returns the value of the card
     * @return value
     */
    public Value getValue() {
        return value;
    }

    /**
     * Returns a string representation of the playing card
     * @return string representation of the playing card
     */
    @Override
    public String toString() {
        return value.toString() + suit.toString();
    }
}
