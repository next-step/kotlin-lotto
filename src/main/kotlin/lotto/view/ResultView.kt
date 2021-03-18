package lotto.view

import lotto.domain.LottoRank
import lotto.domain.LottoTicket
import lotto.domain.WinningLottoStatistics
import kotlin.math.floor
import kotlin.math.pow

object ResultView {
    private const val MAXIMUM_PROFIT_RATE_POINT = 2

    fun printLottoTickets(lottoTickets: List<LottoTicket>) {
        println("${lottoTickets.size}개를 구매했습니다.")
        lottoTickets.forEach {
            println(toLottoTicketString(it))
        }
    }

    fun printWinningLottoStatistics(winningLottoStatistics: WinningLottoStatistics) {
        val statistics = winningLottoStatistics.statistics.toList().sortedWith(compareBy { it.first.matchCount })
            .map { "${toLottoRankString(it.first)} - ${it.second}개" }.joinToString("\n")
        println(statistics)
    }

    fun printLottoProfitRate(profitRate: Double) {
        println("총 수익률은 ${cutProfitRatePoint(profitRate)}입니다.")
    }

    private fun cutProfitRatePoint(profitRate: Double): Double {
        return floor(profitRate * (10.0.pow(MAXIMUM_PROFIT_RATE_POINT).toInt())) / (10.0).pow(MAXIMUM_PROFIT_RATE_POINT).toInt()
    }

    private fun toLottoTicketString(lottoTicket: LottoTicket): String {
        return "${lottoTicket.lotto.numbers}"
    }

    private fun toLottoRankString(lottoRank: LottoRank): String {
        return "${lottoRank.matchCount}개 일치" +
            "${if (lottoRank.matchBonus)", 보너스 볼 일치" else " "}" +
            " (${lottoRank.winningMoney})"
    }
}
