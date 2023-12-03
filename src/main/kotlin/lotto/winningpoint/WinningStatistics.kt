package lotto.winningpoint

import lotto.vo.AutoLotto
import lotto.vo.Lotto
import lotto.vo.Lottos
import lotto.vo.ManualLotto
import lotto.vo.WinningLotto

object WinningStatistics {
    private const val NOT_MATCHING_COUNT = 0

    fun calculateStatistics(lottos: Lottos, winningLotto: WinningLotto): Map<WinningRank, Int> {
        return lottos.lottos.groupingBy { winningLotto.checkWinning(lotto = it) }
            .eachCount()
            .withDefault { NOT_MATCHING_COUNT }
    }
}
