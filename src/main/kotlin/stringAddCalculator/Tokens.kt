package stringAddCalculator

data class Tokens(
    val values: List<Token>
) {
    fun sum(): Int {
        return values.sumOf { it.value }
    }
}
