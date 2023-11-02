package calculator.model

data class Token(
    val value: Int,
) {
    fun add(token: Token): Token {
        return Token(value + token.value)
    }
}
