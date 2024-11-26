package calculator

class TextTokens {
    private val tokens: MutableList<PositiveNumber> = ArrayList()

    fun addToken(token: String) {
        tokens.add(PositiveNumber.of(token))
    }

    fun findToken(): List<PositiveNumber> {
        return tokens
    }
}