package lotto;

public enum WinningResult {
    FIRST(6, 2_000_000_000, "6개 일치(2000000000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스볼 일치(30000000원) - "),
    THIRD(5, 1_500_000, "5개 일치(150000원) - "),
    FOURTH(4, 50_000, "4개 일치(50000원) - "),
    FIFTH(3, 5_000, "3개 일치(5000원) - "),
    MISS(0, 0, "");

    private static final int MIN_CORRECT_COUNT = 3;

    private int correctCount;
    private long reward;
    private String message;

    private WinningResult(int correctCount, long reward, String message) {
        this.correctCount = correctCount;
        this.reward = reward;
        this.message = message;
    }

    public static WinningResult valueOf(int correctCount, boolean matchBonus) {
        if (correctCount < MIN_CORRECT_COUNT) {
            return MISS;
        }

        if (SECOND.matchCount(correctCount) && matchBonus) {
            return SECOND;
        }

        for (WinningResult result : values()) {
            if (result.matchCount(correctCount) && result != SECOND) {
                return result;
            }
        }

        throw new IllegalArgumentException(correctCount + "는 유효하지 않은 값입니다.");
    }

    private boolean matchCount(int correctCount) {
        return this.correctCount == correctCount;
    }

    public void printMessage(int count){
        if (this != MISS) {
            System.out.println(message + count +"개");
        }
    }

    public int getCorrectCount(){
        return correctCount;
    }

    public long getWinningMoney() {
        return reward;
    }
}
