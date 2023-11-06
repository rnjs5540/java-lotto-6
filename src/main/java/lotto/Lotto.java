package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    List<Integer> getNumbers() { return numbers; }
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    void printLotto() {
        System.out.print("[");
        System.out.print(numbers.get(0));
        for (int i = 1; i < 6; ++i) {
            System.out.print(", " + numbers.get(i));
        }
        System.out.println("]");
    }
}
