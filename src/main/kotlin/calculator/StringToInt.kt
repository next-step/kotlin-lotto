package calculator

private const val NULL_OR_EMPTY_VALUE = 0
private const val ZERO = 0

fun parseToInt(string: String?): Int {
    if (string.isNullOrBlank()) {
        return NULL_OR_EMPTY_VALUE
    }

    return try {
        val number = string.toInt()
        validateNegative(number)

        number
    } catch (e: Exception) {
        throw RuntimeException()
    }
}

private fun validateNegative(number: Int) {
    if (number < ZERO) {
        throw RuntimeException()
    }
}
