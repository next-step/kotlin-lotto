package study.calculator

/**
 * @author 이상준
 */
class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) return 0

        val expression = customDelimiter(text)
        val tokens = expression.numberText.split(expression.delimiter.toRegex())
        return tokens.sumOf {
            if (it.toInt() < 0) {
                throw RuntimeException("음수는 입력할 수 없습니다.")
            }

            it.toInt()
        }
    }

    private fun customDelimiter(text: String): Expression {
        val result = Regex("//(.)\n(.*)").find(text)
        result?.let {
            return Expression(it.groupValues[1], it.groupValues[2])
        }

        return Expression("[,:]", text)
    }

    data class Expression(val delimiter: String, val numberText: String)
}
