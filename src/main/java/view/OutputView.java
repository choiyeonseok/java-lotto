package view;

import lotto.Lotto;
import lotto.Rank;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    public static void printLottoSet(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

    public static void printLottoResult(HashMap<Rank, Integer> lottoResult) {
        System.out.println("##당첨 결과");
        for (Rank key : lottoResult.keySet()){
            System.out.println(key.showResultMessage(lottoResult.get(key)));
        }
    }
}
