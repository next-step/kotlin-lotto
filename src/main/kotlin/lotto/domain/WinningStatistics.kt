package lotto.domain

class WinningStatistics(private val prizesCount: MutableMap<MatchPrize, Int> = mutableMapOf()) {
    fun add(matches: Int, bonusMatches: Boolean) {
        val prize = MatchPrize.prizeFor(matches, bonusMatches) ?: return
        prizesCount[prize] = (prizesCount[prize] ?: 0) + 1
    }

    fun get(matches: Int, bonusMatches: Boolean): Int {
        val prize = MatchPrize.prizeFor(matches, bonusMatches)
        return prizesCount[prize] ?: 0
    }

    fun yieldRate(amountOfTicket: Int): Double {
        val amountOfPurchase = amountOfTicket * LottoShop.PRICE_FOR_ONT_TICKET
        val returnPrice = calculateReturnPrice()
        return "%.2f".format(returnPrice.toDouble() / amountOfPurchase).toDouble()
    }

    private fun calculateReturnPrice(): Long {
        var sum: Long = 0
        for ((prize, count) in prizesCount) {
            sum += (prize.price * count)
        }
        return sum
    }
}
