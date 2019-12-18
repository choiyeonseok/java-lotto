package lotto;

import view.InputView;
import view.OutputView;

import java.util.*;

public class LottoApplication {
    private static final int UNIT_AMOUNT = 1000;
    private static final int PERCENTAGE = 100;

    public static void main(String[] args) {

        double purchaseAmount = InputView.inputPurchaseAmount();
        int numberOfSet = (int)purchaseAmount / UNIT_AMOUNT;

        List<Lotto> lottoSet = new ArrayList<>();
        for (int i = 0; i < numberOfSet; i++){
            lottoSet.add(InputView.inputLottoNumbers());
        }

        OutputView.printLottoSet(numberOfSet, lottoSet);


        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);



        Map<WinningResult, Integer> result = new HashMap<>();
        for (WinningResult rank : WinningResult.values()) {
            result.put(rank, 0);
        }

        WinningResult winningResult;
        for (Lotto lotto : lottoSet) {
            winningResult = winningLotto.match(lotto);
            result.put(winningResult, result.get(winningResult) + 1);
        }
        OutputView.printResults(result);

        double earningRate = 0;
        for (WinningResult  rank : result.keySet()) {
            earningRate += (double)(rank.getWinningMoney()) * result.get(rank) / (numberOfSet * UNIT_AMOUNT) * PERCENTAGE;
        }
        OutputView.printEarningRate(earningRate);


    }
}
