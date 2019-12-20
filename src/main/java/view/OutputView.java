package view;

import lotto.Lotto;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    public static void printLottoSet(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

    public static void printLottoResult(HashMap<Integer, Integer> lottoResult) {
        for (Integer key : lottoResult.keySet()){
            System.out.println(key + "개 맞춘 로또 수 : " + lottoResult.get(key));
        }
    }
}
