package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.domain.LottoResult.LOTTO_PRICE;

public class LottoController {

    public void play() {
        final int amount = InputView.inputLottoAmount();
        final int autoLottoCount = InputView.inputAutoLottoCount();

        final Lottos lottos = createLottos(amount, autoLottoCount);
        OutputView.printPurchasedLottos(lottos.getLottos());

        final WinningNumbers winningNumbers = createWinningNumbers();

        final LottoResult result = lottos.calculateResult(winningNumbers);
        OutputView.printLottoResult(result.getResult());
        OutputView.printTotalProfit(result.calculateProfit(amount / LOTTO_PRICE));
    }

    private WinningNumbers createWinningNumbers() {
        try {
            return WinningNumbers.of(
                    InputView.inputWinningNumber(), InputView.inputBonusNumber());
        } catch (IllegalArgumentException e) {
            return createWinningNumbers();
        }
    }

    private Lottos createLottos(final int amount, final int autoLottoCount) {
        try {
            List<Lotto> lottos = new ArrayList<>();
            IntStream.range(0, autoLottoCount)
                    .forEach(i -> lottos.add(LottoFactory.create()));

            IntStream.range(0, (amount / LOTTO_PRICE) - autoLottoCount)
                    .forEach(i -> {
                        lottos.add(LottoFactory.create(
                                InputView.inputLottoNumbers()
                        ));
                    });
            return new Lottos(lottos);
        } catch (IllegalArgumentException e) {
            return createLottos(amount, autoLottoCount);
        }
    }
}
