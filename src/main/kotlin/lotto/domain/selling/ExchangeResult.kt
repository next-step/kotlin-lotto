package lotto.domain.selling

data class ExchangeResult(val details: Map<Int, Int>) {
    private val totalPrizeMoney = details.toSortedMap().entries.sumBy { findPrizeMoney(it.key) }

    fun calculateRateOfReturn(): Float {
        val origin = details.entries.sumBy { it.value } * Seller.LOTTO_PRICE
        return totalPrizeMoney.toFloat() / origin
    }

    companion object {
        private val PRIZE_MONEY = hashMapOf(3 to 5000, 4 to 50000, 5 to 1_500_000, 6 to 2_000_000_000)

        fun findPrizeMoney(matchCount: Int) = PRIZE_MONEY[matchCount] ?: 0
    }
}
