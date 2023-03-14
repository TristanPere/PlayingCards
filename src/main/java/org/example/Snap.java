package org.example;

import java.util.Scanner;

import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {
    private int turn;
    private boolean match;
    private String input = "";

    public Snap(String name) {
        super(name);
        this.turn = 1;
        this.match = false;
    }
    public void takeTurn() {
        System.out.println("Next Card is:");
        System.out.println(this.deck.get(turn));
        turn++;
    }
    public void playGame1P() {
        Scanner scanner = new Scanner(System.in);
        shuffleDeck();
        System.out.println("First Card is:");
        System.out.println(dealCard());
        while (!match) {
            scanner.nextLine();
            takeTurn();
            if (this.deck.get(turn - 1).getValue() == this.deck.get(turn - 2).getValue()) {
                System.out.println("You win!!");
                match = true;
            }
        }
    }

    public void playGame2P(Player player1, Player player2) {
        Timer timer = new Timer("Timer");

        Scanner scanner = new Scanner(System.in);
        TimerTask task = new TimerTask() {
            public void run() {
                takeTurn();
            }
        };
        shuffleDeck();
        System.out.println("First Card is:");
        System.out.println(dealCard());
        timer.scheduleAtFixedRate(task, 1000L, 1000L);
        while (!match) {
            input = scanner.nextLine();
            if (input.toUpperCase().matches("SNAP") && this.deck.get(turn - 1).getValue() == this.deck.get(turn - 2).getValue()) {
                if (turn % 2 == 0) {
                    System.out.println(player1.getName() + " WINS!!");
                    player1.setScore();
                } else {
                    System.out.println(player2.getName() + " WINS!!");
                    player2.setScore();
                }
                match = true;
            } else if (input.toUpperCase().matches("SNAP") && this.deck.get(turn - 1).getValue() != this.deck.get(turn - 2).getValue()) {
                if (turn % 2 == 0) {
                    System.out.println(player1.getName() + " LOOSES!!");
                    player2.setScore();
                } else {
                    System.out.println(player2.getName() + " LOOSES!!");
                    player1.setScore();
                }
                match = true;
            } else if (turn == 52) {
                System.out.println("No Matches that game!");
                match = true;
            }
        }
        timer.cancel();
    }
}
