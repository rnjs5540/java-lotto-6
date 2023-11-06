package lotto;

import java.util.List;

public class Computer {
    int[] rewards = { 0, 2000000000, 30000000, 1500000, 50000, 5000 };
    int[] rankCounts;
    int totalReward = 0;
    void getStatistics(List<Lotto> lottos, WinningNumbers winningNumbers) {
        rankCounts = new int[6];
        for (Lotto lotto : lottos) {
            int correctCount = getCorrectCount(lotto, winningNumbers);
            int rank = getRank(correctCount, checkBonusNumber(lotto, winningNumbers));
            rankCounts[rank]++;
            totalReward += getReward(rank);
        }
    }
    void printRewards(List<Lotto> lottos) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + rankCounts[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + rankCounts[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCounts[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCounts[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCounts[1] + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.", Math.round((float)totalReward/lottos.size())/10.0);
    }
    private int getReward(int rank) {
        return rankCounts[rank] * rewards[rank];
    }
    private int getRank(int correctCount, boolean isBonusNumberCorrect) {
        if (correctCount == 6)
            return 1;
        if (correctCount == 5) {
            if (isBonusNumberCorrect)
                return 3;
            return 2;
        }
        if (correctCount == 4)
            return 4;
        if (correctCount == 3)
            return 5;
        return 0;
    }
    private int getCorrectCount(Lotto lotto, WinningNumbers winningNumbers) {
        int correctCount = 0;
        List<Integer> lottoNumbers = lotto.getNumbers();
        for (Integer lottoNumber : lottoNumbers) {

            if (winningNumbers.getWinningNumbers().contains(lottoNumber)) {
                correctCount++;
            }
        }
        return correctCount;
    }
    private boolean checkBonusNumber(Lotto lotto, WinningNumbers winningNumbers) {
        return lotto.getNumbers().contains(winningNumbers.getBonusNumber());
    }
}
