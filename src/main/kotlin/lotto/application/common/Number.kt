package lotto.application.common

data class Number(
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
}
