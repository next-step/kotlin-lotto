package lotto.domain

data class LottoResult(
    val rankCounts: LottoRankCounts,
    val earningRate: EarningRate,
) {
    companion object {
        fun of(winningLotto: WinningLotto, ticket: LottoTicket, ticketPrice: Amount): LottoResult {
            val rankCounts = ticket determineResultBy winningLotto
            val earningRate = EarningRate.of(
                purchasedAmount = ticket calculateTotalPriceBy ticketPrice,
                earningAmount = rankCounts.totalEarningMoney
            )
            return LottoResult(rankCounts, earningRate)
        }

        fun withoutPurchasedTicket(): LottoResult = LottoResult(
            LottoRankCounts(emptyMap()),
            EarningRate(0.00)
        )
    }
}
