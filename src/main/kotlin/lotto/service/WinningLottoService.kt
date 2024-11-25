package lotto.service

import lotto.domain.Order
import lotto.domain.Prize
import lotto.domain.RankResult
import lotto.domain.WinningLotto
import lotto.view.dto.WinningResult

class WinningLottoService {
    private val lottoCreator = LottoCreator()

    fun createWinningLotto(winningNumbers: Set<Int>): WinningLotto {
        return lottoCreator.createWinningLotto(winningNumbers)
    }

    fun checkAndGetResult(
        order: Order,
        winningLotto: WinningLotto,
    ): WinningResult {
        val winningMatchCounts = createRankResults(order, winningLotto)
        val revenue = calculateRevenue(winningMatchCounts)
        val rate = revenue.toDouble() / order.amount.toDouble()

        return WinningResult(winningMatchCounts, revenue, rate)
    }

    private fun calculateRevenue(matchCounts: List<RankResult>): Int {
        return matchCounts.sumOf { it.getTotalPrizeMoney() }
    }

    // 3 ~ 6 순서로 정렬된 List를 반환한다.
    private fun createRankResults(
        order: Order,
        winNumbers: WinningLotto,
    ): List<RankResult> {
        val result = groupByRanks(order, winNumbers)
        return convertToRankResult(result)
    }

    private fun groupByRanks(
        order: Order,
        winNumbers: WinningLotto,
    ): Map<Int, Int> {
        return order.lottos.map { winNumbers.countMatchingNumbers(it) }
            .filter { it >= Prize.RANK_RANGE.first }
            .groupBy { it }
            .mapValues { (_, values) -> values.size }
    }

    private fun convertToRankResult(result: Map<Int, Int>): List<RankResult> {
        return Prize.RANK_RANGE.map { rank ->
            RankResult(
                totalCount = result[rank] ?: 0,
                prize = Prize.findByMatchCount(rank),
            )
        }
            .sortedBy { it.prize.matchCount }
    }
}
