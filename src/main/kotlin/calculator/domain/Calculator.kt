package calculator.domain

object Calculator {
    fun calculate(tokens: List<String>): Int {
        tokens.forEach { validatePositiveNumber(it) }

        return tokens.sumOf { it.toInt() }
    }

    private fun validatePositiveNumber(token: String) {
        if (!token.all { Character.isDigit(it) }) {
            throw RuntimeException("token should be positive number. invalid token: $token")
        }
    }
}
