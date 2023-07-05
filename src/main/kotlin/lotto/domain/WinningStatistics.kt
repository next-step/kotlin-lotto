package lotto.domain

class WinningStatistics(val winningStatistics: Map<Rank, Int>) {
    fun calculateTotalPrizeMoney(): Long {
        return winningStatistics
            .map { (rank, count) ->
                rank.times(count)
            }
            .sum()
    }

    fun calculateProfitRate(purchaseMoney: Long): Double {
        val totalPrizeMoney = calculateTotalPrizeMoney()
        return totalPrizeMoney / purchaseMoney.toDouble()
    }

    companion object {
        fun of(lottos: Lottos, winningLotto: WinningLotto): WinningStatistics {
            return WinningStatistics(
                lottos.lottos
                    .map { lotto -> winningLotto.rank(lotto) }
                    .groupBy { it }
                    .mapValues { it.value.size },
            )
        }
    }
}
