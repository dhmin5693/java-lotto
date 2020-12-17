package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBucket {

    private List<Lotto> lottos;

    public LottoBucket() {
        this.lottos = new ArrayList<>();
    }
    public void createLotto() {
        Lotto lotto = new Lotto();
        lotto.generateNumbers();
        lottos.add(lotto);
    }

    public int checkNumberOfLottos() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
