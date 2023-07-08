package lotto.domain

class WinningStatistics(val winningStatistics: Map<Rank, Int>) {
    fun calculateTotalPrizeMoney(): Long {
        return winningStatistics
            .map { (rank, count) ->
                rank.times(count)
            }
            .sum()
    }

    fun calculateProfitRate(purchaseMoney: PurchaseMoney): Double {
        val totalPrizeMoney = calculateTotalPrizeMoney()
        return totalPrizeMoney / purchaseMoney.value.toDouble()
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
