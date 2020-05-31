package lotto.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @DisplayName("자동 로또 생성")
    @Test
    public void autoCreate() {
        Lotto lotto = LottoFactory.create();
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @DisplayName("수동 로또 생성")
    @Test
    public void manualCreate() {
        final List<Integer> lottoNumbers =
                Lists.newArrayList(Arrays.asList(
                        1, 11, 15, 21, 23, 40
                ));
        Lotto lotto = LottoFactory.create(lottoNumbers);
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

}