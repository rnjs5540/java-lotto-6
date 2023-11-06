package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Government {
    private WinningNumbers winningNumbers;
    void makeWinningNumbers() {
        winningNumbers = new WinningNumbers();
        inputWinningNumbers();
        inputBonusNumber();
    }
    WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }
    private void inputWinningNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        try {
            String[] tokens = userInput.split(",");
            for (String token : tokens)
                numbers.add(Integer.parseInt(token));
            winningNumbers.setWinningNumbers(numbers);
        }
        catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1~45 중 중복되지 않는 숫자 6개를 ','를 기준으로 입력해주세요.");
            inputWinningNumbers();
        }
    }

    private void inputBonusNumber() {
        int bonusNumber;
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
            winningNumbers.setBonusNumber(bonusNumber);
        }
        catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1~45 중 당첨 번호와 중복되지 않는 숫자를 입력해주세요.");
            inputBonusNumber();
        }
    }
}
