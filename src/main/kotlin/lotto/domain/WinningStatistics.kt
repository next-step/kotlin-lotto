package lotto.domain

import lotto.service.LottoCalculator

class WinningStatistics(val winningStatistics: Map<Rank, Int>) {
    fun calculateTotalPrizeMoney(): Long {
        return winningStatistics
            .map { (rank, count) ->
                LottoCalculator.calculatePrizeMoney(rank) * count
            }
            .sum()
    }

    fun calculateProfitRate(purchaseMoney: Long): Double {
        val totalPrizeMoney = calculateTotalPrizeMoney()
        return totalPrizeMoney.toDouble() / purchaseMoney.toDouble()
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
