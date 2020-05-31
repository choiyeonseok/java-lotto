package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final Map<Integer, LottoNumber> ALL_LOTTO_NUMBERS = new HashMap<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(i -> ALL_LOTTO_NUMBERS.put(i, new LottoNumber(i)));
    }

    private final int number;

    public LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber of(final int number) {
        if (ALL_LOTTO_NUMBERS.containsKey(number)) {
            return ALL_LOTTO_NUMBERS.get(number);
        }
        throw new NotLottoRangeException();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
