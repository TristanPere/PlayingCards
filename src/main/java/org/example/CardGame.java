package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Deck {


    private ArrayList<PlayingCard> deck ;
    ;
    private String[] suits = new String[]{"♠", "♥", "♦", "♣"};
    private String[] symbol = new String[]{"J", "Q", "K", "A"};
    private String name;

    public Deck(String name) {
        this.name = name;
        deck = new ArrayList<PlayingCard>();
        PlayingCard playingCard;
        for (int i = 0; i < 4; i++) {
            String suit = suits[i];
            for (int j = 2; j < 15; j++) {
                if (j <= 10) {
                    playingCard = new PlayingCard(suit, String.valueOf(j), j);
                } else {
                    playingCard = new PlayingCard(suit, symbol[j - 11], j);
                }
                this.deck.add(playingCard);
            }
        }
    }

    public void getDeck() {
        this.deck.forEach(playingCard -> {
            System.out.println(playingCard.toString());
        });

    }

    public PlayingCard dealCard() {
        return this.deck.get(0);
    }

    public ArrayList<PlayingCard> sortDeckInNumberOrder(){
        this.deck = (ArrayList<PlayingCard>) deck.stream().sorted(Comparator.comparing(PlayingCard::getValue)).collect(Collectors.toList());
        return deck;
    }

    public ArrayList<PlayingCard> sortDeckIntoSuits(){
        ArrayList<PlayingCard> sortedDeck = (ArrayList<PlayingCard>) deck.stream().sorted(Comparator.comparing(PlayingCard::getValue)).collect(Collectors.toList());
        this.deck = (ArrayList<PlayingCard>) sortedDeck.stream().sorted(Comparator.comparing(PlayingCard::getSuit)).collect(Collectors.toList());
        return deck;
    };

    public ArrayList<PlayingCard> shuffleDeck() {
        Random r = new Random();
        for (int i = 51; i > 0; i--) {
            // Pick a random index from 0 to i
            int j = r.nextInt(i);
            // Swap deck[i] with the element at random index
            PlayingCard temp = deck.get(i);
            this.deck.set(i,deck.get(j));
            this.deck.set(j,temp);
        }
        return deck;
    }
}

