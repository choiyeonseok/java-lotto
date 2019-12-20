package lotto;

import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LottoSet {
    private List<Lotto> lottoList = new ArrayList<>();
    private HashMap<Rank, Integer> lottoResult = new HashMap<Rank, Integer>(){{
        put(Rank.FIRST, 0);
        put(Rank.SECOND, 0);
        put(Rank.THIRD, 0);
        put(Rank.FOURTH, 0);
        put(Rank.FIFTH, 0);
    }};

     public void addLotto(Lotto lotto) {
         lottoList.add(lotto);
     }

    public void printLottoSet(){
        OutputView.printLottoSet(lottoList);
    }

    public void calculateLottoResult(RewardRatio rewardRatio, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottoList) {
            Rank rank = calculateEachLotto(lotto, winningNumbers);
            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
            rewardRatio.addReward(rank.getWinningReward());
        }
    }

    private Rank calculateEachLotto(Lotto lotto, WinningNumbers winningNumbers) {
        int count = lotto.lottoMatchCount(winningNumbers.getWinningNumber());
        Rank rank = Arrays.stream(Rank.values())
                .filter(r -> r.getCountOfMatch() == count)
                .findAny()
                .get();
        if (isThirdPlace(lotto, winningNumbers, count)){
            return rank.getThirdPlaceMatch();
        }
        return rank;
    }

    private boolean isThirdPlace(Lotto lotto, WinningNumbers winningNumbers, int count) {
        return count == 5 && !lotto.hasNumber(winningNumbers.getBonusNumber());
    }

    public void printLottoResult(){
        OutputView.printLottoResult(lottoResult);
    }


}
