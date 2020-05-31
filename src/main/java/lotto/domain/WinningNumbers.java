package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningNumbers(final List<LottoNumber> lottoNumbers, final int bonusNumber) {
        if (lottoNumbers.isEmpty()) {
            throw new InvalidWinningLottoException();
        }
        this.winningLotto = Lotto.from(lottoNumbers);
        this.bonusNumber = LottoNumber.from(bonusNumber);
    }

    public static WinningNumbers of(final List<LottoNumber> lottoNumbers, final int bonusNumber) {
        return new WinningNumbers(lottoNumbers, bonusNumber);
    }

    public LottoRank calculateMatchResult(final Lotto lotto) {
        final int winningNumberMatches = lotto.getMatchCount(winningLotto);
        final boolean bonusNumberMatch = lotto.hasBonusNumber(bonusNumber);

        return LottoRank.of(winningNumberMatches, bonusNumberMatch);
    }
}
