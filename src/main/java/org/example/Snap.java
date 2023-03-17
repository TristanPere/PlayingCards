package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.System.exit;

public class Snap extends CardGame {
    protected int turn;
    protected boolean match = false;

    public Snap(String name) {
        super(name);
        this.turn = 1;
    }

    protected int stringToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @Override
    protected void takeTurn(ArrayList<Card> deck) {
        if (turn < deck.size()) {
            System.out.println("Next Card is:");
        }
        System.out.println(deck.get(turn).getCardART());
        turn++;
    }

    @Override
    protected void takeTurn(ArrayList<Card> deck, Player player1, Player player2) {
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

    @Override
    protected void takeTurn(Player player) {
        Card nextCard = player.playCard();
        System.out.println(nextCard.getCardART());
        dealtCards.add(nextCard);
        this.turn++;
    }
    private ArrayList<Player> generatePlayerArray(String noOfPlayers) {
        Scanner scanner = new Scanner(System.in);
        int intNumOfPlayers = stringToInt(noOfPlayers);
        ArrayList<Player> playerArr = new ArrayList<>();
        if (intNumOfPlayers > 0 && intNumOfPlayers < 15) {
            for (int i = 0; i < intNumOfPlayers; i++) {
                playerArr.add(new Player("Player" + (i + 1)));
            }
            System.out.println(playerArr);
            return playerArr;
        } else {
            System.out.println("Please enter a valid number less than 15:");
            String numOfPlayers = scanner.nextLine();
            playerArr = generatePlayerArray(numOfPlayers);
            return playerArr;
        }
    }
    private void playGame1P(Scanner scanner) {
        this.turn = 1;
        this.match = false;
        deck = shuffleDeck(deck);
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
        System.out.println("Play-Again(1) | Play MultiSnap (2) | Back to Main Menu (3)");
        String playAgain = scanner.nextLine();
        int playAgainInt = stringToInt(playAgain);
        if (1 == playAgainInt) {
            playGame1P(scanner);
        } else if (2 == playAgainInt) {
            System.out.println("Please Enter Players Name");
            String playerName = scanner.nextLine();
            playGameVsComputer(new Player(playerName), scanner);
        } else if (3 == playAgainInt) {
            System.out.println("Single-Player(1) | Multi-Player(2) | EXIT(3)");
            String gameMode = scanner.nextLine();
            gameModeSelect(gameMode, scanner);
        } else {
            System.out.println("Invalid Input Returned to 1 Player Menu with Default Name (Player1)");
            play1PGAMELOGIC(scanner, new Player("Player1"));
        }
    }

    private void playGameVsComputer(Player player1, Scanner scanner) {
        this.turn = 1;
        this.match = false;
        deck = shuffleDeck(deck);
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
        System.out.println("Type Snap to Snap!");
        System.out.println("First Card is:");
        System.out.println(dealCard());
        timer.scheduleAtFixedRate(task, 2000L, 2000L);
        while (!match) {
            input = scanner.nextLine();
            if (input.toUpperCase().matches("SNAP") && deck.get(turn - 1).getValue() == deck.get(turn - 2).getValue()) {
                System.out.println("Good Snap!");
                player1.gainScore();
            } else if (input.toUpperCase().matches("SNAP") && deck.get(turn - 1).getValue() != deck.get(turn - 2).getValue()) {
                System.out.println("Bad Snap!");
                player1.looseScore();
            }
        }
        timer.cancel();
        System.out.println("Your Finale Score Was: " + player1.getScore());
        System.out.println("Play-Again(1) | Play Single Snap (2) | Back to Main Menu (3)");
        String playAgain = scanner.nextLine();
        int playAgainInt = stringToInt(playAgain);
        if (1 == playAgainInt) {
            playGameVsComputer(player1, scanner);
        } else if (2 == playAgainInt) {
            playGame1P(scanner);
        } else if (3 == playAgainInt) {
            System.out.println("Single-Player(1) | Multi-Player(2) | EXIT(3)");
            String gameMode = scanner.nextLine();
            gameModeSelect(gameMode, scanner);
        } else {
            System.out.println("Invalid Input Returned to 1 Player Menu with Default Name (Player1)");
            play1PGAMELOGIC(scanner, player1);
        }
    }

    private void playGame2P(Player player1, Player player2, Scanner scanner) {
        this.turn = 1;
        this.match = false;
        deck = shuffleDeck(deck);
        String input;
        Timer timer = new Timer("Timer");
        TimerTask task = new TimerTask() {

            public void run() {
                try {
                    takeTurn(deck, player1, player2);
                } catch (IndexOutOfBoundsException e) {
                    timer.cancel();
                    System.out.println("No Snap, Game Over.");
                    match = true;
                    System.out.println(player1.getScore());
                    System.out.println(player2.getScore());
                }
            }
        };
        System.out.println("Type Snap to Snap! First Snap Wins!");
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
        System.out.println("Play-Again(1) | Play Free4All (2) | Back to Main Menu (3)");
        String playAgain = scanner.nextLine();
        int playAgainInt = stringToInt(playAgain);
        if (1 == playAgainInt) {
            play2PGAMELOGIC(scanner);
        } else if (2 == playAgainInt) {
            System.out.println("Please Enter Number of Players:");
            String noOfPlayers = scanner.nextLine();
            ArrayList<Player> playerArr = generatePlayerArray(noOfPlayers);
            MultiplayerSnap(playerArr);
        } else if (3 == playAgainInt) {
            System.out.println("Single-Player(1) | Multi-Player(2) | EXIT(3)");
            String gameMode = scanner.nextLine();
            gameModeSelect(gameMode, scanner);
        } else {
            System.out.println("Invalid input, returned to Multiplayer Menu");
            play2PGAMELOGIC(scanner);
        }
    }

    public void MultiplayerSnap(ArrayList<Player> players) {
        Scanner scanner = new Scanner(System.in);
        this.turn = 0;
        this.match = false;
        dealAllCards(players);
        Timer timer = new Timer("Timer");
        TimerTask task = new TimerTask() {

            public void run() {
                try {
                    takeTurn(players.get(turn % players.size()));
                } catch (IndexOutOfBoundsException e) {
                    timer.cancel();
                    System.out.println("No Snap, Game Over.");
                    match = true;
                }
            }
        };
        System.out.println("Type Your Number To Snap! First Snap Wins!");
        System.out.println("First Card is:");
        takeTurn(players.get(this.turn % players.size()));
        timer.scheduleAtFixedRate(task, 2000L, 2000L);
        while (!this.match) {
            String input = scanner.nextLine();
            int inputInt = stringToInt(input) - 1;
            if (dealtCards.get(this.turn - 1).getValue() == dealtCards.get(this.turn - 2).getValue()) {
                System.out.println("SNAP!");
                if (inputInt < players.size() && inputInt >= 0) {
                    System.out.println(players.get(inputInt).getName() + " Wins!!");
                    players.get(inputInt).gainScore();
                    this.match = true;
                } else {
                    System.out.println("No player" + (inputInt + 1) + ". Game Continues.");
                }
            } else if (dealtCards.get(this.turn - 1).getValue() != dealtCards.get(this.turn - 2).getValue()) {
                System.out.println("Not a SNAP!!");
                if (inputInt < players.size() && inputInt >= 0) {
                    System.out.println(players.get(inputInt).getName() + " Looses!!");
                    players.get(inputInt).gainScore();
                    this.match = true;
                } else {
                    System.out.println("No player " + (inputInt + 1) + ". Game Continues");
                }
            }
        }
        timer.cancel();
        System.out.println("Play-Again(1) | Back to MultiPlayer Menu (2) | Back to Main Menu (3)");
        String playAgain = scanner.nextLine();
        int playAgainInt = stringToInt(playAgain);
        if (1 == playAgainInt) {
            MultiplayerSnap(players);
        } else if (2 == playAgainInt) {
            play2PGAMELOGIC(scanner);
        } else if (3 == playAgainInt) {
            System.out.println("Single-Player(1) | Multi-Player(2) | EXIT(3)");
            String gameMode = scanner.nextLine();
            gameModeSelect(gameMode, scanner);
        } else {
            System.out.println("Invalid input, returned to Multiplayer Menu");
            play2PGAMELOGIC(scanner);
        }
    }

    private void play1PGAMELOGIC(Scanner scanner, Player P1) {
        System.out.println("Simple Snap(1) | MultiSnap(2) | Back To Main Menu (3)");
        String gameMode = scanner.nextLine();
        int gameModeInt = stringToInt(gameMode);
        if (1 == gameModeInt) {
            playGame1P(scanner);
        } else if (2 == gameModeInt) {
            playGameVsComputer(P1, scanner);
        } else if (3 == gameModeInt) {
            System.out.println("Single-Player(1) | Multi-Player(2) | EXIT(3)");
            gameMode = scanner.nextLine();
            gameModeSelect(gameMode, scanner);
        } else {
            System.out.println("Please Enter a Valid Option");
            play1PGAMELOGIC(scanner, P1);
        }
    }

    private void play2PGAMELOGIC(Scanner scanner) {
        System.out.println("1V1 Snap(1) | SnapFree4All(2) | Back To Main Menu (3)");
        String gameMode = scanner.nextLine();
        int gameModeInt = stringToInt(gameMode);
        if (1 == gameModeInt) {
            System.out.println("Please Enter Your Player 1's Name");
            String P1Name = scanner.nextLine();
            Player P1 = new Player(P1Name);
            System.out.println("Please Enter Your Player 2's Name");
            String P2Name = scanner.nextLine();
            Player P2 = new Player(P2Name);
            playGame2P(P1, P2, scanner);
        } else if (2 == gameModeInt) {
            System.out.println("Please Enter Number of Players:");
            String noOfPlayers = scanner.nextLine();
            ArrayList<Player> playerArr = generatePlayerArray(noOfPlayers);
            MultiplayerSnap(playerArr);
        } else if (3 == gameModeInt) {
            System.out.println("Single-Player(1) | Multi-Player(2) | EXIT(3)");
            gameMode = scanner.nextLine();
            gameModeSelect(gameMode, scanner);
        } else {
            System.out.println("Please Enter a Valid Option");
            play2PGAMELOGIC(scanner);
        }
    }

    public void gameModeSelect(String gameMode, Scanner scanner) {
        int gameModeInt = stringToInt(gameMode);
        if (1 == gameModeInt) {
            System.out.println("Please Enter Your NAME");
            String P1Name = scanner.nextLine();
            Player P1 = new Player(P1Name);
            play1PGAMELOGIC(scanner, P1);
        } else if (2 == gameModeInt) {
            play2PGAMELOGIC(scanner);
        } else if (3 == gameModeInt) {
            System.out.println("Thanks For playing. Good Bye.");
            exit(0);
        } else {
            System.out.println("         Please Input a Valid Option         ");
            System.out.println("Single-Player(1) | Multi-Player(2) | EXIT(3)");
            gameMode = scanner.nextLine();
            gameModeSelect(gameMode, scanner);
        }

    }

}
