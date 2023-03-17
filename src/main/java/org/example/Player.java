package org.example;

import java.util.ArrayList;

public class Player {
    private final String name;
    private int score;
    private ArrayList<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public void gainScore() {
        this.score += 5;
    }

    public void looseScore() {
        this.score -= 1;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return this.score;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void giveCard(Card card) {
        this.hand.add(card);
    }
    public Card playCard(){
        Card card = this.hand.get(0);
        this.hand.remove(0);
        return card;
    }

    public String toString() {
        return "Name: " + name + System.getProperty("line.separator") + "Score: " + score;
    }
}
