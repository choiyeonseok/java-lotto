package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner;

    public static int inputPurchaseAmount() {
        scanner = new Scanner(System.in);
        System.out.println("# 구입 금액을 입력해 주세요");
        try {
            int amount = scanner.nextInt();
            verifyAmount(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println("1000원 이상의 금액을 입력해주세요. ");
        } catch (Exception e) {
            System.out.println("숫자를 입력해주세요. ");
        }
        return inputPurchaseAmount();
    }

    public static void verifyAmount(int amount){
        if (amount < 1000) {
            throw new IllegalArgumentException();
        }
    }


}
