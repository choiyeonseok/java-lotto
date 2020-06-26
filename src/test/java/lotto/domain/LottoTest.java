package lotto.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 번호가 중복될 경우 예외 발생")
    @Test
    void duplicationLottoNumber() {
        assertThatThrownBy(() -> {
            Lotto lotto = Lotto.from(Arrays.asList(
                    LottoNumber.from(1),
                    LottoNumber.from(2),
                    LottoNumber.from(3),
                    LottoNumber.from(4),
                    LottoNumber.from(5),
                    LottoNumber.from(5)
            ));
        }).isInstanceOf(DuplicatedLottoNumberException.class);
    }

    @DisplayName("로또가 정상적으로 만들어지지 않을 경우 예외 발생")
    @Test
    public void constructWithInvalidAttributes() {
        assertThatThrownBy(() -> {
            Lotto lotto = Lotto.from(Arrays.asList(
                    LottoNumber.from(1),
                    LottoNumber.from(2)
            ));
        }).isInstanceOf(InvalidLottoSizeException.class);
    }

    @DisplayName("로또와 당첨 로또의 매치 갯수 확인")
    @Test
    public void getMatchCount() {
        Lotto lotto = Lotto.from(Lists.newArrayList(
                LottoNumber.from(1), LottoNumber.from(2),
                LottoNumber.from(3), LottoNumber.from(4),
                LottoNumber.from(5), LottoNumber.from(6)
        ));

        Lotto winningNumbers = Lotto.from(Lists.newArrayList(
                LottoNumber.from(1), LottoNumber.from(2),
                LottoNumber.from(30), LottoNumber.from(44),
                LottoNumber.from(5), LottoNumber.from(6)
        ));

        assertThat(lotto.getMatchCount(winningNumbers)).isEqualTo(4);
    }

    @DisplayName("로또번호가 보너스 번호를 갖고 있는지 확인")
    @Test
    public void hasBonusNumber() {
        Lotto lotto = Lotto.from(Lists.newArrayList(
                LottoNumber.from(1), LottoNumber.from(2),
                LottoNumber.from(3), LottoNumber.from(4),
                LottoNumber.from(5), LottoNumber.from(6)
        ));

        LottoNumber bonusNumber = LottoNumber.from(4);
        assertThat(lotto.hasBonusNumber(bonusNumber)).isTrue();
    }
}
