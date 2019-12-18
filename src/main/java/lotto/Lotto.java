package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }

    public boolean isContainNumber(int number) {
        return numbers.contains(number);
    }

    public int countOfMatch(List<Integer> winningNumbers) {
        return (int)winningNumbers.stream().filter(n -> numbers.contains(n)).count();
    }
}
