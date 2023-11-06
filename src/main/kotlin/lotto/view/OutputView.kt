package lotto.view

import lotto.app.LottoApp
import lotto.model.LottoWinners
import lotto.model.Round

object OutputView {
    fun presetRound(round: Round) {

        round.games
            .forEach { println(it) }
    }

    fun presentPrizes(lottoWinners: LottoWinners) {
        val earningRate = lottoWinners.earningRate(LottoApp.pricePerGame())
        println(
            """
        당첨 통계\
        ---------\n
        3개 일치 (5000원)- ${lottoWinners.countOf5th}개
        4개 일치 (50000원)- ${lottoWinners.countOf4th}개
        5개 일치 (1500000원)- ${lottoWinners.countOf3rd}개
        6개 일치 (2000000000원)- ${lottoWinners.countOf1st}개
        총 수익률은 ${earningRate.first} 입니다.(기준이 1이기 때문에 결과적으로 ${earningRate.second} 라는 의미임)
            """.trimIndent()
        )
    }
}
