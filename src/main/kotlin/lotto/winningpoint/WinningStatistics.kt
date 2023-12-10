package lotto.winningpoint

import lotto.vo.Lottos
import lotto.vo.WinningLotto
import kotlin.math.floor

object WinningStatistics {
    private const val NOT_MATCHING_COUNT = 0

    fun getProfitRate(price: Long, winningPrice: Long): Double {
        val profitRate = (winningPrice / price).toDouble()
        return floor(profitRate * 10) / 100.0
    }

    fun calculateStatistics(lottos: Lottos, winningLotto: WinningLotto): Map<WinningRank, Int> {
        return lottos.lottos.groupingBy { winningLotto.checkWinning(lotto = it) }
            .eachCount()
            .withDefault { NOT_MATCHING_COUNT }
    }
}
