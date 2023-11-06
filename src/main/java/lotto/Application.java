package lotto;

public class Application {
    public static void main(String[] args) {
        Person person = new Person();
        Government government = new Government();
        Computer computer = new Computer();
        person.buyLottos();
        person.printLottos();
        government.makeWinningNumbers();
        WinningNumbers winningNumbers = government.getWinningNumbers();
        computer.getStatistics(person.lottos, winningNumbers);
        computer.printRewards(person.lottos);
    }
}
