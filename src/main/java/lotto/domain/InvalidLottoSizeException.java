package lotto.domain;

public class InvalidLottoSizeException extends RuntimeException {
    public InvalidLottoSizeException() {
        super("로또 번호의 갯수는 6개여야 합니다.");
    }
}
