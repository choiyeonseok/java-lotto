package lotto;

import domain.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @BeforeAll
    static void setUp() {
        String[] winningNumbers = {"1", "2", "3", "5", "4", "6"};
        String bonusNumber = "7";
        WinningNumber.inputWinningNumbers(winningNumbers);
        WinningNumber.inputBonusNumber(bonusNumber);

        String[] inputLottoNumbers = {"1", "2", "3", "4", "5", "7"};
        Lotto lotto = LottoFactory.createOneManualLotto(inputLottoNumbers);
        Lottos.addLotto(lotto);
    }

    @Test
    void 로또_결과의_초기값_확인() {
        assertThat(LottoResult.getSize()).isEqualTo(5);
        for (LottoRank rank : LottoRank.values()) {
            assertThat(LottoResult.getRankCount(rank)).isEqualTo(0);
        }
    }

    @Test
    void 당첨결과_누적_테스트() {
        LottoResult.countWinningLotto();
        assertThat(LottoResult.getRankCount(LottoRank.SECOND)).isEqualTo(1);
    }

    @Test
    void 총_수익_계산_테스트() {
        LottoResult.countWinningLotto();
        int totalProfit = LottoResult.calculateTotalProfit();
        assertThat(totalProfit).isEqualTo(30_000_000);
    }
}
