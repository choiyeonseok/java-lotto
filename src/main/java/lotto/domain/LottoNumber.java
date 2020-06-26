package lotto.domain;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final Map<Integer, LottoNumber> ALL_LOTTO_NUMBERS = new HashMap<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(i -> ALL_LOTTO_NUMBERS.put(i, new LottoNumber(i)));
    }

    private int number;

    public LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber from(final int number) {
        if (ALL_LOTTO_NUMBERS.containsKey(number)) {
            return ALL_LOTTO_NUMBERS.get(number);
        }
        throw new NotLottoRangeException();
    }

    public static List<LottoNumber> getAllLottoNumbers() {
        return Lists.newArrayList(ALL_LOTTO_NUMBERS.values());
    }

    @Override
    public int compareTo(final LottoNumber lottoNumber) {
        if (number > lottoNumber.number) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
