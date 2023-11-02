package calculator

data class ParsedTokens(val tokenList: List<Token>) {
    val result: Int = tokenList.sumOf { it.number }
}
