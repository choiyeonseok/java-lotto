package view;

import lotto.Lotto;

import java.util.List;

public class OutputView {
    public static void printLottoSet(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }
}
