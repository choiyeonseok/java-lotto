package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {
    private List<Integer> numbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }

    public int lottoMatchCount(Lotto winningNumber) {
        return (int) numbers.stream()
                .filter(n -> winningNumber.hasNumber(n))
                .count();
    }
}
