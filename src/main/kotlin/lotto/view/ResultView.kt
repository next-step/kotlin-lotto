package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoProfitRate
import lotto.domain.LottoRank
import lotto.domain.LottoTicket
import lotto.domain.ResultLottoStatistics
import lotto.domain.WinningLottoStatistics
import kotlin.math.floor
import kotlin.math.pow

object ResultView {
    private const val MAXIMUM_PROFIT_RATE_POINT = 2

    fun printLottoTickets(lottoTicket: LottoTicket) {
        println("수동으로 ${lottoTicket.manuals.size}장, 자동으로 ${lottoTicket.automatics.size}장을 구매했습니다.")
        lottoTicket.getTickets().forEach {
            println(toLottoTicketString(it))
        }
    }

    fun printResult(resultLottoStatistics: ResultLottoStatistics) {
        printWinningLottoStatistics(resultLottoStatistics.winningLottoStatistics)
        printLottoProfitRate(resultLottoStatistics.profitRate)
    }

    private fun printWinningLottoStatistics(winningLottoStatistics: WinningLottoStatistics) {
        println("당첨 통계")
        println("----------")
        val statistics = winningLottoStatistics.statistics.toList().sortedWith(compareBy { it.first.matchCount })
            .map { "${toLottoRankString(it.first)} - ${it.second}개" }.joinToString("\n")
        println(statistics)
    }

    private fun printLottoProfitRate(profitRate: LottoProfitRate) {
        println("총 수익률은 ${cutProfitRatePoint(profitRate.value)}입니다.")
    }

    private fun cutProfitRatePoint(profitRate: Double): Double {
        return floor(profitRate * (10.0.pow(MAXIMUM_PROFIT_RATE_POINT).toInt())) / (10.0).pow(MAXIMUM_PROFIT_RATE_POINT).toInt()
    }

    private fun toLottoTicketString(lotto: Lotto): String {
        return "${lotto.numbers}"
    }

    private fun toLottoRankString(lottoRank: LottoRank): String {
        return "${lottoRank.matchCount}개 일치" +
            "${if (lottoRank.matchBonus)", 보너스 볼 일치" else " "}" +
            " (${lottoRank.winningMoney})"
    }
}
