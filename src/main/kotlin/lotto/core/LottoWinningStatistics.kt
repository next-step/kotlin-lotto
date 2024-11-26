package lotto.core

data class LottoWinningStatistics(val rank: Map<WinningRank, Int>, val yieldRate: Float) {
    constructor(lottos: Lottos, yieldRate: Float) : this(createWinningRankMap(lottos), yieldRate)

    companion object {
        fun createWinningRankMap(lottos: Lottos): Map<WinningRank, Int> {
            return WinningRank.entries.associate { rank -> (rank to lottos.count { it.winningRank == rank }) }
        }
    }
}
