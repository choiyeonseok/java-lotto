package lotto;

public class WinningNumbers {
    private Lotto winningNumber;
    private int bonusNumber;

    public WinningNumbers(Lotto winningNumber, int bonusNumber){
        this.bonusNumber = bonusNumber;
        this.winningNumber = winningNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

    @Override
    public String toString(){
        return "당첨 번호 : " + winningNumber
                + "\n 보너스 번호 : " +  bonusNumber;
    }
}
