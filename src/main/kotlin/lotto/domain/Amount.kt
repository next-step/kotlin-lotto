package lotto.domain

class Amount(
    private val money: Money,
) {
    init {
        require(money in MINIMUM_AMOUNT..MAXIMUM_AMOUNT) {
            "Amount value must be between 0 and 100,000 KRW"
        }
    }

    constructor(value: Int) : this(Money(value))

    fun countPurchasable(amount: Int) = money.getAffordableQuantity(amount.toBigDecimal())

    fun spend(amount: Int): Amount {
        return Amount(money - amount.toBigDecimal())
    }

    companion object {
        private val MINIMUM_AMOUNT = Money(0)
        private val MAXIMUM_AMOUNT = Money(100_000)
    }
}
