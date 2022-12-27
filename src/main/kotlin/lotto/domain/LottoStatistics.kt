package lotto.domain

object LottoStatistics {
    fun getRateOfReturn(rank: Map<Int, Int>, purchasedPrice: Int): Float {
        val totalWinningAmount = rank.entries
            .sumOf {
                (WinningAmount.from(it.key).amount * it.value)
            }

        return totalWinningAmount.toFloat() / purchasedPrice.toFloat()
    }
}
