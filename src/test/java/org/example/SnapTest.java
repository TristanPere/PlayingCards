package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.example.CardVisual.getCardASCII;
import static org.junit.jupiter.api.Assertions.*;

public class SnapTest{
    private Snap snap = new Snap("SNAP");
    private ArrayList<Card> deck = snap.constructDeck();
    private final String newline = System.getProperty("line.separator");
    Card aceOfSpades;
    Player player1;
    @BeforeEach
    void setUp(){
        aceOfSpades = new Card("♠","A",14);
        player1 = new Player("P1");
    }
    @Test
    public void dealCard_returnsStringOfFirstCard() {
        assertEquals(snap.dealCard(),String.join(newline,
                " _____",
                "|2    |",
                "|  ♠  |",
                "|     |",
                "|  ♠  |",
                "|____z|"));
    }

    @Test
    public void getASCII_ValidInput_returnsAsciiArtOfCorrectCard() {
        assertEquals(getCardASCII("♥",2),String.join(newline,
                " _____",
                "|2    |",
                "|  ♥  |",
                "|     |",
                "|  ♥  |",
                "|____z|"));
    }
    @Test
    public void getASCII_InValidInput_returnsStringError(){
        assertEquals(getCardASCII("♥",22), "22♥'s doesn't exist");
    }

    @Test
    public void getSuit_ValidInput_returnsSuitOfCard(){
        assertEquals(aceOfSpades.getSuit(),"♠");
    }
    @Test
    public void getValue_ValidInput_returnsValueOfCard(){
        assertEquals(aceOfSpades.getValue(),"♠");
    }
    @Test
    public void toString_ValidInput_returnsStringOfCard(){
        assertEquals(aceOfSpades.toString(),"A of ♠ has value: 14");
    }
    @Test
    public void getCardART_ValidInput_returnsCardARTOfCard(){
        assertEquals(aceOfSpades.getCardART(),String.join(newline,
                " _____",
                "|A♠.  |",
                "| /.\\ |",
                "|(_._)|",
                "|  |  |",
                "|___♠V|"));
    }
    @Test
    public void getScore_returnsPlayerScore(){
        assertEquals(player1.getScore(),0);
    }
    @Test
    public void gainScore_increasesPlayerScore(){
        player1.gainScore();
        assertEquals(player1.getScore(),5);
    }
    @Test
    public void looseScore_increasesPlayerScore(){
        player1.looseScore();
        assertEquals(player1.getScore(),-1);
    }

    @Test
    public void toString_increasesPlayerScore(){
        player1.gainScore();
        player1.looseScore();
        assertEquals(player1.toString(),"Name: P1" + System.getProperty("line.separator") + "Score: 4");
    }
}