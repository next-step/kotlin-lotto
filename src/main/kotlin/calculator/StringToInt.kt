package calculator

const val NULL_OR_EMPTY_VALUE = 0

fun parseToInt(string: String?): Int {
    if (string.isNullOrBlank()) {
        return NULL_OR_EMPTY_VALUE
    }

    return try {
        validateNegative(string.toInt())
    } catch (e: Exception) {
        throw RuntimeException()
    }
}

fun validateNegative(toInt: Int): Int {
    if (toInt < 0) {
        throw java.lang.RuntimeException()
    }
    return toInt
}
