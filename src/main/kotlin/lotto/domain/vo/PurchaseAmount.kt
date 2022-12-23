package lotto.domain.vo

@JvmInline
value class PurchaseAmount(val amount: Int) {
    init {
        require(amount >= MIN_VALUE) { "amount should be at least $MIN_VALUE" }
        require(amount % MIN_VALUE == 0) { "amount should be in units of $MIN_VALUE" }
    }

    operator fun minus(amount: Int) = PurchaseAmount(this.amount - amount)

    operator fun div(price: Int): Int = amount / price

    companion object {
        private const val MIN_VALUE: Int = 1000
    }
}
