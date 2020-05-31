package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @DisplayName("rank 반환 확인")
    @ParameterizedTest
    @CsvSource({"FIRST,6,false","SECOND,5,true","THIRD,5,false","FOURTH,4,false","FIFTH,3,false"})
    public void of(LottoRank rank, int winningMatches, boolean bonusMatch) {
        assertThat(LottoRank.of(winningMatches, bonusMatch)).isEqualTo(rank);
    }

}