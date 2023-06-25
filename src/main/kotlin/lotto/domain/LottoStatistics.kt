package lotto.domain

class LottoStatistics {
    private val rankFactory = RankFactory()

    fun analyze(lottos: Lottos, winningNumber: WinningNumber): RankFactory {
        process(lottos, winningNumber)
        return rankFactory
    }

    private fun process(lottos: Lottos, winningNumber: WinningNumber) {
        for (lotto in lottos.lottoNumbers) {
            val intersectCount = lotto.findIntersectCount(winningNumber.lastLotto.lottoNumbers)
            val rank = Rank.determineRank(intersectCount, winningNumber, lotto)
            rank?.let { rankFactory.addRank(it) }
        }
    }

    fun getProfitRate(payment: Payment): Double {
        val totalPrize = rankFactory.calculateTotalPrize()
        return (totalPrize / payment.money)
    }
}
