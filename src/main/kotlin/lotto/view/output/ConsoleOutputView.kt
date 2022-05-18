package lotto.view.output

import lotto.model.data.Lotto
import lotto.model.data.Lottos
import lotto.model.data.Policy
import lotto.model.data.Results
import lotto.model.data.Statistics
import lotto.model.data.Winning

class ConsoleOutputView(private val policy: Policy, private val printlnOnScreen: ((String) -> Unit) = ::println) :
    OutputView {

    override fun printLottos(lottos: Lottos) {
        lottos.lottoList.map { it.toDisplayString() }
            .forEach(this.printlnOnScreen)
        this.printlnOnScreen("")
    }

    override fun printResults(results: Results) {

        val statistics = Statistics(results, policy)
        this.printlnOnScreen("당첨 통계")
        this.printlnOnScreen("----------")
        statistics.winningCountMap
            .filter { (winning, _) -> winning.winMoney > 0 }
            .forEach { (winning, count) ->
                this.printlnOnScreen("${winning.message} (${winning.winMoney}원) - ${count}개")
            }

        this.printlnOnScreen("총 수익률은 ${statistics.winningRatio.cutTwoDigitAfterDot()}입니다.(기준이 1이기 때문에 결과적으로 ${statistics.winningRatio.toWinningString()}라는 의미임)")
    }

    private fun Lotto.toDisplayString() =
        this.numbers.joinToString(separator = ", ", prefix = "[", postfix = "]")

    private val Winning.message: String
        get() = "${this.matchCount}개 일치"

    private fun Double.toWinningString() = when {
        this < 1.0 -> "손해"
        this > 1.0 -> "이득이"
        else -> "본전이"
    }

    private fun Double.cutTwoDigitAfterDot() = String.format("%.02f", this)
}
