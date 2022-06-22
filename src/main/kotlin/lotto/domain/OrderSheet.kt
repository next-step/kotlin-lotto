package lotto.domain

sealed class OrderSheet {
    object Invalid : OrderSheet()
    data class Valid(val autoCount: Int, val manualCount: Int, val totalCost: Money) : OrderSheet()

    companion object {
        fun order(money: Money, manualCount: Int, cost: Money): OrderSheet {
            val totalCount = money / cost
            val autoCount = totalCount - manualCount
            val totalCost = cost * totalCount

            return if (autoCount >= 0) {
                Valid(autoCount, manualCount, totalCost)
            } else {
                Invalid
            }
        }
    }
}
