package calculator.util

import calculator.domain.Expression

object SplitUtil {

    private const val SPLIT_DEFAULT = ""

    fun splitExpressionToInts(expression: Expression): List<Int> {
        return expression.value.split(SPLIT_DEFAULT).map { it.toInt() }
    }

}