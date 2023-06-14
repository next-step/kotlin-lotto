package stringAddCalculator.customDelimiter

/**
 * CustomDelimiter 의 확장예시로 요구사항과는 상관이 없습니다.
 */
class DoubleAsteriskDelimiter : CustomDelimiter {
    override val regex: Regex = Regex(regexPattern)

    override fun parse(expression: String): ParserResult? {
        return regex.find(expression)?.let {
            val filteredExpression = it.groupValues[1] // 숫자 영역
            val customDelimiter = it.groupValues[2] // custom delimiter
            ParserResult(filteredExpression, customDelimiter)
        }
    }

    companion object {
        const val regexPattern = "(.*)\\*\\*(.)"
    }
}
