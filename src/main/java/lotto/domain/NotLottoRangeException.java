package lotto.domain;

public class NotLottoRangeException extends RuntimeException {
    public NotLottoRangeException() {
        super("로또 번호는 1부터 45까지만 유효합니다.");
    }
}
