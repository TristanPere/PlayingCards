package org.example;

public class Player {
    private String name;
    private int score;

    public void setScore() {
        this.score += 100;
    }

    public String getName() {
        return name;
    }

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String toString() {
        return "Name: " + name + System.getProperty("line.separator") + "Score: " + score;
    }
}
