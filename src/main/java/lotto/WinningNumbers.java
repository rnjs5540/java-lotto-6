package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private ArrayList<Integer> winningNumbers;
    private int bonusNumber;
    void setWinningNumbers(ArrayList<Integer> winningNumbers) {
        validateNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }
    List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
    void setBonusNumber(int bonusNumber) {
        validateBonus(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    int getBonusNumber() {
        return bonusNumber;
    }
    private void validateNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6)
            throw new IllegalArgumentException();
    }
    private void validateBonus(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber))
            throw new IllegalArgumentException();
    }
}
