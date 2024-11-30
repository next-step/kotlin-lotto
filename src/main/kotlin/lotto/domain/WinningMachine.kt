package lotto.domain

import lotto.domain.LottoAmount.Companion.LOTTO_PRICE

data class WinningMachine(val winningLotto: Lotto) {
    fun calculateStatistics(lottos: List<Lotto>): WinningStatistics {
        val matchCounts = calculateMatchCounts(lottos)
        val amount = lottos.size * LOTTO_PRICE

        return WinningStatistics(
            amount = amount,
            matchCount = matchCounts,
        )
    }

    private fun calculateMatchCounts(lottos: List<Lotto>): Map<Int, Int> {
        return lottos
            .map { LottoMatcher.matchLottoNumberCount(winningLotto, it) }
            .groupingBy { it }
            .eachCount()
    }
}
