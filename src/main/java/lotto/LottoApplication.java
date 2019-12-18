package lotto;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    private static final int UNIT_AMOUNT = 1000;

    public static void main(String[] args) {

        double purchaseAmount = InputView.inputPurchaseAmount();
        int numberOfSet = (int)purchaseAmount / UNIT_AMOUNT;

        List<Lotto> lottoSet = new ArrayList<>();
        for (int i = 0; i < numberOfSet; i++){
            lottoSet.add(InputView.inputLottoNumbers());
        }

        OutputView.printLottoSet(numberOfSet, lottoSet);

    }
}
