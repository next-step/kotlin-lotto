package lotto.domain

class LottoStatistics {
    fun analyze(lottos: Lottos, winnerNumbers: List<LottoNumber>): List<Rank> {
        val ranks = mutableListOf<Rank>()
        for (rank in Rank.values()) {
            rank.getRank(lottos, winnerNumbers)
            ranks.add(rank)
        }
        return ranks
    }

    fun getProfitRate(payment: Payment, ranks: List<Rank>): Double {
        var sumAmount = 0.0
        for (rank in ranks) {
            sumAmount += (rank.amount * rank.count).toInt()
        }
        return (sumAmount / payment.money)
    }
}
