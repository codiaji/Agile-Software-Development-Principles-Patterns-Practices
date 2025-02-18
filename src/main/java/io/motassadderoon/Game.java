package io.motassadderoon;

public class Game {
    private final int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;
    private int itsCurrentFrame = 1;
    private boolean firstThrow = true;

    public void add(int pins) {
        itsThrows[itsCurrentThrow++] = pins;
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (firstThrow) {
            if (pins == 10) {
                itsCurrentFrame++;
            } else
                firstThrow = false;

        } else {
            firstThrow = true;
            itsCurrentFrame++;
        }
        itsCurrentFrame = Math.min(11, itsCurrentFrame);
    }

    public int score() {
        return scoreForFrame(getCurrentFrame() == 1 ? getCurrentFrame() : getCurrentFrame() - 1);
    }

    public int scoreForFrame(int theFrame) {
        int ball = 0;
        int score = 0;
        for (int currentFrame = 0;
             currentFrame < theFrame;
             currentFrame++) {
            int firstThrow = itsThrows[ball];
            int secondThrow = itsThrows[ball + 1];
            int thirdThrow = itsThrows[ball + 2];
            int sumOfFrameThrows = firstThrow + secondThrow;
            if (isStrike(ball)) {
                score += firstThrow + secondThrow + thirdThrow;
                ball++;
            } else {
                if (isSpare(ball)) {
                    score += sumOfFrameThrows + thirdThrow;
                } else {
                    score += sumOfFrameThrows;
                }
                ball += 2;
            }
        }
        return score;
    }

    private boolean isSpare(int ball) {
        return itsThrows[ball] + itsThrows[ball + 1] == 10;
    }

    private boolean isStrike(int ball) {
        return itsThrows[ball] == 10;
    }

    public int getCurrentFrame() {
        return itsCurrentFrame;
    }
}
