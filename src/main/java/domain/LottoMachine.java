package domain;

import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int START_INDEX = 0;

    private LottoMachine() {
    }

    public static Lottos buyLottos(final List<int[]> manualLottoInputs, final LottoCount lottoCount) {
        Lottos lottos = new Lottos(buyManualLottos(manualLottoInputs));
        buyAutoLottos(lottos, lottoCount);
        return lottos;
    };

    private static List<Lotto> buyManualLottos(final List<int[]> manualLottoInputs) {
        List<Lotto> lottos = new ArrayList<>();
        for (int[] inputs : manualLottoInputs) {
            addManualLottoWithValidation(lottos, inputs);
        }
        return lottos;
    }

    private static void addManualLottoWithValidation(List<Lotto> lottos, int[] inputs) {
        try {
            LottoGenerator lottoGenerator = new ManualLottoGenerator(inputs);
            lottos.add(lottoGenerator.generateLotto());
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        }
    }


    private static void buyAutoLottos(final Lottos lottos, final LottoCount lottoCount) {
        LottoGenerator lottoGenerator = new AutoLottoGenerator();
        for (int index = START_INDEX; index < lottoCount.getAutoCount(); index++) {
            lottos.addLotto(lottoGenerator.generateLotto());
        }
    }
}
