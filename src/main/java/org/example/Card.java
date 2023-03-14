package org.example;

import static org.example.CardVisual.getCardASCII;

public class Card {
    private String suit;
    private String symbol;
    private int value;

    public Card(String suit, String symbol, int value) {
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

    public String toString(){
        return symbol + " of " + suit + " has value: " + value;
    }
    public String getCardART(){
        return getCardASCII(this.suit, this.value);
    }
}
