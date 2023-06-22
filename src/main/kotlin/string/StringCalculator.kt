package string

import string.expression.Expression
import string.splitter.SeparatorStringSplitter

class StringCalculator(
    private val splitters: List<SeparatorStringSplitter>,
) {
    fun sum(strExpression: String?): Int {
        if (strExpression.isNullOrBlank()) {
            return 0
        }

        splitters.forEach {
            val result = it.split(strExpression)
            if (result != null) {
                return Expression(result).sum()
            }
        }
        throw RuntimeException("문자열을 계산할 수 없습니다")
    }
}
