package stringAddCalculator

data class Tokens(
    val tokens: List<Token>
) {
    fun sum(): Int {
        return tokens.sumOf { it.value }
    }
}
