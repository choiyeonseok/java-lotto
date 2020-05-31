package lotto.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {
    private Lottos lottos;
    private WinningNumbers winningNumbers;

    @BeforeEach
    public void setUp() {
        lottos = new Lottos(Lists.newArrayList(
                LottoFactory.create(Lists.newArrayList(
                        LottoNumber.from(1), LottoNumber.from(11),
                        LottoNumber.from(15), LottoNumber.from(21),
                        LottoNumber.from(23), LottoNumber.from(40)
                )), // first, 200_000_000
                LottoFactory.create(Lists.newArrayList(
                        LottoNumber.from(1), LottoNumber.from(10),
                        LottoNumber.from(15), LottoNumber.from(21),
                        LottoNumber.from(23), LottoNumber.from(40)
                )), // second, 30_000_000
                LottoFactory.create(Lists.newArrayList(
                        LottoNumber.from(1), LottoNumber.from(11),
                        LottoNumber.from(16), LottoNumber.from(22),
                        LottoNumber.from(23), LottoNumber.from(40)
                )) // fourth, 1_000_000
        ));

        winningNumbers = WinningNumbers.of(
                Lists.newArrayList(
                        LottoNumber.from(1), LottoNumber.from(11),
                        LottoNumber.from(15), LottoNumber.from(21),
                        LottoNumber.from(23), LottoNumber.from(40)
                ), 10
        );
    }

    @DisplayName("Lottos 생성")
    @Test
    public void construct() {
        Lottos lottos = new Lottos(Lists.newArrayList(
                LottoFactory.create(),
                LottoFactory.create(),
                LottoFactory.create()
        ));
        assertThat(lottos.count()).isEqualTo(3);
    }

    @DisplayName("LottoResult 생성")
    @Test
    public void calculateResult() {
        LottoResult result = lottos.calculateResult(winningNumbers);
        assertThat(result).isNotNull();
    }

}