package calculator

import calculator.Numeric.Companion.validCheck

class Calculator {

    fun calculate(expression: String) =
        Separator.separate(expression)
            .let { Numeric.convertNumeric(it).validCheck() }
            .let { it.sum() }
}
