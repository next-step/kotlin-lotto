package calculator

import calculator.Numeric.Companion.validCheck

object Calculator {

    fun calculate(expression: String) =
        Separator.separate(expression)
            .let { Numeric.convertNumeric(it).validCheck() }
            .sum()
}
