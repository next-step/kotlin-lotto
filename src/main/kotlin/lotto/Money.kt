package lotto

data class Money(val amount: Int) {
    operator fun div(divisor: Money): Int {
        require(divisor.amount != 0)
        return amount / divisor.amount
    }

    operator fun times(other: Int): Int = amount * other
}
