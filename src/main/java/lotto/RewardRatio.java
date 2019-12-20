package lotto;

import view.OutputView;

public class RewardRatio {

    private int totalWinningReward;
    private int winningRewardRatio;

    public void calculateRewardRatio(int numberOfLottoSet, int LOTTO_PRICE) {
        winningRewardRatio = totalWinningReward / (LOTTO_PRICE * numberOfLottoSet) * 100;
    }

    public void printLottoRewardRatio(){
        OutputView.printRewardRatio(winningRewardRatio);
    }

    public void addReward(int winningReward) {
        totalWinningReward += winningReward;
    }
}
