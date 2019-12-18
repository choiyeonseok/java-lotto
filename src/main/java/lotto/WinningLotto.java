package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto extends Lotto {
    private int bonus;

    public WinningLotto(List<Integer> numbers, int bonus) {
        super(numbers);
        this.bonus = bonus;
    }
}
