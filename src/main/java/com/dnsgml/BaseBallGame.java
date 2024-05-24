package com.dnsgml;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseBallGame {
    private String target;
    private Scanner scanner;

    public BaseBallGame() {
        this.target = NumberGenerator.generateRandomNumbers();
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("INPUT:");
        String input = scanner.next();

        String result = compareNumbers(target, input);
        System.out.println("OUTPUT: " + result);
        System.out.println("실제 값: " + target);
    }

    private String compareNumbers(String target, String input) {
        int s = 0;
        int b = 0;

        for (int i = 0; i < target.length(); i++) {
            char targetChar = target.charAt(i);
            char inputChar = input.charAt(i);

            if (targetChar == inputChar) {
                s++;
            } else if (target.contains(String.valueOf(inputChar))) {
                b++;
            }
        }

        String result = "";
        if (s > 0) {
            result += s + "S";
        }
        if (b > 0) {
            result += b + "B";
        }

        if (result.equals("")) result = "(null)";
        return result;
    }

    public static void main(String[] args) {
        BaseBallGame game = new BaseBallGame();
        game.play();
    }
}

class NumberGenerator {
    public static String generateRandomNumbers() {
        Random random = new Random();
        Set<Integer> numSet = new HashSet<>();

        while (numSet.size() < 3) {
            int num = random.nextInt(9) + 1;
            numSet.add(num);
        }

        StringBuilder result = new StringBuilder();
        for (int num : numSet) {
            result.append(num);
        }
        return result.toString();
    }
}
