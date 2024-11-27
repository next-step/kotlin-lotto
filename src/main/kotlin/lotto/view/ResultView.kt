package lotto.view

import lotto.domain.LottoRank
import java.math.BigDecimal

object ResultView {
    private const val PURCHASE_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다."
    private const val STATISTICS_TITLE = "\n당첨 통계"
    private const val STATISTICS_SEPARATOR = "---------"
    private const val STATISTICS_FORMAT = "%d개 일치 (%d원)- %d개"
    private const val SECOND_STATISTICS_FORMAT = "%d개 일치, 보너스 볼 일치(%d원)- %d개"
    private const val PROFIT_MESSAGE = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)"
    private const val PROFIT_GAIN = "이익"
    private const val PROFIT_LOSS = "손해"

    fun showPurchaseInfo(
        manualCount: Int,
        autoCount: Int,
        lottoNumbers: List<List<Int>>,
    ) {
        println(PURCHASE_MESSAGE.format(manualCount, autoCount))
        lottoNumbers.forEach { println(it) }
    }

    fun showStatistics(
        statistics: Map<LottoRank, Int>,
        profitRate: BigDecimal,
    ) {
        println(STATISTICS_TITLE)
        println(STATISTICS_SEPARATOR)
        statistics.forEach { (rank, count) ->
            if (rank != LottoRank.NONE && rank != LottoRank.SECOND) {
                println(STATISTICS_FORMAT.format(rank.matchCount, rank.prize, count))
            }
            if (rank == LottoRank.SECOND) {
                println(SECOND_STATISTICS_FORMAT.format(rank.matchCount, rank.prize, count))
            }
        }
        val profitResult = if (profitRate >= BigDecimal.ONE) PROFIT_GAIN else PROFIT_LOSS
        println(PROFIT_MESSAGE.format(profitRate, profitResult))
    }
}
