package autolotto.winningpoint

import autolotto.vo.AutoLotto
import autolotto.vo.WinningLotto

object WinningStatistics {
    fun calculateStatistics(autoLotto: AutoLotto, winningLotto: WinningLotto): Map<WinningRank, Int> {
        return autoLotto.lottos.fold(initialCountMap()) { countMap, lotto ->
            val winningRank = winningLotto.checkWinning(lotto)
            countMap.toMutableMap().apply {
                this[winningRank] = this.getOrDefault(winningRank, 0) + 1
            }.toMap()
        }
    }

    private fun initialCountMap(): Map<WinningRank, Int> = WinningRank.values().associateWith { 0 }
}
