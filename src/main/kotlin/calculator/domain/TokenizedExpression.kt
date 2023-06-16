package calculator.domain

import java.lang.RuntimeException

object TokenizedExpression {
    private const val MESSAGE_CONTAIN_NEGATIVE = "음수가 포함되어 있습니다."
    fun generate(text: String, separators: Separators): List<String> {
        val separatorList = separators.separators.map { it.separator }
        println(separatorList)
        val regexPattern = separatorList.joinToString("|").toRegex()
        val splitData = text.split(regexPattern)
        validateNegative(splitData)
        return splitData
    }

    private fun validateNegative(splitData: List<String>) {
        if (splitData.any { it.toInt() < 0 }) {
            throw RuntimeException(MESSAGE_CONTAIN_NEGATIVE)
        }
    }
}
