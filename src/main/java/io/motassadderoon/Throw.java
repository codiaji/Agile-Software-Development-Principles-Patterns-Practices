package io.motassadderoon;

public class Throw {
    private int countOfKnockedPins;

    public void throwBall(int countOfKnockedPins) {
        this.countOfKnockedPins += countOfKnockedPins;
    }

    public int getCountOfKnockedPins() {
        return this.countOfKnockedPins;
    }
}
