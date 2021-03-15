package stringcalculator.domain

class Tokens private constructor(stringTokens: List<String>) {
    val tokens: List<Token> = stringTokens.map { Token.from(it) }

    companion object {
        fun from(stringTokens: List<String>): Tokens = Tokens(stringTokens)
    }
}
