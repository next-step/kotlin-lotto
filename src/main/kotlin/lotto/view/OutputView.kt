package lotto.view

import lotto.model.LottoWinners
import lotto.model.Round

object OutputView {
    fun presetRound(transaction: Round) {
        "[8, 21, 23, 41, 42, 43]\n" +
            "[3, 5, 11, 16, 32, 38]\n" +
            "[7, 11, 16, 35, 36, 44]\n" +
            "[1, 8, 11, 31, 41, 42]\n" +
            "[13, 14, 16, 38, 42, 45]\n" +
            "[7, 11, 30, 40, 42, 43]\n" +
            "[2, 13, 22, 32, 38, 45] << 이렇게 출력해야함"
        TODO("Not yet implemented")
    }

    fun presentPrizes(s: LottoWinners) {
        "당첨 통계\n" +
            "---------\n" +
            "3개 일치 (5000원)- 1개\n" +
            "4개 일치 (50000원)- 0개\n" +
            "5개 일치 (1500000원)- 0개\n" +
            "6개 일치 (2000000000원)- 0개\n" +
            "총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        TODO("Not yet implemented")
    }
}
