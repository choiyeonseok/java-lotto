package lotto;

import view.InputView;
import view.OutputView;

import java.util.*;

public class LottoApplication {
    private static final int UNIT_AMOUNT = 1000;
    private static final int PERCENTAGE = 100;

    public static void main(String[] args) {

        /** 1. 구매 금액 입력 */
        double purchaseAmount = InputView.inputPurchaseAmount();
        int numberOfSet = (int)purchaseAmount / UNIT_AMOUNT;

        /** 2. 로또 번호 입력 */
        List<Lotto> lottoSet = new ArrayList<>();
        for (int i = 0; i < numberOfSet; i++){
            lottoSet.add(InputView.inputLottoNumbers());
        }
        OutputView.printLottoSet(numberOfSet, lottoSet);

        /** 3. 금주 당첨 번호 입력 */
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        /** 4. 결과출력을 위한 초기화 */
        Map<WinningResult, Integer> result = new HashMap<>();
        for (WinningResult rank : WinningResult.values()) {
            result.put(rank, 0);
        }

        /** 5. 당첨 결과 계산 및 출력 */
        WinningResult winningResult;
        for (Lotto lotto : lottoSet) {
            winningResult = winningLotto.match(lotto);
            result.put(winningResult, result.get(winningResult) + 1);
        }
        OutputView.printResults(result);

        /** 6. 수익률 계산 및 출력 */
        double earningRate = 0;
        for (WinningResult  rank : result.keySet()) {
            earningRate += (double)(rank.getWinningMoney()) * result.get(rank) / (numberOfSet * UNIT_AMOUNT) * PERCENTAGE;
        }
        OutputView.printEarningRate(earningRate);
    }
}
