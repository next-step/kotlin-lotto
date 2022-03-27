package lotto.domain

import lotto.util.filterNotNull

class LottoResult(
    private val originalPrice: Int,
    private val matchResult: List<Int>
) {

    fun statistics(): LottoStatistics =
        matchResult
            .groupingBy { Prize.of(it) }
            .eachCount()
            .filterNotNull()

    fun profit(): Double {
        val statistics = statistics()
        val earned = statistics
            .map { (prize, count) -> (prize.money) * count }
            .sum()
        return earned.toDouble().div(originalPrice)
    }
}
