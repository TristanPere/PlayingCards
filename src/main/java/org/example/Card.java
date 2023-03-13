package org.example;

public class PlayingCard {
    private String suit;
    private String symbol;

    public PlayingCard(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    private int value;
    public String toString(){
        return symbol + " of " + suit + " has value: " + value;
    }
}
