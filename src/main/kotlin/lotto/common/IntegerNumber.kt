package lotto.common

data class IntegerNumber(
    val number: Int
) {
    fun isPositive(): Boolean {
        return number > 0
    }

    fun isNegative(): Boolean {
        return number < 0
    }

    fun toDouble(): Double {
        return number.toDouble()
    }

    fun divide(other: IntegerNumber): IntegerNumber {
        return IntegerNumber(number.div(other.number))
    }
}
