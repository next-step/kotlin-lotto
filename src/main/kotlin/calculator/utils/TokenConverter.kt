package calculator.utils

object TokenConverter {
    fun convertToInt(tokens: List<String>): List<Int> {
        return try {
            tokens.map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw RuntimeException("Invalid token: $tokens")
        }
    }
}
