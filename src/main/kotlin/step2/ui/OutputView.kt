package step2.ui

import step2.domain.Lottos
import step2.domain.WinningAmount

object OutputView {

    private const val WINNING_STATISTICS_MESSAGE = "당첨 통계"
    private const val LINE_BREAK_CHAR = "------------"

    fun generateLotto(lottoList: Lottos) {
        lottoList.lottos.forEach {
            println(it.numbers)
        }
    }

    fun lottoResult(result: Map<WinningAmount, Int>) {
        println(WINNING_STATISTICS_MESSAGE)
        println(LINE_BREAK_CHAR)
        result.keys.forEach {
            println("${it.label} ${it.reward} - ${result[it]} 개")
        }
    }

    fun rateOfReturn(rateOfRevenue: Double) {
        println("총 수익률은 $rateOfRevenue 입니다.")
    }

}

