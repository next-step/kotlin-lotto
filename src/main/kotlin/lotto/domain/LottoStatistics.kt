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
            val rank = determineRank(intersectCount, winningNumber, lotto)
            rank?.let { rankFactory.addRank(it) }
        }
    }

    private fun determineRank(
        intersectCount: Int,
        winningNumber: WinningNumber,
        lotto: Lotto
    ): Rank? {
        return when {
            intersectCount == Rank.SECOND.matchCount && winningNumber.bonusNumber in lotto.lottoNumbers -> Rank.SECOND
            intersectCount == Rank.THIRD.matchCount -> Rank.THIRD
            intersectCount == Rank.FOURTH.matchCount -> Rank.FOURTH
            intersectCount == Rank.FIFTH.matchCount -> Rank.FIFTH
            else -> null
        }
    }

    fun getProfitRate(payment: Payment): Double {
        val totalPrize = rankFactory.calculateTotalPrize()
        return (totalPrize / payment.money)
    }
}
