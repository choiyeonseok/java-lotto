package lotto.domain;

public class InvalidWinningLottoException extends RuntimeException {
    public InvalidWinningLottoException() {
        super("당첨 로또를 입력해주세요");
    }
}
