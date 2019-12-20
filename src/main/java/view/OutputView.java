package view;

import lotto.Lotto;
import lotto.Rank;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

public class OutputView {
    public static void printLottoSet(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

    public static void printLottoResult(EnumMap<Rank, Integer> lottoResult) {
        System.out.println("\n##당첨 결과");
        for (Rank key : lottoResult.keySet()){
            System.out.println(key.showResultMessage(lottoResult.get(key)));
        }
    }

    public static void printRewardRatio(double winningRewardRatio) {
        System.out.println("\n##최종 수익률");
        System.out.println("수익률은 " + winningRewardRatio + "%입니다.");
    }
}
