package study.lotto.domain

data class Amount(val amount: Int) {
    init {
        require(amount >= 0) { "Amount must be a positive value." }
    }

    operator fun plus(other: Amount) = Amount(this.amount + other.amount)
    operator fun compareTo(amount: Int): Int = this.amount - amount
    operator fun div(pricePerTicket: Int): Int = this.amount / pricePerTicket

    companion object {
        val ZERO = Amount(0)
    }
}
