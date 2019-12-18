package view;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final int UNIT_AMOUNT = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;

    private static Scanner scanner;

    public static double inputPurchaseAmount() {
        scanner = new Scanner(System.in);
        System.out.println("구입 금액을 입력해 주세요.");
        double amount = 0;
        try {
            amount = scanner.nextInt();
            verifyPurchaseAmount(amount);
            return amount;
        } catch (Exception e) {
            OutputView.invalidMessage();
            return inputPurchaseAmount();
        }
    }

    public static void verifyPurchaseAmount(double amount) throws Exception {
        if (amount < UNIT_AMOUNT) {
            throw new Exception();
        }
    }

    public static Lotto inputLottoNumbers() {
        scanner = new Scanner(System.in);
        System.out.println("6개의 로또 번호를 입력해주세요");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            try {
                int number = scanner.nextInt();
                verifyLottoNumber(numbers, number);
                numbers.add(number);
            } catch (Exception e) {
                OutputView.invalidMessage();
                return inputLottoNumbers();
            }
        }
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public static List<Integer> inputWinningNumbers() {
        scanner = new Scanner(System.in);
        System.out.println("금주의 당첨 번호를 입력해주세요");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            try {
                int number = scanner.nextInt();
                verifyLottoNumber(numbers, number);
                numbers.add(number);
            } catch (Exception e) {
                OutputView.invalidMessage();
                return inputWinningNumbers();
            }
        }
        Collections.sort(numbers);
        return numbers;
    }

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        scanner = new Scanner(System.in);
        System.out.println("보너스 번호를 입력해주세요");
        try {
            int number = scanner.nextInt();
            verifyLottoNumber(winningNumbers, number);
            return number;
        } catch (Exception e) {
            OutputView.invalidMessage();
            return inputBonusNumber(winningNumbers);
        }
    }

    private static void verifyLottoNumber(List<Integer> numbers, int number) throws Exception {
        if (number < LOTTO_MIN | number > LOTTO_MAX | numbers.contains(number)) {
            throw new Exception();
        }
    }
}
