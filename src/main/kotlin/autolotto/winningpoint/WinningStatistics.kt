package autolotto.winningpoint

import autolotto.vo.AutoLotto
import autolotto.vo.WinningLotto

object WinningStatistics {
    private const val NOT_MATCHING_COUNT = 0

    fun calculateStatistics(autoLotto: AutoLotto, winningLotto: WinningLotto): Map<WinningRank, Int> {
        return autoLotto.lottos.groupingBy { winningLotto.checkWinning(lotto = it) }
            .eachCount()
            .withDefault { NOT_MATCHING_COUNT }
    }
}
