package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Store {
    int cash;
    void getMoney() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            cash = Integer.parseInt(Console.readLine());
            if (cash < 0 || cash % 1000 > 0)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1000원 단위로 입력해 주세요.");
            getMoney();
        }
    }

    List<Lotto> buyLottos() {
        int count = cash / 1000;
        System.out.println(count + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(issueLotto());
        for (int i = 0; i < count; ++i)
             lottos.add(issueLotto());

        return lottos;
    }
    Lotto issueLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
