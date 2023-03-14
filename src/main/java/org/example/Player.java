package org.example;

public class Player {
    private final String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public void gainScore() {
        this.score += 5;
    }

    public void looseScore() {
        this.score -= 1;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return this.score;
    }

    public String toString() {
        return "Name: " + name + System.getProperty("line.separator") + "Score: " + score;
    }
}
