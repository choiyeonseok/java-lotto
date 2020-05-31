package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoFactory.LOTTO_SIZE;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;


    private Lotto(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new InvalidLottoSizeException();
        }
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(final List<LottoNumber> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getMatchCount(final Lotto winningNumbers) {
        return (int)winningNumbers.getLottoNumbers().stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public boolean hasBonusNumber(final LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
