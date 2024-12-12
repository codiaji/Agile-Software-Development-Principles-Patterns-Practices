package io.motassadderoon;

public class GeneratePrimes
{
    public static int[] generatePrimes(int maxValue)
    {
        if (maxValue >= 2)
        {
            int countOfValues = maxValue + 1;

            boolean[] crossedPrimeNumbersList = crossPrimeNumbersFromAList(countOfValues);

            return getPrimeNumbers(countOfValues, crossedPrimeNumbersList);
        }
        else
            return new int[0];
    }

    private static int[] getPrimeNumbers(int countOfValues, boolean[] isPrimeNumbersList) {
        int countOfPrimeNumbers = getCountOfPrimeNumbers(countOfValues, isPrimeNumbersList);

        return getPrimesFromIsPrimeList(countOfValues, countOfPrimeNumbers, isPrimeNumbersList);

    }

    private static int[] getPrimesFromIsPrimeList(int countOfValues, int countOfPrimeNumbers, boolean[] isPrimeNumbersList) {
        int i;
        int j;
        int[] primes = new int[countOfPrimeNumbers];
        for (i = 0, j = 0; i < countOfValues; i++)
        {
            if (isPrimeNumbersList[i])
                primes[j++] = i;
        }
        return primes;
    }

    private static int getCountOfPrimeNumbers(int s, boolean[] isPrimeNumbersList) {
        int countOfPrimeNumbers = 0;
        int i;
        for (i = 0; i < s; i++)
        {
            if (isPrimeNumbersList[i])
                countOfPrimeNumbers++;
        }
        return countOfPrimeNumbers;
    }

    private static boolean[] crossPrimeNumbersFromAList(int countOfValues) {
        boolean[] isPrimeNumbersList = new boolean[countOfValues];
        int i;
        for (i = 0; i < countOfValues; i++)
            isPrimeNumbersList[i] = true;
        isPrimeNumbersList[0] = isPrimeNumbersList[1] = false;

        int j;
        double squareRootOfValues = Math.sqrt(countOfValues);
        for (i = 2; i < squareRootOfValues + 1; i++)
        {
            if (isPrimeNumbersList[i])
            {
                for (j = 2 * i; j < countOfValues; j += i)
                    isPrimeNumbersList[j] = false;
            }
        }
        return isPrimeNumbersList;
    }
}