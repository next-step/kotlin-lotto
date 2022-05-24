package lotto.domain

class LottoStatistics(
    private val lottoTickets: List<LottoTicket>,
    private val lastLottoNumbers: Set<Int>
) {

    init {
        require(lottoTickets.isNotEmpty())
    }

    fun getMatchCount(match: LottoMatch): Int {
        return when (match) {
            LottoMatch.THREE -> {
                lottoTickets
                    .filter { it.numbers.intersect(lastLottoNumbers).size == match.count }
                    .size
            }
            LottoMatch.FOUR -> {
                lottoTickets
                    .filter { it.numbers.intersect(lastLottoNumbers).size == match.count }
                    .size
            }
            LottoMatch.FIVE -> {
                lottoTickets
                    .filter { it.numbers.intersect(lastLottoNumbers).size == match.count }
                    .size
            }
            LottoMatch.SIX -> {
                lottoTickets
                    .filter { it.numbers.intersect(lastLottoNumbers).size == match.count }
                    .size
            }
        }
    }

    fun getProfit(purchase: Int): Double {
        require(purchase > 0)
        return getRewards().toDouble() / purchase.toDouble()
    }

    private fun getRewards(): Long {
        return LottoMatch
            .values()
            .sumOf { getMatchCount(it) * it.reward }
    }
}
