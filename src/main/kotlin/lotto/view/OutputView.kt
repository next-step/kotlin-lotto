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

        Rank.MATCH_RANKS.sortedBy { it.winningMoney }.forEach {
            renderMatchMsg(it, statistics.rankCounts[it] ?: 0)
        }

        val result = if (statistics.earningsRate > EARNINGS_RATE_THRESHOLD) "이익" else "손해"
        println("총 수익률은 ${statistics.earningsRate}입니다.(기준이 1이기 때문에 결과적으로 ${result}이라는 의미임)")
    }

    private fun renderMatchMsg(it: Rank, rankCount: Int) {
        val bonusMsg = if (it.matchBonus) ", 보너스 볼 일치" else ""
        println("${it.matchCount}개 일치$bonusMsg(${it.winningMoney}원)- ${rankCount}개")
    }

    private fun renderLotto(lotto: Lotto) {
        println("[${lotto.lottoNums.nums.map { it.value }.joinToString()}]")
    }

    companion object {
        private const val EARNINGS_RATE_THRESHOLD = 1
    }
}
