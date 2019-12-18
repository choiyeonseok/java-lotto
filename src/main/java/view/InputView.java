package view;

import java.util.Scanner;

public class InputView {
    private static final double UNIT_AMOUNT = 1000;
    private static Scanner scanner;

    public static double inputPurchaseAmount() {
        scanner = new Scanner(System.in);
        System.out.println("구입 금액을 입력해 주세요.");
        double amount = 0;
        try{
            amount = scanner.nextInt();
            verifyPurchaseAmount(amount);
            return amount;
        } catch (Exception e){
            OutputView.invalidMessage();
            return inputPurchaseAmount();
        }
    }

    public static void verifyPurchaseAmount(double amount) throws Exception {
        if (amount < UNIT_AMOUNT){
            throw new Exception();
        }
    }

}
