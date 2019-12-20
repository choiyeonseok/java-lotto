package lotto;

import view.InputView;


public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static int numberOfLotto;
    private static LottoSet lottoset;
    private static RewardRatio rewardRatio;
    private WinningNumbers winningNumbers;

    public LottoGame(){
        lottoset = new LottoSet();
        rewardRatio = new RewardRatio();
    }

    public void play() {
        numberOfLotto = calculateNumberOfLotto();

        createLottoSet(numberOfLotto);
        lottoset.printLottoSet();

        createWinningNumbers();
        lottoset.calculateLottoResult(rewardRatio, winningNumbers);
        lottoset.printLottoResult();

        rewardRatio.calculateRewardRatio(numberOfLotto, LOTTO_PRICE);
        rewardRatio.printLottoRewardRatio();
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
