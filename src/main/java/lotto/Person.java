package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Person {
    List<Lotto> lottos;
    Person() {
        lottos = new ArrayList<>();
    }
    void buyLottos() {
        Store store = new Store();
        store.inputMoney();
        lottos = store.buyLottos();
    }
    void printLottos() {
        for (Lotto lotto : lottos)
            lotto.printLotto();
    }
    void getstatistics() {

    }
}
