package lotto.domain

class AwardResults(
    private val items: List<AwardResult>,
    private val ticketPrice: Int
) {
    private val ticketCount
        get() = items.sumOf { it.matchCount }


    fun profitability(): Double {
        return (items.sumOf { it.sumOfPrize }.toDouble() / (ticketPrice * ticketCount))
    }

    fun matchCount(award: Award): Int {
        return items.filter { it.award == award }
            .sumOf { it.matchCount }
    }
}
