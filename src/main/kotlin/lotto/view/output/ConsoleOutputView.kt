package lotto.view.output

import lotto.model.data.Policy
import lotto.model.data.Results
import lotto.model.data.Statistics
import lotto.model.data.Winning

class ConsoleOutputView(
    private val policy: Policy,
    private val printlnOnScreen: ((Any) -> Unit) = ::println
) : OutputView {

    override fun printResults(results: Results) {
        val statistics = Statistics(results, policy)
        printTitle()
        printWinningStatistics(statistics)
        printFinalMessage(statistics)
    }

    private fun printTitle() {
        this.printlnOnScreen("당첨 통계")
        this.printlnOnScreen("----------")
    }

    private fun printWinningStatistics(statistics: Statistics) {
        statistics.missRemovedWinningCountMap
            .forEach { (winning, count) ->
                this.printlnOnScreen("${winning.message} (${winning.winMoney}원) - ${count}개")
            }
    }

    private fun printFinalMessage(statistics: Statistics) {
        val finalMessage = StringBuilder("총 수익률은 ${statistics.shortYieldString}입니다.")
            .append("(기준이 1이기 때문에 결과적으로 ${statistics.finalJudgement}라는 의미임)")
        this.printlnOnScreen(finalMessage)
    }

    private val Winning.message: String
        get() = if (this.isMustBonusNumberMatch) {
            "${this.matchCount}개 일치, 보너스 볼 일치"
        } else {
            "${this.matchCount}개 일치"
        }

    private val Statistics.missRemovedWinningCountMap: Map<Winning, Int>
        get() = this.winningCountMap.filter { (winning, _) -> winning.winMoney > 0 }

    private val Statistics.shortYieldString: String
        get() = this.yield.cutTwoDigitAfterDot()

    private val Statistics.finalJudgement: String
        get() = when {
            this.yield < 1.0 -> "손해"
            this.yield > 1.0 -> "이득이"
            else -> "본전이"
        }

    private fun Double.cutTwoDigitAfterDot() = String.format("%.02f", this)
}
