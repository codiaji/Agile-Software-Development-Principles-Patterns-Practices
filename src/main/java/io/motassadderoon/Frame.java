package io.motassadderoon;

public class Frame {
    private int score;

    public int score() {
        return score;
    }

    public void add(int pins) {
        score += pins;
    }
}
