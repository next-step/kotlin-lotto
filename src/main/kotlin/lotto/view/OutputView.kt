package lotto.view

import lotto.model.Game
import lotto.model.LottoOrder
import lotto.model.LottoTicket
import lotto.model.LottoWinners
import lotto.model.Rank

object OutputView {
    fun presetRound(lottoTicket: LottoTicket) {
        println(lottoTicket.present())
    }

    fun presentPrizes(lottoWinners: LottoWinners) {
        val earningRate = lottoWinners.earningRate(LottoOrder.priceOfGame())

        println(
            """
        당첨 통계
        ---------
        3개 일치 (5000원)- ${lottoWinners.countOfRank(Rank.FIFTH)}개
        4개 일치 (50000원)- ${lottoWinners.countOfRank(Rank.FOURTH)}개
        5개 일치 (1500000원)- ${lottoWinners.countOfRank(Rank.THIRD)}개
        6개 일치 (2000000000원)- ${lottoWinners.countOfRank(Rank.FIRST)}개
        총 수익률은 $earningRate 입니다.(기준이 1이기 때문에 결과적으로 ${incomeStatement(earningRate)} 라는 의미임)
            """.trimIndent()
        )
    }

    fun incomeStatement(earningRate: Double): String {
        return when (earningRate >= LottoWinners.BENEFIT_LOSS_CROSS_POINT) {
            true -> "이익"
            false -> "손해"
        }
    }

    fun presentPurchaseInfo(manualTicket: LottoTicket, autoTicket: LottoTicket) {
        println("수동으로 ${manualTicket.gamesCount()}장, 자동으로 ${autoTicket.gamesCount()}개를 구매했습니다.")
    }
}

private fun LottoTicket.present(): String {
    return this.games
        .joinToString("\n") { it.present() }
}

private fun Game.present(): String {
    return this.lottoNumbers.toString()
}
