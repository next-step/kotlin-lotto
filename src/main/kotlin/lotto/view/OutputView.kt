package lotto.view

import lotto.app.LottoApp
import lotto.model.LottoWinners
import lotto.model.Rank
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
        3개 일치 (5000원)- ${lottoWinners.countOfRank(Rank.FIFTH)}개
        4개 일치 (50000원)- ${lottoWinners.countOfRank(Rank.FOURTH)}개
        5개 일치 (1500000원)- ${lottoWinners.countOfRank(Rank.THIRD)}개
        6개 일치 (2000000000원)- ${lottoWinners.countOfRank(Rank.FIRST)}개
        총 수익률은 ${earningRate.incomeStatement()} 입니다.(기준이 1이기 때문에 결과적으로 ${earningRate.incomeStatement()} 라는 의미임)
            """.trimIndent()
        )
    }
}

fun Double.incomeStatement(): String {
    return when (this >= LottoWinners.BENEFIT_LOSS_CROSS_POINT) {
        true -> LottoWinners.BENEFIT_MESSAGE
        false -> LottoWinners.LOSS_MESSAGE
    }
}
