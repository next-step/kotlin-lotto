package lotto.domain

data class Money(
    val amount: Int
) {
    fun isPositive(): Boolean {
        return amount > 0
    }

    override fun toString(): String {
        return "$amount"
    }
}
