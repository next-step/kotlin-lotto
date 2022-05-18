package lotto.domain

import lotto.domain.LottoSeller.Companion.rewardPriceMap

class LottoMatchResult(
    private val winningLotto: WinningLotto,
    private val lottoList: List<Lotto>
) {

    private val matchingMap: Map<Int, Int> = lottoList
        .map { it.match(winningLotto) }
        .groupingBy { it.size }
        .eachCount()

    private val revenue = matchingMap
        .entries
        .sumOf { (matchingCount, count) -> rewardPrice(matchingCount) * count }

    fun matchingCountBy(matchingCount: Int): Int {
        return matchingMap.getOrDefault(matchingCount, 0)
    }

    fun rateOfReturn(): String {
        val totalPrice = LottoSeller.LOTTO_PRICE * lottoList.size
        return String.format("%.2f", revenue.toDouble() / totalPrice.toDouble())
    }

    private fun rewardPrice(matchingCount: Int): Long {
        return rewardPriceMap.getOrDefault(matchingCount, 0)
    }
}
