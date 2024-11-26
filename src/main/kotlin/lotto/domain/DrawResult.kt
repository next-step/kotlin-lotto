package lotto.domain

data class DrawResult(private val rankRewardLottoCountMap: Map<RankReward, LottoCount>) {
    fun getProfitRate(purchaseAmount: Money): Double {
        return getTotalReward() / purchaseAmount
    }

    fun findLottoCount(rankReward: RankReward): LottoCount {
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
                    .mapNotNull { lotto ->
                        val matchedNumberCount = winningLotto.countMatchedNumber(lotto)
                        RankReward.fromMatchedNumberCount(matchedNumberCount)
                    }
                    .groupingBy { it }
                    .eachCount()
                    .mapValues { LottoCount(it.value) }
            return DrawResult(rankRewardLottoCountMap)
        }
    }
}
