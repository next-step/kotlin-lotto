package lotto.domain

class Amount(
    private var money: Money,
) {
    init {
        require(money in MINIMUM_AMOUNT..MAXIMUM_AMOUNT) {
            "Amount value must be between 1,000 and 100,000 KRW"
        }
    }

    constructor(value: Int) : this(Money(value))

    fun countPurchasable(amount: Int) = (money / amount.toBigDecimal()).toInt()

    fun spend(amount: Int) {
        this.money -= amount.toBigDecimal()
    }

    companion object {
        private val MINIMUM_AMOUNT = Money(1_000)
        private val MAXIMUM_AMOUNT = Money(100_000)
    }
}
