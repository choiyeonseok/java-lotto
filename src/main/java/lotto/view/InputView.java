package lotto.view;

import com.google.common.collect.Lists;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputLottoAmount() {
        System.out.println("로또 구매 금액을 입력해주세요.");
        try {
            return SCANNER.nextInt();
        } catch (NumberFormatException e) {
            return inputLottoAmount();
        }
    }

    public static int inputAutoLottoCount() {
        System.out.println("자동으로 구매하실 로또의 개수를 입력해주세요.");
        try {
            return SCANNER.nextInt();
        } catch (NumberFormatException e) {
            return inputAutoLottoCount();
        }
    }

    public static List<Integer> inputLottoNumbers() {
        System.out.println("수동으로 구매할 로또 번호를 입력해주세요.");
        String[] inputs = SCANNER.nextLine().split(",");
        try {
            return Arrays.stream(inputs)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            return inputLottoNumbers();
        }
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println("이번 주 당첨 번호를 입력해주세요.");
        String[] inputs = SCANNER.nextLine().split(",");
        try {
            return Arrays.stream(inputs)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            return inputWinningNumber();
        }
    }

    public static int inputBonusNumber() {
        System.out.println("이번 주 보너스 번호를 입력해주세요.");
        try {
            return SCANNER.nextInt();
        } catch (NumberFormatException e) {
            return inputBonusNumber();
        }
    }
}
