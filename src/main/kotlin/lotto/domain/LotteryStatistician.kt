package lotto.domain

class LotteryStatistician(
    targetLottoStr: String,
) {
    private val targetLotto = Lotto(targetLottoStr.split(", ").map { it.toInt() })

    fun check(purchaseAmount: Int, lotties: List<Lotto>): WinningStatistics {
        val statistics = LottoRank.entries.associateWith { 0 }.toMutableMap()

        lotties
            .groupingBy { LottoRank.of(it.matchCount(targetLotto)) }
            .eachCount()
            .forEach { (rank, count) -> rank?.let { statistics[it] = count } }

        return WinningStatistics(
            purchaseAmount = purchaseAmount,
            statistics = statistics,
        )
    }

    private fun Lotto.matchCount(lotto: Lotto): Int {
        return this.numbers.count { it in lotto.numbers }
    }

}
