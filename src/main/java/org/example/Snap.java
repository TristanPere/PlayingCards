package org.example;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.System.exit;

public class Snap extends CardGame {
    private int turn;
    private boolean match = false;
    public Snap(String name) {
        super(name);
        this.turn = 1;
    }

    public boolean hasMatched() {
        return match;
    }

    public void takeTurn(ArrayList<Card> deck) {
        if (turn < 52) {
            System.out.println("Next Card is:");
        }
        System.out.println(deck.get(turn).getCardART());
        turn++;
    }

    public void takeTurn(ArrayList<Card> deck, Player player1, Player player2) {
        if (turn < 52) {
            if (turn % 2 != 0) {
                System.out.println(player1.getName() + "'s turn:");
            } else {
                System.out.println(player2.getName() + "'s turn:");
            }
            System.out.println("Next Card is:");
        }
        System.out.println(deck.get(turn).getCardART());
        turn++;
    }

    public void playGame1P(ArrayList<Card> deck, Scanner scanner) {
        shuffleDeck(deck);
        System.out.println("First Card is:");
        System.out.println(dealCard());
        while (!match) {
            scanner.nextLine();
            takeTurn(deck);
            if (deck.get(turn - 1).getValue() == deck.get(turn - 2).getValue()) {
                System.out.println("You win!!");
                match = true;
            }
        }
    }

    public void playGameVsComputer(Player player1, ArrayList<Card> deck, Scanner scanner) {
        String input;
        Timer timer = new Timer("Timer");
        TimerTask task = new TimerTask() {
            public void run() {
                try {
                    takeTurn(deck);
                } catch (IndexOutOfBoundsException e) {
                    timer.cancel();
                    System.out.println("Game Over. Press ENTER to see score.");
                    match = true;
                }
            }
        };
        shuffleDeck(deck);
        System.out.println("First Card is:");
        System.out.println(dealCard());
        timer.scheduleAtFixedRate(task, 2000L, 2000L);
        while (!match) {
            input = scanner.nextLine();
            if (input.toUpperCase().matches("SNAP") && deck.get(turn - 1).getValue() == deck.get(turn - 2).getValue()) {
                System.out.println("Good Snap!");
                player1.gainScore();
            }
        }
        System.out.println(player1.getScore());
    }


    public void playGame2P(Player player1, Player player2, ArrayList<Card> deck, Scanner scanner) {
        String input;
        Timer timer = new Timer("Timer");
        TimerTask task = new TimerTask() {

            public void run() {
                try {
                    takeTurn(deck, player1, player2);
                } catch (IndexOutOfBoundsException e) {
                    timer.cancel();
                    System.out.println("No Snap, Game Over.");
                    match= true;
                    System.out.println(player1.getScore());
                    System.out.println(player2.getScore());
                    exit(0);
                }
            }
        };
        shuffleDeck(deck);
        System.out.println("First Card is:");
        System.out.println(dealCard());
        timer.scheduleAtFixedRate(task, 2000L, 2000L);
        while (!match) {
            input = scanner.nextLine();
            if (input.toUpperCase().matches("SNAP") && deck.get(turn - 1).getValue() == deck.get(turn - 2).getValue()) {
                if (turn % 2 == 0) {
                    System.out.println(player1.getName() + " WINS!!");
                    player1.gainScore();
                } else {
                    System.out.println(player2.getName() + " WINS!!");
                    player2.gainScore();
                }
                match = true;
            } else if (input.toUpperCase().matches("SNAP") && deck.get(turn - 1).getValue() != deck.get(turn - 2).getValue()) {
                System.out.println("That was NOT a SNAP!");
                if (turn % 2 == 0) {
                    System.out.println(player1.getName() + " LOOSES!!");
                    player1.looseScore();
                } else {
                    System.out.println(player2.getName() + " LOOSES!!");
                    player2.looseScore();
                }
                match = true;
            }
        }
        System.out.println(player1);
        System.out.println(player2);
        timer.cancel();
    }
//    public void gameModeSelect(String gameMode, Scanner scanner, Snap snap, ArrayList<Card> deck){
//        while(!snap.hasMatched()) {
//            if (1 == Integer.parseInt(gameMode)) {
//                System.out.println("Please Enter Your NAME");
//                String P1Name = scanner.nextLine();
//                Player P1 = new Player(P1Name);
//                System.out.println("Simple Snap(1) | MultiSnap(2) | Back To Main Menu (3)");
//                gameMode = scanner.nextLine();
//                if (1 == Integer.parseInt(gameMode)) {
//                    snap.playGame1P(deck, scanner);
//                } else if (2 == Integer.parseInt(gameMode)){
//                    snap.playGameVsComputer(P1, deck, scanner);
//                } else if (3 == Integer.parseInt(gameMode)){
//                    System.out.println("Single-Player(1) | Multi-Player(2) | LeaderBoards(3) | EXIT(4)");
//                    gameMode = scanner.nextLine();
//                    gameModeSelect(gameMode, scanner, snap, deck);
//                } else {
//                    System.out.println("Simple Snap(1) | MultiSnap(2) | Back To Main Menu (3)");
//                    gameMode = scanner.nextLine();
//                }
//            } else if (2 == Integer.parseInt(gameMode)) {
//                System.out.println("Please Enter Your Player 1's Name");
//                String P1Name = scanner.nextLine();
//                Player P1 = new Player(P1Name);
//                System.out.println("Please Enter Your Player 2's Name");
//                String P2Name = scanner.nextLine();
//                Player P2 = new Player(P1Name);
//                snap.playGame2P(P1, P2, deck, scanner);
//            } else {
//                System.out.println("                Please Input a Valid Option                   ");
//                System.out.println("Single-Player(1) | Multi-Player(2) | LeaderBoards(3) | EXIT(4)");
//                gameMode = scanner.nextLine();
//                gameModeSelect(gameMode, scanner, snap, deck);
//            }
//        }
//    }
}
