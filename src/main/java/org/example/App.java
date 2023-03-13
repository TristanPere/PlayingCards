package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Snap snap = new Snap("Snap");
        Player player = new Player("John");
        Player player2 = new Player("Johnny");
        snap.playGame2P(player,player2);
    }
}
