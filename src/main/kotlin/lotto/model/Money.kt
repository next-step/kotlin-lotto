package lotto.model

private const val LOTTO_PRICE = 1_000

data class Money(val money: Int) {
    fun canBuyLotto(): Boolean {
        return money > LOTTO_PRICE
    }

    fun purchasableLotto(): Int {
        return Math.floorDiv(money, LOTTO_PRICE)
    }

    fun hasMoney(): Boolean = money > 0

    companion object {
        fun calculateRate(wins: List<Money>): Double {

            val totalPrize = wins.sumBy { it.money }.toDouble()
            val paidMoney = wins.size * LOTTO_PRICE.toDouble()

            return totalPrize / paidMoney
        }
    }
}
