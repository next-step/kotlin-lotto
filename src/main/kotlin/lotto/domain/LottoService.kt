package lotto.domain

class LottoService(
    private val lottoStore: LottoStore,
    private val prizeCalculator: PrizeCalculator,
) {
    fun playLottoGame(
        tickets: List<Lotto>,
        purchaseAmount: Int,
        lottoMatcher: LottoMatcher,
    ): LottoResult {
        val statistics =
            tickets.groupBy { lottoMatcher.match(it) }
                .mapValues { it.value.size }

        val totalPrize = prizeCalculator.calculateTotalPrize(statistics)
        return LottoResult(statistics, totalPrize, purchaseAmount)
    }

    fun generateTickets(purchaseAmount: Int): List<Lotto> {
        return lottoStore.sell(purchaseAmount)
    }
}
