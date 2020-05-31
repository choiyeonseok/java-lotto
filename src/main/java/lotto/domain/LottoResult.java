package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    public static final int LOTTO_PRICE = 1_000;

    private final Map<LottoRank, Integer> result = new HashMap<LottoRank, Integer>(){{
       put(LottoRank.FIRST, 0);
       put(LottoRank.SECOND, 0);
       put(LottoRank.THIRD, 0);
       put(LottoRank.FOURTH, 0);
       put(LottoRank.FIFTH, 0);
    }};

    public LottoResult(final List<LottoRank> ranks) {
        ranks.forEach(rank ->
           result.put(rank, result.getOrDefault(rank, 0) + 1)
        );
    }

    public double calculateProfit(final int count) {
        return (double) (result.keySet().stream()
                .mapToLong(LottoRank::getWinningMoney)
                .sum() / (count * LOTTO_PRICE));
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }
}
