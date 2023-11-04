package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Store {
    int cash;
    void getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        cash = Integer.parseInt(Console.readLine());
        if (cash % 1000 > 0) {
            throw new IllegalArgumentException();
            // 상위에서 예외처리 후 돈 재입력받기
        }
    }

    List<Lotto> buyLotto() {
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
