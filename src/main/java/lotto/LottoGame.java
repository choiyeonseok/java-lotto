package lotto;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static LottoSet lottoset;
    private WinningNumbers winningNumbers;

    public LottoGame(){
        lottoset = new LottoSet();
    }

    public void play() {
        int numberOfLotto = calculateNumberOfLotto();
        createLottoSet(numberOfLotto);
        lottoset.printLottoSet();

        createWinningNumbers();
        lottoset.calculateLottoResult(winningNumbers);
        lottoset.printLottoResult();

        lottoset.calculateRewardRatio();

    }

    private int calculateNumberOfLotto() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        return purchaseAmount / LOTTO_PRICE;
    }

    private void createLottoSet(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            lottoset.addLotto(InputView.inputLottoNumbers());
        }
    }

    private void createWinningNumbers() {
        Lotto winningNumber = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(winningNumber);
        winningNumbers = new WinningNumbers(winningNumber, bonusNumber);
    }


}
