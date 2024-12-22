package lotto.model.statistics

interface LottoStatistics {
    val winningRank: Map<Int, Int>
    val profitRate: Double
}
