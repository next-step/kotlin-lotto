package calculator.domain

data class OperationTokens(
    val tokenList: List<String>
) {

    fun sum() = tokenList.sumOf { it.toInt() }
}
