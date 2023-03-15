package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Snap snap = new Snap("Snap");
        ArrayList<Card> deck = snap.constructDeck();
        Scanner scanner = new Scanner(System.in);
        System.out.println("             Welcome to SNAP!!              ");
        System.out.println("Single-Player(1) | Multi-Player(2) | EXIT(3)");
        String gameMode = scanner.nextLine();
        snap.gameModeSelect(gameMode, scanner, snap, deck);
    }
}