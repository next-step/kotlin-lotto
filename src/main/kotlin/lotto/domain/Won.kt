package lotto.domain

@JvmInline
value class Won(
    val amount: Long,
) {
    init {
        require(amount >= 0) { "Amount of money should be non negative." }
    }

    operator fun plus(other: Won): Won = Won(amount + other.amount)

    operator fun div(other: Won): Won {
        require(other.amount != 0L) { "Division by zero." }

        return Won(amount / other.amount)
    }
}
