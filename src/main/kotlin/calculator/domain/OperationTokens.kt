package calculator.domain

data class OperationTokens(
    val tokenList: List<String>
) {
    init {
        if (!tokenList.all { token -> token.toIntOrNull() != null }) throw InvalidOperationTokenException()
    }

    fun sum() = tokenList.sumOf { it.toInt() }
}
