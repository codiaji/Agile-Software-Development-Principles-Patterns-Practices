package io.motassadderoon;

public class Main {
    public static void main(String[] args) {
        for (int i: GeneratePrimes.generatePrimes(100)) {
            System.out.print(i + " ");
        }
    }
}