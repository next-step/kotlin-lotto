package lotto.domain

class WinningStatistics(private val matchesCount: MutableMap<Int, Int> = mutableMapOf()) {
    private var rate: Double = 0.0

    companion object {
        val matchesPrice: Map<Int, Long> = mapOf(
            3 to 5_000,
            4 to 50_000,
            5 to 1_500_000,
            6 to 20_000_000_000
        )
    }

    fun add(matches: Int) {
        matchesCount[matches] = (matchesCount[matches] ?: 0) + 1
    }

    fun get(matches: Int): Int {
        return matchesCount[matches] ?: 0
    }

    fun setRate(amountOfTicket: Int) {
        val amountOfPurchase = amountOfTicket * PRICE_FOR_ONT_TICKET
        val returnPrice = calculateReturnPrice()
        this.rate = "%.2f".format(returnPrice.toDouble() / amountOfPurchase).toDouble()
    }

    private fun calculateReturnPrice(): Long {
        var sum: Long = 0
        for ((matches, count) in matchesCount) {
            val prize = matchesPrice[matches] ?: 0
            sum += (prize * count)
        }
        return sum
    }

    fun getRate(): Double {
        return rate
    }
}
