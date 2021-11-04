package lotto.domain

class LottoStatistics(val ticketCount: LottoTicketCount, val countByRanking: Map<LottoRanking, Int>) {

    val revenue: Double
        get() {
            val spent = LottoMoney.calculatePrice(ticketCount)
            val reward = calculateReward()
            return reward.toDouble() / spent.value
        }

    private fun calculateReward(): Long {
        return countByRanking.map { (ranking, count) -> ranking.reward * count }.sum()
    }

    companion object {

        private const val DEFAULT_RANKING_COUNT = 0

        fun from(tickets: List<LottoNumbers>, winning: LottoNumbers): LottoStatistics {
            return LottoStatistics(LottoTicketCount(tickets.size), countRankingFrom(tickets, winning))
        }

        private fun countRankingFrom(tickets: List<LottoNumbers>, winning: LottoNumbers): Map<LottoRanking, Int> {
            val statistics = tickets.mapNotNull { it.findRankingBy(winning) }
                .groupingBy { it }
                .eachCount()
            return LottoRanking.values()
                .associateWith { statistics[it] ?: DEFAULT_RANKING_COUNT }
        }

        private fun LottoNumbers.findRankingBy(winning: LottoNumbers): LottoRanking? =
            LottoRanking.from(winning.countSameNumber(this))
    }
}
