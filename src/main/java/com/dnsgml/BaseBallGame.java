package com.dnsgml;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseBallGame {
    public static void main(String[] args) {
        // 랜덤 숫자 생성 (중복X)
        String target = generateRandomNumbers();

        Scanner scanner = new Scanner(System.in);

        System.out.println("INPUT:");
        String input = scanner.next();

        // 숫자 비교
        String result = compareNumbers(target, input);
        System.out.println("OUTPUT: " + result);
        System.out.println("실제 값: " + target);
    }

    /**
     * 랜덤 숫자 생성 (중복X)
     * @return
     */
    public static String generateRandomNumbers() {
        Random random = new Random();
        Set<Integer> numSet = new HashSet<>();

        // 3자리 숫자 생성 (중복X)
        while (numSet.size() < 3) {
            int num = random.nextInt(9) + 1;
            numSet.add(num);
        }

        String result = "";
        for (int num : numSet) {
            result += num;
        }
        return result;
    }

    /**
     * 숫자 비교
     * @param target
     * @param input
     * @return
     */
    public static String compareNumbers(String target, String input) {
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
        return result;
    }
}
