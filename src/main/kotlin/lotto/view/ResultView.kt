package lotto.view

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

    fun printWinningStatistics(criteriaForWinning: Int, prize: BigDecimal, count: Int) {
        println("${criteriaForWinning}개 일치 (${prize}원)- ${count}개")
    }

    fun printRate(rate: BigDecimal) {
        val convertRateToText = convertRateToText(rate)
        println("총 수익률은 ${rate}입니다.(기준이 1이기 때문에 결과적으로 ${convertRateToText}라는 의미임)")
    }

    private fun convertRateToText(rate: BigDecimal) =
        if (rate > BigDecimal.ONE) "이득"
        else if (rate == BigDecimal.ONE) "본전"
        else "손해"
}
