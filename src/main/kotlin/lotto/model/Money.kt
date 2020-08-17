package lotto.model

private const val LOTTO_PRICE = 1_000
const val MINIMUM_LOTTO_COUNT = 1

data class Money(val money: Int) {
    fun canBuyLotto(count: Int): Boolean {
        return money >= LOTTO_PRICE * count
    }

    fun spend(buyingLotto: Int): Money {
        return copy(money = money - LOTTO_PRICE * buyingLotto)
    }

    fun buyMaxLottoCount(): Int {
        return Math.floorDiv(money, LOTTO_PRICE)
    }

    fun hasMoney(): Boolean = money > 0

    companion object {
        fun calculateRate(wins: List<Win>): Double {
            val money = wins.map { it.prize }
            val totalPrize = money.sumBy { it.money }.toDouble()
            val paidMoney = wins.size * LOTTO_PRICE.toDouble()

            return totalPrize / paidMoney
        }
    }
}
