package lotto.domain

class LottoResult(
    private val originalPrice: Int,
    private val matchResult: List<Int>
) {

    private fun same(count: Int): Int {
        return matchResult.count { it == count }
    }

    fun statistics(): List<LottoStatistics> {
        val prizes = Prize.all()
        val statistics = mutableListOf<LottoStatistics>()
        for (prize in prizes) {
            val count = same(prize.matchCount)
            statistics.add(LottoStatistics(prize, count))
        }
        return statistics
    }

    fun profit(): Double {
        val statistics = statistics()
        val earned = statistics.map { it.prize.money * it.count }.sum()
        return earned.toDouble().div(originalPrice)
    }
}
