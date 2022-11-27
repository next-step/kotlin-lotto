package calculator.util

import calculator.EMPTY_STRING
import calculator.domain.Expression

object SplitUtil {

    private const val SPLIT_DEFAULT = ""

    fun splitExpressionToInts(expression: Expression): List<Int> {
        return expression.value.split(SPLIT_DEFAULT).map { input ->
            if (input == EMPTY_STRING) 0
            else input.toInt()
        }
    }

}