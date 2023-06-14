package stringAddCalculator

import java.lang.RuntimeException

class StringAddCalculator(
    private var expression: String,
    private var delimiters: List<String> = listOf(DELIMITER_COMMA, DELIMITER_COLON),
) {
    private var numbers: List<Int>

    init {
        // 1) custom delimiter 파싱 및 delimiter, expression 업데이트
        Regex("//(.)\n(.*)").find(expression)?.let {
            val customDelimiter = it.groupValues[1]
            val filteredExpression = it.groupValues[2]
            delimiters = delimiters.plus(customDelimiter)
            expression = filteredExpression
        }

        // 2) delimiter 문자열 계산
        val delimiterStr = delimiters.reduce { acc, s -> "$acc|$s" }

        // 3) parse numbers
        val numbers = expression.split(delimiterStr.toRegex()).map { number -> number.toInt() }

        // 4) 음수 혹은 문자인 경우 에러 발생
        if (numbers.any { Integer.signum(it) != POSITIVE_NUMBER_RESULT }) throw RuntimeException(CalcErrorCode.INVALID_NUMBER.msg)

        this.numbers = numbers
    }

    fun calculate(): Int {
        return numbers.reduce { acc, c -> acc + c }
    }

    companion object {
        const val DELIMITER_COMMA = ","
        const val DELIMITER_COLON = ":"
        const val POSITIVE_NUMBER_RESULT = 1
    }
}
