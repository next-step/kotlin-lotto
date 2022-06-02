package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoStatistics
import lotto.domain.Winning
import kotlin.math.round

class ResultView {
    fun printTickets(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { lotto ->
            println(
                lotto.numbers.map { it.number }.sorted().joinToString(prefix = PREFIX_LOTTO, postfix = POSTFIX_LOTTO)
            )
        }
        println()
    }

    fun printLottoResult(result: Map<Winning, Int>) {
        println(PRINT_WINNING_STATISTICS)
        println(PRINT_LINE)

        Winning.values().forEach { winning ->
            if (winning == Winning.LOSE) return@forEach
            val winningCount = result[winning] ?: 0
            val matchCount = winning.matchCount
            val amount = winning.winningAmount

            val withBonusView = if (winning == Winning.SECOND_PLACE) ", 보너스 볼 일치" else ""

            println("$matchCount 개 일치$withBonusView ($amount 원) - $winningCount 개")
        }
    }

    fun printWinningStatistics(statistics: LottoStatistics) {
        val displayYield = round(statistics.getYield() * DISPLAY_SECOND_DIGIT) / DISPLAY_SECOND_DIGIT
        println("총 수익률은 $displayYield 입니다.(${if (statistics.getYield() >= 1) PRINT_IS_GAIN else PRINT_IS_LOSE})")
    }

    companion object {
        private const val PRINT_WINNING_STATISTICS = "당첨통계"
        private const val PRINT_LINE = "---------"
        private const val PRINT_IS_LOSE = "기준이 1이기 때문에 결과적으로 손해이다."
        private const val PRINT_IS_GAIN = "기준이 1이기 때문에 결과적으로 이득이다."

        private const val PREFIX_LOTTO = "["
        private const val POSTFIX_LOTTO = "]"

        private const val DISPLAY_SECOND_DIGIT = 100
    }
}
