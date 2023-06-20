package lotto.domain

class LottoStatistics {
    fun analyze(lottos: Lottos, winnerNumbers: List<LottoNumber>): List<Rank> {
        return Rank.values()
            .map {
                it.getRank(lottos, winnerNumbers)
            }
            .toList()
    }

    fun getProfitRate(payment: Payment, ranks: List<Rank>): Double {
        var sumAmount = 0.0
        for (rank in ranks) {
            sumAmount += (rank.amount * rank.count).toInt()
        }
        return (sumAmount / payment.money)
    }
}
