package calculator.domain

object TokenizedExpression {
    private const val MESSAGE_CONTAIN_NEGATIVE = "음수가 포함되어 있습니다."

    fun generate(text: String): List<String> {
        val regexResult = Regex("""(?:\/\/(.)\n)*(.*)""").find(text)
        return regexResult?.let {
            val customDelimiter = it.groupValues[1]
            val tokens = it.groupValues[2].split("[,:$customDelimiter]".toRegex())
            validateNegative(tokens)
            tokens
        } ?: listOf()
    }

    private fun validateNegative(splitData: List<String>) {
        require(splitData.any { it.toInt() >= 0 }) {
            MESSAGE_CONTAIN_NEGATIVE
        }
    }
}
