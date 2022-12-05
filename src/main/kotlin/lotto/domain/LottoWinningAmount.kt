package lotto.domain

data class LottoWinningAmount(val winningAmountList: Map<Money, Int>) {
    fun amountOf(matchTarget: Int): Money {
        val rewardPrice = LottoReward.of(matchTarget).rewardPrice
        val count = winningAmountList[rewardPrice] ?: 0
        val targetWinningAmount = rewardPrice.times(count)

        return Money(targetWinningAmount)
    }

    fun sum(): Money {
        val winningAmount = winningAmountList.map { (rewardPrice, count) ->
            rewardPrice * count
        }.sum()

        return Money(winningAmount)
    }
}
