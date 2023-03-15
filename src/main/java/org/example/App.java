package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Snap snap = new Snap("Snap");
        Player player = new Player("John");
        Player player2 = new Player("Johnny");
        ArrayList<Card> deck = snap.constructDeck();
        Scanner scanner = new Scanner(System.in);
        System.out.println("                     Welcome to SNAP!!                        ");
        System.out.println("Single-Player(1) | Multi-Player(2) | LeaderBoards(3) | EXIT(4)");
        String gameMode = scanner.nextLine();
        snap.gameModeSelect(gameMode, scanner, snap, deck);
    }
}