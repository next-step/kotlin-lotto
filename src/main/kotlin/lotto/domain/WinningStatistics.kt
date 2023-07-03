package lotto.domain

import lotto.service.LottoCalculator

class WinningStatistics(val winningStatistics: Map<Int, Int>) {
    fun calculateTotalPrizeMoney(): Long {
        return winningStatistics
            .map { (matchCount, count) ->
                LottoCalculator.calculatePrizeMoney(matchCount) * count
            }
            .sum()
    }

    companion object {
        fun of(lottos: Lottos, winningLotto: Lotto): WinningStatistics {
            return WinningStatistics(
                lottos.lottos
                    .map { lotto -> lotto.countMatch(winningLotto) }
                    .groupBy { it }
                    .mapValues { it.value.size },
            )
        }
    }
}
