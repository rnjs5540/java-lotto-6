package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Goverment {
    Lotto winningLotto;

    void inputWinningNumbers() {
        List<Integer> winningNums = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        try {
            String[] tokens = userInput.split(",");
            for (String token : tokens)
                winningNums.add(Integer.parseInt(token));
            winningLotto = new Lotto(winningNums);
        }
        catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1~45 중 중복되지 않는 숫자 6개를 ','를 기준으로 입력해주세요.");
            inputWinningNumbers();
        }
    }

    void inputBonusNumber() {
        int bonusNumber;
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
            if (winningLotto.getNumbers().contains(bonusNumber)) {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1~45 중 당첨 번호와 중복되지 않는 숫자를 입력해주세요.");
            inputBonusNumber();
        }
    }
}
