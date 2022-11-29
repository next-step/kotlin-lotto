package lotto.domain

data class Cash(val amount: Int) {
    init {
        require(amount >= 0)
    }

    fun pay(amount: Int): Cash = Cash(this.amount.minus(amount))
}
