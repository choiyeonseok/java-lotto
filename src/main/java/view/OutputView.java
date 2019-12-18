package view;

import lotto.Lotto;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    public static void invalidMessage() {
        System.out.println("잘못된 입력입니다.");
    }

    public static void printLottoSet(int numberOfSet, List<Lotto> lottoSet) {
        System.out.println(numberOfSet + "개를 구매했습니다.");
        for (Lotto lotto : lottoSet) {
            System.out.println(lotto.toString());
        }
    }
}
