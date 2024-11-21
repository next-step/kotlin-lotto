package lotto.view

import lotto.domain.LottoRank
import java.math.BigDecimal

object ResultView {
    fun showPurchaseInfo(
        count: Int,
        lottoNumbers: List<List<Int>>,
    ) {
        println("$count 개를 구매했습니다.")
        lottoNumbers.forEach { println(it) }
    }

    fun showStatistics(
        statistics: Map<LottoRank, Int>,
        profitRate: BigDecimal,
    ) {
        println("\n당첨 통계")
        println("---------")
        statistics.forEach { (rank, count) ->
            if (rank != LottoRank.NONE) {
                println("${rank.matchCount}개 일치 (${rank.prize}원)- ${count}개")
            }
        }
        println("총 수익률은 $profitRate 입니다.(기준이 1이기 때문에 결과적으로 ${if (profitRate >= BigDecimal.ONE) "이익" else "손해"}라는 의미임)")
    }
}
