package io.motassadderoon;

public class GeneratePrimes {
    private static boolean[] crossedOut;
    private static int[] result;

    public static int[] generatePrimes(int maxValue) {
        if (maxValue < 2)
            return new int[0];
        else {
            crossOutIntegersUpTo(maxValue);
            uncrossMultiples();
            putCrossedOutIntegersIntoResult();
            return result;
        }
    }


    private static void crossOutIntegersUpTo(int maxValue) {
        crossedOut = new boolean[maxValue + 1];
        for (int i = 2; i < crossedOut.length; i++)
            crossedOut[i] = true;

    }

    private static void uncrossMultiples() {
        int i;
        for (i = 2; i < determineIterationLimit(); i++) {
            uncrossMultiplesOf(i);
        }
    }

    private static int determineIterationLimit() {
        return (int) Math.sqrt(crossedOut.length);
    }

    private static void uncrossMultiplesOf(int i) {
        int multiple;
        if (isCrossed(i)) {
            for (multiple = 2 * i; multiple < crossedOut.length; multiple += i)
                uncross(multiple);
        }
    }

    private static void uncross(int i) {
        crossedOut[i] = false;
    }

    private static void putCrossedOutIntegersIntoResult() {
        result = new int[getCountOfPrimes()];
        int j;
        int i;
        for (i = 0, j = 0; i < crossedOut.length; i++) {
            if (isCrossed(i))
                result[j++] = i;
        }
    }

    private static int getCountOfPrimes() {
        int i;
        int countOfPrimes = 0;
        for (i = 0; i < crossedOut.length; i++) {
            if (isCrossed(i))
                countOfPrimes++; // bump count.
        }
        return countOfPrimes;
    }

    private static boolean isCrossed(int i) {
        return crossedOut[i];
    }
}