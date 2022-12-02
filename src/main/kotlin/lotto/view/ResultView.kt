package lotto.view

import lotto.domain.LottoGameResult
import java.math.BigDecimal

object ResultView {
    fun printChosenNumber(numbers: List<Int>) {
        println(numbers.toString())
    }

    fun noticeOfPrize() {
        println()
        println("당첨 통계")
        println("---------")
    }

    fun printWinningStatistics(statistics: Map<LottoGameResult, Int>) {
        statistics.forEach {
            val bonus = if (it.key == LottoGameResult.SECOND) ", 보너스 볼 일치" else ""
            println("${it.key.criteriaForWinning}개 일치$bonus (${it.key.prize}원)- ${it.value}개")
        }
    }

    fun printRate(rate: BigDecimal) {
        val convertRateToText = convertRateToText(rate)
        println("총 수익률은 ${rate}입니다.(기준이 1이기 때문에 결과적으로 ${convertRateToText}라는 의미임)")
    }

    private fun convertRateToText(rate: BigDecimal) =
        if (rate > BigDecimal.ONE) "이득"
        else if (rate == BigDecimal.ONE) "본전"
        else "손해"

    fun buyResult(manual: Int, auto: Int) {
        println()
        println("수동으로 ${manual}장, 자동으로 ${auto}개를 구매했습니다.")
    }
}
