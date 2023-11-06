package lotto.domain

class LottoRank(matchResults: List<MatchResult>, private val ticketAmount: Amount) {

    private val lottoPrizes: List<LottoPrize> = matchResults.map { it.lottiPrize }

    fun getWinningCount(): Map<LottoPrize, Int> = lottoPrizes.groupingBy { it }.eachCount()

    fun getProfitRate(): ProfitRate {
        val totalPrize = lottoPrizes.map { it.amount }
            .reduce { acc, lottoPrize -> acc + lottoPrize }

        return ProfitRate(totalPrize, ticketAmount)
    }
}
