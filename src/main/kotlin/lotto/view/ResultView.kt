package lotto.view

import lotto.domain.LottoResult
import lotto.domain.LottoStatistics
import lotto.domain.Tickets
import lotto.domain.Winning
import java.math.BigDecimal

class ResultView {
    fun printTickets(tickets: Tickets, manualTicketCount: Int) {
        println("수동으로 $manualTicketCount 장, 자동으로 ${tickets.count() - manualTicketCount}장을 구매했습니다.")
        tickets.formatToPrint().forEach(::println)
        println()
    }

    fun printLottoResult(result: LottoResult) {
        println(PRINT_WINNING_STATISTICS)
        println(PRINT_LINE)

        Winning.values()
            .filter { it != Winning.LOSE }
            .forEach { winning ->
                val winningCount = result.getWinningCount(winning)
                val matchCount = winning.matchCount
                val amount = winning.winningAmount

                val withBonusView = if (winning == Winning.SECOND_PLACE) ", 보너스 볼 일치" else ""

                println("$matchCount 개 일치$withBonusView ($amount 원) - $winningCount 개")
            }
    }

    fun printWinningStatistics(statistics: LottoStatistics) {
        println("총 수익률은 ${getDisplayYield(statistics.getYield())} 입니다.(기준이 1이기 때문에 결과적으로 ${getDisplayReport(statistics.getYield())})")
    }

    private fun getDisplayYield(value: BigDecimal): String = String.format("%.02f", value)

    private fun getDisplayReport(value: BigDecimal): String {
        return if (value >= 1.0.toBigDecimal()) PRINT_IS_GAIN else PRINT_IS_LOSE
    }

    companion object {
        private const val PRINT_WINNING_STATISTICS = "당첨통계"
        private const val PRINT_LINE = "---------"
        private const val PRINT_IS_LOSE = "손해이다."
        private const val PRINT_IS_GAIN = "이득이다."

        private const val PREFIX_LOTTO = "["
        private const val POSTFIX_LOTTO = "]"

        private const val DISPLAY_SECOND_DIGIT = 100
    }
}
