package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class LottoGame {

    private static final int START_INDEX = 0;

    public void play() {
        Money money = inputPurchaseAmountWithValidation();
        LottoCount lottoCount = inputLottoCountWithValidation(money);

        Lottos lottos = buyTotalLottosWithValidation(lottoCount);
        OutputView.printLottos(lottoCount, lottos);
        WinningNumber winningNumber = inputWinningNumberWithValidation();

        LottoResult lottoResult = new LottoResult(lottos, winningNumber);
        OutputView.printResult(lottoResult);
        OutputView.printProfitRatio(money.calculateProfitRatio(lottoResult));
    }

    private Lottos buyTotalLottosWithValidation(LottoCount lottoCount) {
        try {
            List<int[]> manualLottoInputs = new ArrayList<>();
            for (int index = START_INDEX; index < lottoCount.getManualCount(); index++) {
                manualLottoInputs.add(InputView.inputManualLottoNumbers());
            }
            return LottoMachine.buyLottos(manualLottoInputs, lottoCount);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return buyTotalLottosWithValidation(lottoCount);
        }
    }

    private static LottoCount inputLottoCountWithValidation(Money money) {
        try {
            return new LottoCount(money.getLottoCount(), InputView.inputManualCount());
        } catch (IllegalArgumentException | NullPointerException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputLottoCountWithValidation(money);
        }
    }

    private static Money inputPurchaseAmountWithValidation() {
        try {
            return new Money(InputView.inputPurchaseAmount());
        } catch (IllegalArgumentException | NullPointerException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputPurchaseAmountWithValidation();
        }
    }

    private static WinningNumber inputWinningNumberWithValidation() {
        try {
            return new WinningNumber(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
        } catch (IllegalArgumentException | NullPointerException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputWinningNumberWithValidation();
        }
    }
}
