package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {
    static final int LOTTO_SIZE = 6;

    public static Lotto create() {
        final List<LottoNumber> allLottoNumbers = LottoNumber.getAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);

        return Lotto.from(allLottoNumbers.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toList()));
    }

    public static Lotto create(final List<LottoNumber> lottoNumbers) {
        return Lotto.from(lottoNumbers);
    }
}
