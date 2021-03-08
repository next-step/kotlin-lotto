package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoPaper
import lotto.domain.LottoStatistics
import lotto.domain.Rank

internal class OutputView {

    internal fun renderLottoPaper(lottoPaper: LottoPaper) {
        println("${lottoPaper.lottos.size}개를 구매했습니다.")
        lottoPaper.lottos.forEach(this::renderLotto)
        println()
    }

    internal fun renderStatistics(statistics: LottoStatistics) {
        println("\n당첨 통계")
        println("---------")

        Rank.MATCH_RANKS.forEach {
            println("${it.matchCount}개 일치 (${it.winningMoney}원)- ${statistics.rankCounts[it] ?: 0}개")
        }

        val result = if (statistics.earningsRate > 1) "이익" else "손해"

        println("총 수익률은 ${statistics.earningsRate}입니다.(기준이 1이기 때문에 결과적으로 ${result}이라는 의미임)")
    }

    private fun renderLotto(lotto: Lotto) {
        println("[${lotto.lottoNums.nums.map { it.value }.joinToString()}]")
    }
}
