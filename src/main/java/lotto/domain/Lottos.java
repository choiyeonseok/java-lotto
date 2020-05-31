package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResult calculateResult(final WinningNumbers winningNumbers) {
        return new LottoResult(lottos.stream()
                .map(winningNumbers::calculateMatchResult)
                .collect(Collectors.toList()));
    }

    public int count() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
