package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private List<Integer> winningNumbers;
    private int bonusNumber;


    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningResult match(Lotto lotto){
        int correctCount = lotto.countOfMatch(winningNumbers);
        boolean matchBonus = lotto.isContainNumber(bonusNumber);
        return WinningResult.valueOf(correctCount, matchBonus);
    }
}
