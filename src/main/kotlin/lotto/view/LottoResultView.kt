package lotto.view

import lotto.domain.LottoResult
import lotto.domain.Rank

class LottoResultView {
    fun printResult(result: LottoResult) {
        println("\n당첨 통계\n---------")
        val rate = result.totalProfitRate()
        printAllRanks(result)
        println("${profitRateString(rate)} ${resultString(rate)}")
    }

    private fun profitRateString(rate: Float): String {
        return String.format("총 수익률은 %.2f입니다.", rate)
    }

    private fun resultString(rate: Float): String {
        return when {
            rate < 1f -> LOSS
            rate == 1f -> EVEN
            else -> PROFIT
        }
    }

    private fun printAllRanks(result: LottoResult) {
        printRank(result, Rank.FIFTH_PRIZE)
        printRank(result, Rank.FOURTH_PRIZE)
        printRank(result, Rank.THIRD_PRIZE)
        printRank(result, Rank.SECOND_PRIZE, true)
        printRank(result, Rank.FIRST_PRIZE)
    }

    private fun printRank(result: LottoResult, rank: Rank, isBonus: Boolean = false) {
        println("${rank.matches}개 일치${if (isBonus) ", 보너스 볼 일치" else " "}(${rank.prize}원) - ${result[rank]}개")
    }

    companion object {
        private const val LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        private const val EVEN = "(기준이 1이기 때문에 결과적으로 본전이라는 의미임)"
        private const val PROFIT = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)"
    }
}
