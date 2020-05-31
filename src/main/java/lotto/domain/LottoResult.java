package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int LOTTO_PRICE = 1_000;

    private final Map<LottoRank, Long> result = new HashMap<>();

    public LottoResult(final List<LottoRank> ranks) {
        ranks.forEach(rank ->
           result.put(rank, result.getOrDefault(rank, 0L) + rank.getWinningMoney())
        );
    }

    public double calculateProfit(final int count) {
        return (double) (result.values().stream()

                .mapToLong(m -> m)
                .sum() / (count * LOTTO_PRICE));
    }
}
