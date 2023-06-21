package lotto.domain

class LottoStatistics {
    fun analyze(lottos: Lottos, winningNumber: WinningNumber): List<Rank> {
        return Rank.values()
            .map {
                it.getRank(lottos, winningNumber)
            }
            .toList()
    }

    fun getProfitRate(payment: Payment, ranks: List<Rank>): Double {
        var sumAmount = 0.0
        for (rank in ranks) {
            sumAmount += (rank.winningMoney * rank.count).toInt()
        }
        return (sumAmount / payment.money)
    }
}
