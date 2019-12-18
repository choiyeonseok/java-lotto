package view;

import lotto.Lotto;
import lotto.WinningLotto;
import lotto.WinningResult;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    public static void printResults(Map<WinningResult, Integer> result) {
        System.out.println("당첨 통계 \n -----------");
        for (int i = WinningResult.values().length - 1; i >= 0; i--) {
            WinningResult.values()[i].printMessage(result.get(WinningResult.values()[i]));
        }
    }

    public static void printEarningRate(double earningRate) {
        System.out.println("총 수익률은 " + String.format("%.3f", earningRate) + "%입니다.");
    }
}
