package stringcalculator.domain

class Tokens(
    stringTokens: List<String>,
    val tokens: List<Token> = toTokenList(stringTokens)
) {
    companion object {
        fun toTokenList(stringTokens: List<String>): List<Token> = stringTokens.map { Token(it) }
    }
}
