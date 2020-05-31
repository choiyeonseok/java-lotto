package lotto.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public enum LottoRank {
    FIRST(6, false, 200_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_000_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int winningCount;
    private final boolean bonus;
    private final long winningMoney;

    LottoRank(final int winningCount, final boolean bonus, final long winningMoney) {
        this.winningCount = winningCount;
        this.bonus = bonus;
        this.winningMoney = winningMoney;
    }

    public static LottoRank of(final int winningMatchCounts, boolean bonusMatch) {
        if (winningMatchCounts == 4 | winningMatchCounts == 3) {
            bonusMatch = false;
        }
        final boolean finalBonusMatch = bonusMatch;
        return Arrays.stream(values())
                .filter(rank -> Objects.equals(rank.winningCount, winningMatchCounts)
                        && Objects.equals(rank.bonus, finalBonusMatch))
                .findFirst()
                .orElse(NONE);
    }

    public Long getWinningMoney() {
        return winningMoney;
    }
}
