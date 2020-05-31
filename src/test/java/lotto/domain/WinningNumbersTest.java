package lotto.domain;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @DisplayName("당첨로또 번호가 제대로 생성되지 않을 경우 예외 발생")
    @ParameterizedTest
    @EmptySource
    public void constructWithInvalidWinningNumbers(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> {
            final int bonusNumber = 10;
            WinningNumbers winningLotto = WinningNumbers.of(lottoNumbers, bonusNumber);
        }).isInstanceOf(InvalidWinningLottoException.class);
    }

    @DisplayName("낱개 Lotto와 당첨 결과 매치 개수 확인 : 1등")
    @Test
    public void calculateFirstMatchesWithLotto() {
        final List<Integer> lottoNumbers = Lists.newArrayList(
                1, 11, 15, 21, 23, 40
        );
        final int bonusNumber = 10;
        WinningNumbers winningNumbers = WinningNumbers.of(lottoNumbers, bonusNumber);

        final Lotto lotto = LottoFactory.create(Lists.newArrayList(
                1, 11, 15, 21, 23, 40
        ));

        LottoRank lottoRank = winningNumbers.calculateMatchResult(lotto);
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("낱개 Lotto와 당첨 결과 매치 개수 확인 : 2등")
    @Test
    public void calculateSecondMatchesWithLotto() {
        final List<Integer> lottoNumbers = Lists.newArrayList(
                1, 11, 15, 21, 23, 40
        );
        final int bonusNumber = 10;
        WinningNumbers winningNumbers = WinningNumbers.of(lottoNumbers, bonusNumber);

        final Lotto lotto = LottoFactory.create(Lists.newArrayList(
                1, 10, 15, 21, 23, 40
        ));

        LottoRank lottoRank = winningNumbers.calculateMatchResult(lotto);
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("낱개 Lotto와 당첨 결과 매치 개수 확인 : 3등")
    @Test
    public void calculateThirdMatchesWithLotto() {
        final List<Integer> lottoNumbers = Lists.newArrayList(
                1, 11, 15, 21, 23, 40
        );
        final int bonusNumber = 10;
        WinningNumbers winningNumbers = WinningNumbers.of(lottoNumbers, bonusNumber);

        final Lotto lotto = LottoFactory.create(Lists.newArrayList(
                2, 11, 15, 21, 23, 40
        ));

        LottoRank lottoRank = winningNumbers.calculateMatchResult(lotto);
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("낱개 Lotto와 당첨 결과 매치 개수 확인 : 4등")
    @Test
    public void calculateFourthMatchesWithLotto() {
        final List<Integer> lottoNumbers = Lists.newArrayList(
                1, 11, 15, 21, 23, 40
        );
        final int bonusNumber = 10;
        WinningNumbers winningNumbers = WinningNumbers.of(lottoNumbers, bonusNumber);

        final Lotto lotto = LottoFactory.create(Lists.newArrayList(
                2, 12, 15, 21, 23, 40
        ));

        LottoRank lottoRank = winningNumbers.calculateMatchResult(lotto);
        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("낱개 Lotto와 당첨 결과 매치 개수 확인 : 5등")
    @Test
    public void calculateFifthMatchesWithLotto() {
        final List<Integer> lottoNumbers = Lists.newArrayList(
                1, 11, 15, 21, 23, 40
        );
        final int bonusNumber = 10;
        WinningNumbers winningNumbers = WinningNumbers.of(lottoNumbers, bonusNumber);

        final Lotto lotto = LottoFactory.create(Lists.newArrayList(
                2, 12, 16, 21, 23, 40
        ));

        LottoRank lottoRank = winningNumbers.calculateMatchResult(lotto);
        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }

}