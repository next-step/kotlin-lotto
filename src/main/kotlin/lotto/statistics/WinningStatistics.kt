package lotto.statistics

import lotto.Lottos
import lotto.rank.LottoRank

class WinningStatistics {
    fun evaluate(
        lottos: Lottos,
        winningNumbers: List<Int>,
    ): List<LottoRank> = lottos.lottos.map { it.getRank(winningNumbers) }
}
