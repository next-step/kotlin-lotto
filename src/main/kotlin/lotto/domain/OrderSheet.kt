package lotto.domain

data class OrderSheet(private val money: Money, val manual: Int, private val cost: Money) {
    val auto = calculateCount(money) - manual
    val totalCost = cost * (auto + manual)

    fun isValid() = auto >= 0

    private fun calculateCount(money: Money): Int {
        return money / cost
    }
}
