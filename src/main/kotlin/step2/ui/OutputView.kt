package step2.ui

import step2.domain.Lotto
import step2.domain.WinningAmount
import kotlin.math.round
import kotlin.math.roundToInt

object OutputView {

    private const val WINNING_STATISTICS_MESSAGE = "당첨 통계"
    private const val LINE_BREAK_CHAR = "------------"

    fun generateLotto(lottoList: List<Lotto>) {
        lottoList.forEach {
            println(it.numbers)
        }
    }

    fun lottoResult(result: Map<WinningAmount, Int>) {
        println(WINNING_STATISTICS_MESSAGE)
        println(LINE_BREAK_CHAR)
        result.keys.forEach {
            println("${it.label} ${it.value} - ${result[it]} 개")
        }
    }

    fun rateOfReturn(winningAmount: Int, purchaseAmount: Int) {
        println("총 수익률은 ${intToDoubleRound(winningAmount, purchaseAmount)} 입니다.")
    }

    private fun intToDoubleRound(winningAmount: Int, purchaseAmount: Int): Double {
        return round(((winningAmount.toDouble() / purchaseAmount.toDouble()) * 100.0).roundToInt() / 100.0)
    }

}
