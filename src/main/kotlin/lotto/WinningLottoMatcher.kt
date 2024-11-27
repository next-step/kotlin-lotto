package lotto

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.Order
import lotto.domain.Rank
import lotto.domain.WinningLotto
import lotto.domain.WinningResult

class WinningLottoMatcher {
    fun checkAndGetResult(
        order: Order,
        winningLotto: WinningLotto,
    ): WinningResult {
        val winningMatchCounts = aggregateLottoResult(order.lottos, winningLotto)
        return WinningResult(winningMatchCounts, order.amount)
    }

    private fun aggregateLottoResult(
        lottos: List<Lotto>,
        winningLotto: WinningLotto,
    ): List<LottoResult> {
        val result = groupByRank(lottos, winningLotto)
        return result
            .map { (rank, count) -> LottoResult(count, rank) }
            .sortedBy { it.rank.prizeAmount }
    }

    private fun groupByRank(
        lottos: List<Lotto>,
        winningLotto: WinningLotto,
    ): Map<Rank, Int> {
        val result = Rank.entries.filter { it !== Rank.MISS }.associateWith { 0 }
        val rankWithMatchCounts =
            lottos.map { winningLotto.matchLotto(it) }
                .filter { it !== Rank.MISS }
                .groupBy { it }
                .mapValues { (_, values) -> values.size }
        return result.mapValues { (rank, count) -> rankWithMatchCounts[rank] ?: count }
    }
}
