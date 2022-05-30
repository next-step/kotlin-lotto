package lotto.ui

import lotto.Lotto
import lotto.Winning

class ResultView {
    fun printNumberOfLotto(number: Int) {
        println("${number}개를 구매했습니다.")
    }

    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach {
            println(it.numbers.sorted())
        }
        println()
    }

    fun printResult() {
        println()
        println(MESSAGE_WINNING_STATISTICS)
        println(MESSAGE_DIVISION_LINE)
    }

    fun printWinningStatistics(result: Map<Winning, Int>) {
        result.forEach { (winning, count) ->
            println("${winning.matchCount}개 일치 (${winning.winningAmount}원) - ${count}개")
        }
    }

    fun printYield(yieldRate: Double) {
        println("총 수익률은 ${yieldRate}입니다")
    }

    companion object {
        private const val MESSAGE_WINNING_STATISTICS = "당첨 통계"
        private const val MESSAGE_DIVISION_LINE = "---------"
    }
}
