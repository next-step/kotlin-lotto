package stringAddCalculator.customDelimiter

class DoubleSlashAndNewLineDelimiter : CustomDelimiter {
    override val regex: Regex = regexPattern

    override fun parse(expression: String): ParserResult? {
        return regex.find(expression)?.let {
            val customDelimiter = it.groupValues[1] // 숫자 영역
            val filteredExpression = it.groupValues[2] // custom delimiter
            ParserResult(filteredExpression, customDelimiter)
        }
    }

    companion object {
        @JvmField
        val regexPattern: Regex = Regex("//(.)\n(.*)")
    }
}
