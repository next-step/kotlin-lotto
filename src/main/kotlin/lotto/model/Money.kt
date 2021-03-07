package lotto.model

class Money(private val amount: Int) {
    fun dividedBy(price: Money): Int {
        return amount / price.amount
    }

    companion object {
        fun zero(): Money {
            return Money(0)
        }
    }
}
