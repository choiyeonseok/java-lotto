package view;

import lotto.Lotto;

import java.util.*;

public class InputView {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
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

    public static void verifyAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException();
        }
    }

    public static Lotto inputLottoNumbers() {
        scanner = new Scanner(System.in);
        System.out.println("6자리 로또 번호를 입력해주세요");
        List<Integer> numbers = new ArrayList<>();
        try {
            inputPureNumbersWithSorting(numbers);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println("1부터 45까지의 수를 입력해 주세요");
        } catch (Exception e) {
            System.out.println("숫자를 입력해주세요");
        }
        return inputLottoNumbers();
    }

    private static void inputPureNumbersWithSorting(List<Integer> numbers) {
        for (int i = 0; i < LOTTO_SIZE; i++) {
            int number = scanner.nextInt();
            verifyLottoNumber(number, numbers);
            numbers.add(number);
        }
        Collections.sort(numbers);
    }

    private static void verifyLottoNumber(int number, List<Integer> numbers) {
        if (number < LOTTO_MIN | number > LOTTO_MAX) {
            throw new IllegalArgumentException();
        }
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("중복된 수 입니다. 중복 되지 않게 입력해 주세요");
        }
    }
}
