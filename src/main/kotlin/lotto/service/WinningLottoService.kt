package lotto.service

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.Order
import lotto.domain.Rank
import lotto.domain.WinningLotto
import lotto.view.dto.WinningResult
import kotlin.math.roundToInt

class WinningLottoService {
    private val lottoCreator = LottoCreator()

    fun createWinningLotto(
        winningNumbers: Set<Int>,
        bonusNumber: Int,
    ): WinningLotto {
        return lottoCreator.createWinningLotto(winningNumbers, bonusNumber)
    }

    fun checkAndGetResult(
        order: Order,
        winningLotto: WinningLotto,
    ): WinningResult {
        val winningMatchCounts = aggregateLottoResult(order.lottos, winningLotto)
        val revenue = calculateRevenue(winningMatchCounts)
        val rate = (revenue.toDouble() / order.amount.toDouble()).roundToInt()

        return WinningResult(winningMatchCounts, revenue, rate)
    }

    private fun calculateRevenue(matchCounts: List<LottoResult>): Int {
        return matchCounts.sumOf { it.getTotalPrizeMoney() }
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
        val data =
            lottos.map {
                Rank.findByMatchCount(
                    winningLotto.countMatchingNumbers(it),
                    winningLotto.matchBonusNumber(it),
                )
            }
                .filter { it !== Rank.MISS }
                .groupBy { it }
                .mapValues { (_, values) -> values.size }
        return result.mapValues { (rank, count) -> data[rank] ?: count }
    }
}
