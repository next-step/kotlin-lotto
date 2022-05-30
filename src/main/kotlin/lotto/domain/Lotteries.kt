package lotto.domain

data class Lotteries(val elements: List<Lotto>) {

    constructor(numberOfTickets: Int, generatingFunction: () -> Set<Int>) : this(
        List(numberOfTickets) { Lotto(generatingFunction()) }
    )

    fun count() = elements.size

    fun forEach(lambda: (lotto: Lotto) -> Unit) = elements.forEach { lambda(it) }

    fun <T> groupBy(lambda: (lotto: Lotto) -> T) = elements.groupBy(lambda).mapValues { Lotteries(it.value) }

    fun getProfit(investment: Int, winner: Lotto, bonusNumber: Int): Profit {
        val priceGroupedLotteries = getPriceGroupedLotteries(winner, bonusNumber)
        return Profit(
            priceGroupedLotteries,
            getEarningRate(investment, priceGroupedLotteries)
        )
    }

    fun getPriceGroupedLotteries(winner: Lotto, bonusNumber: Int): Map<Price, Lotteries> {
        return groupBy {
            it.checkResult(winner, bonusNumber)
        }
    }

    fun getEarningRate(
        investment: Int,
        priceGroupedLotteries: Map<Price, Lotteries>
    ): Float {
        val profit = priceGroupedLotteries.map { entry -> entry.key.winningPrize * entry.value.count() }.sum()

        return profit.toFloat().div(investment)
    }
}
