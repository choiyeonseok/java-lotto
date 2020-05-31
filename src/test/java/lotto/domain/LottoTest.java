package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.InvalidPropertiesFormatException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

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
}
