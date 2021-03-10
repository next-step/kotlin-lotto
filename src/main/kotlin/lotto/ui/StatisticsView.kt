package lotto.ui

import lotto.domain.WinningStatistics
import lotto.enums.LotteryMatchType
import java.math.BigDecimal

object StatisticsView {

    const val PROFIT_RATIO_BASE = 1
    const val LOSS_MESSAGE = "기준이 1이기 때문에 결과적으로 손해라는 의미임"

    fun printLotteryStatistics(statistics: WinningStatistics) {
        println("당첨 통계")
        println("---------")

        LotteryMatchType.values().forEach {
            printMatchCountResult(it, statistics.getTicketCountOf(it))
        }
    }

    private fun printMatchCountResult(matchType: LotteryMatchType, ticketCount: Int) {
        if (matchType == LotteryMatchType.NonProfit) {
            return
        }
        println("${matchType.description} (${matchType.winningPrice}원)- ${ticketCount}개")
    }

    fun printProfitRatio(ratio: BigDecimal) {
        val infoMessage = if (ratio.compareTo(BigDecimal(PROFIT_RATIO_BASE)) == -1) "($LOSS_MESSAGE)" else ""
        println("총 수익률은 ${ratio}입니다.$infoMessage")
    }

    private val LotteryMatchType.description: String
        get() = when (this) {
            LotteryMatchType.NonProfit -> "2개 이하"
            LotteryMatchType.Three -> "3개 일치"
            LotteryMatchType.Four -> "4개 일치"
            LotteryMatchType.Five -> "5개 일치"
            LotteryMatchType.Six -> "6개 일치"
        }
}
