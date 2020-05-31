package lotto.domain;

public class DuplicatedLottoNumberException extends RuntimeException {
    public DuplicatedLottoNumberException() {
        super("로또 번호는 중복으로 선택할 수 없습니다.");
    }
}
