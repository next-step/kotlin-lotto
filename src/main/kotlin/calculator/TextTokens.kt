package calculator

class TextTokens {
    private val tokens: MutableList<PositiveNumber> = arrayListOf()

    fun addToken(token: String) {
        tokens.add(PositiveNumber(token))
    }
}