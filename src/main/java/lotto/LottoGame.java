package lotto;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    List<Lotto> lottoList = new ArrayList<>();
    WinningNumbers winningNumbers;

    public void play() {
        int numberOfLotto = calculateNumberOfLotto();
        System.out.println(numberOfLotto);
        createLottoSet(numberOfLotto);
        OutputView.printLottoSet(lottoList);

        Lotto winningNumber = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(winningNumber);
        winningNumbers = new WinningNumbers(winningNumber, bonusNumber);


    }

    private int calculateNumberOfLotto() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        return (int) purchaseAmount / LOTTO_PRICE;
    }

    private void createLottoSet(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            lottoList.add(InputView.inputLottoNumbers());
        }
    }


}
