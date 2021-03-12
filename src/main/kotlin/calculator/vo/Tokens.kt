package calculator.vo

data class Tokens(val tokens: List<Token>) {
    fun sum(): Int {
        return tokens.sumBy { it.token }
    }
}
