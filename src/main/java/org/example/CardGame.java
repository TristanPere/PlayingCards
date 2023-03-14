package org.example;

import java.util.*;
import java.util.stream.Collectors;

public abstract class CardGame {

    protected ArrayList<Card> deck;

    private final String name;

    public CardGame(String name) {
        this.name = name;
        this.deck = constructDeck();
    }
    public ArrayList<Card> constructDeck(){
        Card card;
        ArrayList<Card> cardDeck = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String suit = DeckUtils.SUITS.getCollection()[i];
            for (int j = 2; j < 15; j++) {
                if (j <= 10) {
                    card = new Card(suit, String.valueOf(j), j);
                } else {
                    card = new Card(suit, DeckUtils.SYMBOLS.getCollection()[j - 11], j);
                }
                cardDeck.add(card);
            }
        }
        return cardDeck;
    }

    public void getDeck() {
        this.deck.forEach(card -> {
            System.out.println(card.toString());
        });
    }

    public String dealCard() {
        return this.deck.get(0).getCardART();
    }

    public ArrayList<Card> sortDeckInNumberOrder(){
        this.deck = (ArrayList<Card>) deck.stream().sorted(Comparator.comparing(Card::getValue)).collect(Collectors.toList());
        return deck;
    }

    public ArrayList<Card> sortDeckIntoSuits(){
        ArrayList<Card> sortedDeck = (ArrayList<Card>) deck.stream().sorted(Comparator.comparing(Card::getValue)).collect(Collectors.toList());
        this.deck = (ArrayList<Card>) sortedDeck.stream().sorted(Comparator.comparing(Card::getSuit)).collect(Collectors.toList());
        return deck;
    };

    public ArrayList<Card> shuffleDeck(ArrayList<Card> deck ) {
        Random r = new Random();
        for (int i = 51; i > 0; i--) {
            // Pick a random index from 0 to i
            int j = r.nextInt(i);
            // Swap deck[i] with the element at random index
            Card temp = deck.get(i);
            deck.set(i,deck.get(j));
            deck.set(j,temp);
        }
        return deck;
    }
}

