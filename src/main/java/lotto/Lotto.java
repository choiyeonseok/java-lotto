package lotto;

import java.util.Arrays;
import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString(){
        return Arrays.toString(numbers.toArray());
    }
}
