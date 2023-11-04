package lotto.domain

class LottoRank(matchingCount: List<Int>) {

    private val lottoPrizes: List<LottoPrize> = matchingCount.map { LottoPrize.from(it) }

    fun getWinningCount(): Map<LottoPrize, Int> = lottoPrizes.groupingBy { it }.eachCount()

    fun getProfitRate(purchaseAmount: Amount): ProfitRate {
        val totalPrize = lottoPrizes.map { it.amount }
            .reduce { acc, lottoPrize -> acc + lottoPrize }

        return ProfitRate(totalPrize, purchaseAmount)
    }
}
