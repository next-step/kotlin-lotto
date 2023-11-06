package lotto.view

import lotto.app.LottoApp
import lotto.model.LottoWinners
import lotto.model.Round

object OutputView {
    fun presetRound(round: Round) {

        round.games
            .forEach { println(it) }
    }

    fun presentPrizes(s: LottoWinners) {

        s.earningRate(LottoApp.pricePerGame())
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
