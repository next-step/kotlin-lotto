package calculator.vo

data class Tokens(val tokens: List<Token>) {
    fun sum(): Int {
        return tokens.sumBy { it.token }
    }

    companion object {
        fun of(strNums: List<String>): Tokens {
            return Tokens(strNums.map { Token.of(it) })
        }
    }
}
