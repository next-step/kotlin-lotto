package stringcalculator.view

import stringcalculator.domain.StringAddCalculator
import stringcalculator.domain.Tokens

object ResultView {
    fun doResult(tokens: Tokens) {
        println(StringAddCalculator.calculate(tokens))
    }
}
