package lotto

import java.math.BigDecimal

class LottoResultView {

    fun printPurchasedLottoNumbers(lottoNumbers: LottoNumbers) {
        println("${lottoNumbers.size}개를 구매했습니다.")
        lottoNumbers.forEach {
            val numbers = it.asSequence()
                .sorted()
                .joinToString(", ")
            println("[$numbers]")
        }
        println()
    }

    fun printLottoStatistics(rankingCountMap: Map<LottoRanking, Int>, totalRevenueRate: BigDecimal) {
        println("\n당첨 통계")
        println("------------")
        RANKING_PRINT_ORDER.forEach {
            val count = rankingCountMap[it] ?: 0
            println("${getMatchMessage(it)} (${it.winningAmount}원) - $count")
        }
        println("총 수익률은 $totalRevenueRate 입니다. ${getLossMessage(totalRevenueRate)}")
    }

    private fun getMatchMessage(ranking: LottoRanking): String = when (ranking) {
        LottoRanking.SECOND -> "${ranking.matchCount}개 일치, 보너스볼 일치"
        else -> "${ranking.matchCount}개 일치"
    }

    private fun getLossMessage(totalRevenueRate: BigDecimal) =
        if (BigDecimal.ZERO > totalRevenueRate) "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" else ""

    companion object {
        private val RANKING_PRINT_ORDER =
            listOf(LottoRanking.FIFTH, LottoRanking.FOURTH, LottoRanking.THIRD, LottoRanking.SECOND, LottoRanking.FIRST)
    }
}
