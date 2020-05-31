package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("총 로또 번호가 아닌 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100})
    public void overLottoRange(int number) {
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = LottoNumber.of(number);
        }).isInstanceOf(NotLottoRangeException.class);
    }

    @DisplayName("총 로또 번호 생성 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 42, 43, 44, 45})
    public void allNumbers(int number) {
        LottoNumber lottoNumber = LottoNumber.of(number);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
    }

}