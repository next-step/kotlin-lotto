package calculator

class TokenConverter(tokens: List<String>) {
    companion object {
        fun convertToInt(tokens: List<String>): List<Int> {
            return try {
                tokens.map { it.toInt() }
            } catch (e: NumberFormatException) {
                throw RuntimeException("Invalid token: $tokens")
            }
        }
    }
}
