package lotto;

import view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoSet {
    List<Lotto> lottoList = new ArrayList<>();
    HashMap<Integer, Integer> lottoResult = new HashMap<>();
    public void printLottoSet(){
        OutputView.printLottoSet(lottoList);
    }

    public void addLotto(Lotto lotto) {
        lottoList.add(lotto);
    }

    public void calculateLottoResult(WinningNumbers winningNumbers) {
        for (Lotto lotto : lottoList) {
            calculateEachLotto(lotto, winningNumbers);
        }
    }

    private void calculateEachLotto(Lotto lotto, WinningNumbers winningNumbers) {
        int count = lotto.lottoMatchCount(winningNumbers.getWinningNumber());
        if (count >= 3) {
            lottoResult.put(count, lottoResult.getOrDefault(count, 0) + 1);
            return;
        }
        if (isSecondPlace(lotto, winningNumbers, count)){
            lottoResult.put(7, lottoResult.getOrDefault(7, 0) + 1);
        }
    }

    private boolean isSecondPlace(Lotto lotto, WinningNumbers winningNumbers, int count) {
        return count == 5 && lotto.hasNumber(winningNumbers.getBonusNumber());
    }

    public void printLottoResult(){
        OutputView.printLottoResult(lottoResult);
    }
}
