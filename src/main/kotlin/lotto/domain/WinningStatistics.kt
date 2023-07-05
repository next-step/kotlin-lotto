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
        fun of(lottos: Lottos, winningLotto: Lotto): WinningStatistics {
            return WinningStatistics(
                lottos.lottos
                    .map { lotto -> Rank.of(lotto.countMatch(winningLotto), lotto.matchBonus(winningLotto)) }
                    .groupBy { it }
                    .mapValues { it.value.size },
            )
        }
    }
}
