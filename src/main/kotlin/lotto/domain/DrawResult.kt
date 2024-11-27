package lotto.domain

data class DrawResult(private val rankRewardLottoCountMap: Map<RankReward, LottoCount>) {
    fun getProfitRate(purchaseAmount: Money): Double {
        return getTotalReward() / purchaseAmount
    }

    fun getLottoCount(rankReward: RankReward): LottoCount {
        return rankRewardLottoCountMap[rankReward] ?: LottoCount(0)
    }

    private fun getTotalReward(): Money {
        return rankRewardLottoCountMap.entries.fold(Money.ZERO) { total: Money, (rankReward: RankReward, lottoCount: LottoCount) ->
            val totalRewardPerRank: Money = rankReward.money * lottoCount.count
            total + totalRewardPerRank
        }
    }

    companion object {
        fun from(
            winningLotto: WinningLotto,
            purchaseLotteries: List<Lotto>,
        ): DrawResult {
            val rankRewardLottoCountMap =
                purchaseLotteries
                    .map { lotto ->
                        val matchedNumberCount = winningLotto.countMatchedNumber(lotto)
                        val isMatchBonus = winningLotto.isMatchBonus(lotto)
                        RankReward.valueOf(matchedNumberCount, isMatchBonus)
                    }
                    .groupingBy { it }
                    .eachCount()
                    .mapValues { LottoCount(it.value) }
            return DrawResult(rankRewardLottoCountMap)
        }
    }
}
