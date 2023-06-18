package calculator.domain

object TokenizedExpression {
    private const val MESSAGE_CONTAIN_NEGATIVE = "음수가 포함되어 있습니다."

    fun generate(text: String, separators: Separators): List<String> {
        val separatorList = separators.getSeparators().map { it.separator }
        val regexPattern = separatorList.joinToString("|").toRegex()
        val splitData = text.split(regexPattern)
        validateNegative(splitData)
        return splitData
    }

    private fun validateNegative(splitData: List<String>) {
        println(splitData)
        require(splitData.any { it.toInt() >= 0 }) {
            MESSAGE_CONTAIN_NEGATIVE
        }
    }
}
