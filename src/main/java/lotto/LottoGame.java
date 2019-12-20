package lotto;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    public void play() {
        int numberOfLotto = calculateNumberOfLotto();
        System.out.println(numberOfLotto);
        List<Lotto> lottoList = createLottoSet(numberOfLotto);
        OutputView.printLottoSet(lottoList);
    }

    private int calculateNumberOfLotto() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        return (int) purchaseAmount / LOTTO_PRICE;
    }

    private List<Lotto> createLottoSet(int numberOfLotto) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            lottoList.add(InputView.inputLottoNumbers());
        }
        return lottoList;
    }


}
