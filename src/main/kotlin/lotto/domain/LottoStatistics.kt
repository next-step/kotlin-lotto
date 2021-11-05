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

        fun from(tickets: LottoTickets, winning: LottoNumbers): LottoStatistics {
            val statistics = tickets.countRankingFrom(winning)
            val statisticsWithDefault = LottoRanking.values()
                .associateWith { statistics[it] ?: DEFAULT_RANKING_COUNT }
            return LottoStatistics(tickets.count(), statisticsWithDefault)
        }
    }
}
