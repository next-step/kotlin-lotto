package lotto.domain

class Lottos(private val lottos: List<Lotto>) {
    fun calculatePurchaseAmount() = Money(lottos.size * LOTTO_PRICE)

    fun calculateWinningAmountStatistics(winningLotto: Lotto): Map<Money, Int> {
        var winningAmountMap = LottoReward.values().associate { it.rewardPrice to 0 }.toMap()

        lottos.forEach {
            var lottoReward = getLottoReward(it, winningLotto)
            winningAmountMap = winningAmountMap + Pair(lottoReward, 1)
        }

        return winningAmountMap
    }

    private fun getLottoReward(purchaseLotto: Lotto, winningLotto: Lotto): Money {
        val matchCount = calculateMatchCount(purchaseLotto, winningLotto)

        return LottoReward.getRewardPriceOf(matchCount)
    }

    private fun calculateMatchCount(purchaseLotto: Lotto, winningLotto: Lotto): Int {
        return LottoNumbersMatcher.calculateMatchCount(purchaseLotto, winningLotto)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}