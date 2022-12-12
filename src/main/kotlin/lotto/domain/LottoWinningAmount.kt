package lotto.domain

data class LottoWinningAmount(val winningAmountList: Map<Money, Int>) {
    fun amountOf(matchTarget: Int): Money {
        val rewardPrice = LottoReward.getRewardPriceOf(matchTarget)
        val count = winningAmountList[rewardPrice] ?: 0

        val winningAmount = rewardPrice.times(count)

        return Money(winningAmount)
    }

    fun sum(): Money {
        return Money(
            winningAmountList
                .map{ (rewardPrice, count) -> rewardPrice.times(count) }
                .sum()
        )
    }
}
