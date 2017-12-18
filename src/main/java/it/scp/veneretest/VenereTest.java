package it.scp.veneretest;

import java.util.*;

public class VenereTest {

    public static void main(String[] args) {
        new VenereTest().startTests();
    }

    private void startTests() {
        testStringEquals();
        testAdiancency();
        testMaxAdiancency();
//        testPangrams();
        testParentAndChild();
        testRecursion();
    }

    private void testRecursion() {
        System.out.printf("%d ", fun(2));
    }

    private void testParentAndChild() {
        Parent p = new Child();
        p.method2();
    }

    private void testPangrams() {
        Map<Character, Integer> occurrences = new HashMap<>();
        initOccurences(occurrences);
        System.out.println("Write a pangram: ");
        Scanner scanner = new Scanner(System.in);
        String readedString = scanner.nextLine();
        readedString = readedString.toUpperCase();

        for (int i = 0; i < readedString.length(); i++) {
            if (occurrences.containsKey(readedString.charAt(i))) {
                occurrences.put(readedString.charAt(i), (occurrences.get(readedString.charAt(i)) + 1));
            }
        }

        showOccurrences(occurrences);
        System.out.println("The sentence is a Pangram ? "  + isPangram(occurrences));

    }

    private void showOccurrences(Map<Character, Integer> occurrences) {
        for (Character c : occurrences.keySet()) {
            System.out.println("Char " + c + " present " + occurrences.get(c) + " times");
        }
    }

    private boolean isPangram(Map<Character, Integer> occurrences) {
        boolean isPangram = true;
        for (Character c : occurrences.keySet()) {
            if (occurrences.get(c) == 0) {
                isPangram = false;
                break;
            }
        }
        return isPangram;
    }

    private void initOccurences(Map<Character, Integer> occurrences) {
        char c = 'A';
        for (int i = 0; i <= 25; i++)
            occurrences.put((char)(c + i), 0);
    }

    private void testMaxAdiancency() {
        int[] coins = new int[1000];
        coins = populateCoins(coins);
        showCoins(coins);
        calculateMaxAdiancency(coins);
        calculateMaxAdiancency2(coins);

    }

    private void calculateMaxAdiancency2(int[] coins) {
        long start = System.currentTimeMillis();

        int maxAdiacency = 0;
        int coinToRevert = -1;

        for (int i = 1; i < coins.length - 1; i++) {
            if ((coins[i - 1] == coins[i + 1]) && (coins[i] != coins[i-1])) {
                coins[i] = revertCoin(coins[i]);
                maxAdiacency = calculateAdiancency(coins);
                coinToRevert = i + 1;
                break;
            }
        }

        if (maxAdiacency == 0) {
            if (coins[0] != coins[1]) {
                coins[0] = revertCoin(coins[0]);
                maxAdiacency = calculateAdiancency(coins);
                coinToRevert = 1;
            } else if (coins[coins.length - 1] != coins[coins.length - 2]) {
                coins[coins.length - 1] = revertCoin(coins[coins.length - 1]);
                maxAdiacency = calculateAdiancency(coins);
                coinToRevert = coins.length;
            }
        }

        if (maxAdiacency == 0) {
            maxAdiacency = calculateAdiancency(coins);
            coinToRevert = -1;
        }

        long end = System.currentTimeMillis();

        long elapsedMilliSeconds = (end - start);

        System.out.println("2) The max adiacency is " + maxAdiacency + " reverting " + (coinToRevert == -1 ? " no  coin" : " coin " + coinToRevert + ". Elapsed time: " + elapsedMilliSeconds));
    }

    private void calculateMaxAdiancency(int[] coins) {
        long start = System.currentTimeMillis();
        int maxAdiacency = calculateAdiancency(coins);
        int coinToRevert = -1;

        for (int i = 0; i < coins.length; i++) {
            coins[i] = revertCoin(coins[i]);
            int actualMaxAdiacency = calculateAdiancency(coins);

            if (actualMaxAdiacency > maxAdiacency) {
                maxAdiacency = actualMaxAdiacency;
                coinToRevert = (i + 1);
            }
            // rimetto a posto la moneta
            coins[i] = revertCoin(coins[i]);
        }

        long end = System.currentTimeMillis();

        long elapsedSeconds = (end - start);

        System.out.println("1) The max adiacency is " + maxAdiacency + " reverting " + (coinToRevert == -1 ? " no  coin" : " coin " + coinToRevert + ". Elapsed time: " + elapsedSeconds));
    }

    private int revertCoin(int coin) {
        return ((coin + 1) % 2);
    }

    private void testAdiancency() {
        int[] coins = new int[7];
        coins = populateCoins(coins);
        showCoins(coins);
        System.out.println("Adiancency: " + calculateAdiancency(coins));
    }

    private int calculateAdiancency(int[] coins) {
        int adiacency = 0;
        for (int i = 0; i < coins.length - 1; i++) {
            if (coins[i] == coins[i + 1]) {
                adiacency++;
            }
        }
        return adiacency;
    }

    private void showCoins(int[] coins) {
        System.out.println("Coins : " + Arrays.toString(coins));
    }

    private int[] populateCoins(int[] coins) {
        for (int i = 0; i < coins.length; i++) {
            coins[i] = getRandomFace();
        }

        return coins;
    }

    private int getRandomFace() {
        Random r = new Random();
        return r.nextInt(10) % 2;
    }

    private void testStringEquals() {
        String s1 = "abc";
        String s2 = "abc";

        System.out.println("S1 = S2 ? " + (s1 == s2));
    }

    int fun(int n) {
        if (n == 4)
            return n;
        else return 2*fun(n+1);
    }


    class Parent {
        private void method1() {
            System.out.println("Parent's method1()");
        }

        public void method2() {
            System.out.println("Parent's method2()");
            method1();
        }
    }

    class Child extends Parent {
        public void method1() {
            System.out.println("Child's method1()");
        }
    }

}
