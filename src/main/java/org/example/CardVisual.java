package org.example;

public class CardVisual {
    private static final String newline = System.getProperty("line.separator");

    public static String getCardASCII(String suit, int value) {
        if(value<15) {
            switch (suit) {
                case "♠":
                    return spades[value - 2];
                case "♥":
                    return hearts[value - 2];
                case "♦":
                    return diamonds[value - 2];
                case "♣":
                    return clubs[value - 2];
            }
        }
        return value+suit+"'s doesn't exist";
    }

    ;
    private static final String[] hearts = new String[]{
            String.join(newline,
                    " _____",
                    "|2    |",
                    "|  ♥  |",
                    "|     |",
                    "|  ♥  |",
                    "|____z|")
            , String.join(newline,
            " _____",
            "|3    |",
            "| ♥ ♥ |",
            "|     |",
            "|  ♥  |",
            "|____E|")
            , String.join(newline,
            " _____",
            "|4    |",
            "| ♥ ♥ |",
            "|     |",
            "| ♥ ♥ |",
            "|____h|")
            , String.join(newline,
            " _____",
            "|5    |",
            "| ♥ ♥ |",
            "|  ♥  |",
            "| ♥ ♥ |",
            "|____S|")
            , String.join(newline,
            " _____",
            "|6    |",
            "| ♥ ♥ |",
            "| ♥ ♥ |",
            "| ♥ ♥ |",
            "|____9|")
            , String.join(newline,
            " _____",
            "|7    |",
            "| ♥ ♥ |",
            "|♥ ♥ ♥|",
            "| ♥ ♥ |",
            "|____L|")
            , String.join(newline,
            " _____",
            "|8    |",
            "|♥ ♥ ♥|",
            "| ♥ ♥ |",
            "|♥ ♥ ♥|",
            "|____8|")
            , String.join(newline,
            " _____",
            "|9    |",
            "|♥ ♥ ♥|",
            "|♥ ♥ ♥|",
            "|♥ ♥ ♥|",
            "|____6|")
            , String.join(newline,
            " _____",
            "|10 ♥ |",
            "|♥ ♥ ♥|",
            "|♥ ♥ ♥|",
            "|♥ ♥ ♥|",
            "|___0I|")
            , String.join(newline,
            " _____",
            "|J♥ ww|",
            "|   {)|",
            "|(♥)% |",
            "| ♥ % |",
            "|__%%[|")
            , String.join(newline,
            " _____",
            "|Q♥   |",
            "|   {(|",
            "|(♥)%%|",
            "| ♥%%%|",
            "|_%%%Ò|")
            , String.join(newline,
            " _____",
            "|K♥ ww|",
            "|   {)|",
            "|(♥)%%|",
            "| ♥%%%|",
            "|_%%%>|"),
            String.join(newline,
            " _____",
            "|A_ _ |",
            "|( v )|",
            "| \\ / |",
            "|  .  |",
            "|____V|")
    };
    private static final String[] diamonds = new String[]{
            String.join(newline,
                    " _____",
                    "|2    |",
                    "|  ♦  |",
                    "|     |",
                    "|  ♦  |",
                    "|____z|")
            , String.join(newline,
            " _____",
            "|3    |",
            "| ♦ ♦ |",
            "|     |",
            "|  ♦  |",
            "|____E|")
            , String.join(newline,
            " _____",
            "|4    |",
            "| ♦ ♦ |",
            "|     |",
            "| ♦ ♦ |",
            "|____h|")
            , String.join(newline,
            " _____",
            "|5    |",
            "| ♦ ♦ |",
            "|  ♦  |",
            "| ♦ ♦ |",
            "|____S|")
            , String.join(newline,
            " _____",
            "|6    |",
            "| ♦ ♦ |",
            "| ♦ ♦ |",
            "| ♦ ♦ |",
            "|____9|")
            , String.join(newline,
            " _____",
            "|7    |",
            "| ♦ ♦ |",
            "|♦ ♦ ♦|",
            "| ♦ ♦ |",
            "|____L|")
            , String.join(newline,
            " _____",
            "|8    |",
            "|♦ ♦ ♦|",
            "| ♦ ♦ |",
            "|♦ ♦ ♦|",
            "|____8|")
            , String.join(newline,
            " _____",
            "|9    |",
            "|♦ ♦ ♦|",
            "|♦ ♦ ♦|",
            "|♦ ♦ ♦|",
            "|____6|")
            , String.join(newline,
            " _____",
            "|10 ♦ |",
            "|♦ ♦ ♦|",
            "|♦ ♦ ♦|",
            "|♦ ♦ ♦|",
            "|___0I|")
            , String.join(newline,
            " _____",
            "|J♦ ww|",
            "|   {)|",
            "|(♦)% |",
            "| ♦ % |",
            "|__%%[|")
            , String.join(newline,
            " _____",
            "|Q♦   |",
            "|   {(|",
            "|(♦)%%|",
            "| ♦%%%|",
            "|_%%%Ò|")
            , String.join(newline,
            " _____",
            "|K♦ ww|",
            "|   {)|",
            "|(♦)%%|",
            "| ♦%%%|",
            "|_%%%>|"),
            String.join(newline,
                    " _____",
                    "|A♦^  |",
                    "| / \\ |",
                    "| \\ / |",
                    "|  .  |",
                    "|___♦V|")
    };
    private static final String[] clubs = new String[]{
            String.join(newline,
                    " _____",
                    "|2    |",
                    "|  ♣  |",
                    "|     |",
                    "|  ♣  |",
                    "|____z|")
            , String.join(newline,
            " _____",
            "|3    |",
            "| ♣ ♣ |",
            "|     |",
            "|  ♣  |",
            "|____E|")
            , String.join(newline,
            " _____",
            "|4    |",
            "| ♣ ♣ |",
            "|     |",
            "| ♣ ♣ |",
            "|____h|")
            , String.join(newline,
            " _____",
            "|5    |",
            "| ♣ ♣ |",
            "|  ♣  |",
            "| ♣ ♣ |",
            "|____S|")
            , String.join(newline,
            " _____",
            "|6    |",
            "| ♣ ♣ |",
            "| ♣ ♣ |",
            "| ♣ ♣ |",
            "|____9|")
            , String.join(newline,
            " _____",
            "|7    |",
            "| ♣ ♣ |",
            "|♣ ♣ ♣|",
            "| ♣ ♣ |",
            "|____L|")
            , String.join(newline,
            " _____",
            "|8    |",
            "|♣ ♣ ♣|",
            "| ♣ ♣ |",
            "|♣ ♣ ♣|",
            "|____8|")
            , String.join(newline,
            " _____",
            "|9    |",
            "|♣ ♣ ♣|",
            "|♣ ♣ ♣|",
            "|♣ ♣ ♣|",
            "|____6|")
            , String.join(newline,
            " _____",
            "|10 ♣ |",
            "|♣ ♣ ♣|",
            "|♣ ♣ ♣|",
            "|♣ ♣ ♣|",
            "|___0I|")
            , String.join(newline,
            " _____",
            "|J♣ ww|",
            "|   {)|",
            "|(♣)% |",
            "| ♣ % |",
            "|__%%[|")
            , String.join(newline,
            " _____",
            "|Q♣   |",
            "|   {(|",
            "|(♣)%%|",
            "| ♣%%%|",
            "|_%%%Ò|")
            , String.join(newline,
            " _____",
            "|K♣ ww|",
            "|   {)|",
            "|(♣)%%|",
            "| ♣%%%|",
            "|_%%%>|"),
            String.join(newline,
                    " _____",
                    "|A♣_  |",
                    "| ( ) |",
                    "|(_'_)|",
                    "|  |  |",
                    "|___♣V|")
    };
    private static final String[] spades = new String[]{
            String.join(newline,
                    " _____",
                    "|2    |",
                    "|  ♠  |",
                    "|     |",
                    "|  ♠  |",
                    "|____z|")
            , String.join(newline,
            " _____",
            "|3    |",
            "| ♠ ♠ |",
            "|     |",
            "|  ♠  |",
            "|____E|")
            , String.join(newline,
            " _____",
            "|4    |",
            "| ♠ ♠ |",
            "|     |",
            "| ♠ ♠ |",
            "|____h|")
            , String.join(newline,
            " _____",
            "|5    |",
            "| ♠ ♠ |",
            "|  ♠  |",
            "| ♠ ♠ |",
            "|____S|")
            , String.join(newline,
            " _____",
            "|6    |",
            "| ♠ ♠ |",
            "| ♠ ♠ |",
            "| ♠ ♠ |",
            "|____9|")
            , String.join(newline,
            " _____",
            "|7    |",
            "| ♠ ♠ |",
            "|♠ ♠ ♠|",
            "| ♠ ♠ |",
            "|____L|")
            , String.join(newline,
            " _____",
            "|8    |",
            "|♠ ♠ ♠|",
            "| ♠ ♠ |",
            "|♠ ♠ ♠|",
            "|____8|")
            , String.join(newline,
            " _____",
            "|9    |",
            "|♠ ♠ ♠|",
            "|♠ ♠ ♠|",
            "|♠ ♠ ♠|",
            "|____6|")
            , String.join(newline,
            " _____",
            "|10 ♠ |",
            "|♠ ♠ ♠|",
            "|♠ ♠ ♠|",
            "|♠ ♠ ♠|",
            "|___0I|")
            , String.join(newline,
            " _____",
            "|J♠ ww|",
            "|   {)|",
            "|(♠)% |",
            "| ♠ % |",
            "|__%%[|")
            , String.join(newline,
            " _____",
            "|Q♠   |",
            "|   {(|",
            "|(♠)%%|",
            "| ♠%%%|",
            "|_%%%Ò|")
            , String.join(newline,
            " _____",
            "|K♠ ww|",
            "|   {)|",
            "|(♠)%%|",
            "| ♠%%%|",
            "|_%%%>|"),
            String.join(newline,
                    " _____",
                    "|A♠.  |",
                    "| /.\\ |",
                    "|(_._)|",
                    "|  |  |",
                    "|___♠V|")
    };
}
