package lotto.domain

class OrderSheet(money: Money, val manualCount: Int, cost: Money) {
    private val totalCount = money / cost

    val autoCount = totalCount - manualCount
    val totalCost = cost * totalCount

    fun isValid() = autoCount >= 0
}
