package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printPurchasedLottos(final List<Lotto> lottos) {
        System.out.println("구매하신 로또 목록은 다음과 같습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public static void printLottoResult(final Map<LottoRank, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("-----------------");
        System.out.println(String.format("3개 일치 (5000원) - %d개", result.get(LottoRank.FIFTH)));
        System.out.println(String.format("4개 일치 (50000원) - %d개", result.get(LottoRank.FOURTH)));
        System.out.println(String.format("5개 일치 (1000000원) - %d개", result.get(LottoRank.THIRD)));
        System.out.println(String.format("5개 일치 (30000000원) - %d개", result.get(LottoRank.SECOND)));
        System.out.println(String.format("6개 일치 (200000000원) - %d개", result.get(LottoRank.FIRST)));
    }

    public static void printTotalProfit(final double profit) {
        System.out.println(String.format("총 수익률은 %d%%입니다.", (int)profit * 100));
    }
}
