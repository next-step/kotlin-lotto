package calculator.domain

data class OperationTokens(
    val tokenList: List<String>
) {
    init {
        if (!isTokensValid()) throw InvalidOperationTokenException()
    }

    fun sum() = tokenList.sumOf { it.toInt() }

    private fun isTokensValid(): Boolean {
        return tokenList.all { token ->
            val intToken = token.toIntOrNull()
            intToken != null && intToken >= 0
        }
    }
}
