package domain;

import java.util.Objects;

public class WinningNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int WINNING_MATCH_COUNT_FOR_SECOND_AND_THIRD = 5;
    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public WinningNumber(final String[] winningNumbers, String bonusNumber) {
        LottoGenerator lottoGenerator = new ManualLottoGenerator(winningNumbers);
        this.winningNumbers = lottoGenerator.generateLotto();
        checkNotNumber(bonusNumber);
        bonusNumber = bonusNumber.trim();
        int bonusIntegerValue = Integer.parseInt(bonusNumber);
        checkLottoNumberRange(bonusIntegerValue);
        this.bonusNumber = AllLottoNumbers.get(bonusIntegerValue);
        checkDuplicatedLottoNumber();
    }

    public int countWinningMatch(final Lotto targetLotto) {
        Objects.requireNonNull(targetLotto);
        return winningNumbers.countMatchNumbers(targetLotto);
    }

    public boolean isBonusMatch(final Lotto targetLotto) {
        Objects.requireNonNull(targetLotto);
        return countWinningMatch(targetLotto) == WINNING_MATCH_COUNT_FOR_SECOND_AND_THIRD
                && targetLotto.contains(bonusNumber);
    }

    private void checkDuplicatedLottoNumber() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    private void checkLottoNumberRange(final int bonusIntegerValue) {
        if (bonusIntegerValue < MIN_LOTTO_NUMBER || bonusIntegerValue > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지 수여야 합니다.");
        }
    }

    private void checkNotNumber(final String number) {
        try {
            Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format("보너스 넘버는 숫자여야 합니다. 입력한 문자 : %s", number));
        }
    }
}