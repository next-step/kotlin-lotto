package lotto.model

class Money(val amount: Int) {
    fun dividedBy(price: Money): Int {
        return amount / price.amount
    }
}
