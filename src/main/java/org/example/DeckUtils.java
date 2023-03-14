package org.example;

public enum DeckUtils {
    SUITS(new String[]{"♠", "♥", "♦", "♣"}), SYMBOLS(new String[]{"J", "Q", "K", "A"});
    private final String[] collection;
    DeckUtils(String[] strings) {
        this.collection = strings;
    }

    public String[] getCollection() {
        return collection;
    }


}
