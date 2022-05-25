package lotto.domain

class LottoStatistics(
    private val lottoTickets: List<LottoTicket>,
    private val lastLottoNumbers: Set<Int>
) {

    init {
        require(lottoTickets.isNotEmpty())
    }

    fun getMatchCount(match: LottoMatch): Int = getMatchCount(match.count)

    private fun getMatchCount(matchCount: Int): Int =
        lottoTickets
            .filter { it.numbers.intersect(lastLottoNumbers).size == matchCount }
            .size

    fun getProfit(purchase: Int): Double {
        require(purchase > 0)
        return getRewards().toDouble() / purchase.toDouble()
    }

    private fun getRewards(): Long =
        LottoMatch
            .values()
            .sumOf { getMatchCount(it) * it.reward }
}
