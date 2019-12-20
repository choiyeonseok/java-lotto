package lotto;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치(2000000000원) - "),
    SECOND(5, 300_000_000, "5개 일치, 보너스볼 일치(300000000원) - "),
    THIRD(5, 1_500_000, "5개 일치(1500000원) - "),
    FOURTH(4, 50_000, "4개 일치(50000원) - "),
    FIFTH(3, 5_000, "3개 일치(5000원) - ");

    private int countOfMatch;
    private int winningReward;
    private String resultMessage;

    Rank(int countOfMatch, int winningReward, String resultMessage){
        this.countOfMatch = countOfMatch;
        this.winningReward = winningReward;
        this.resultMessage = resultMessage;
    }

    public int getCountOfMatch(){
        return countOfMatch;
    }

    public int getWinningReward(){
        return winningReward;
    }

    public Rank getThirdPlaceMatch(){
        return THIRD;
    }

    public String showResultMessage(int countOfLotto){
        return this.resultMessage + countOfLotto + "개";
    }


}
