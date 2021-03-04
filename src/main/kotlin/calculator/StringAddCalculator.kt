package calculator

import calculator.adder.Adder
import calculator.separator.Separator

class StringAddCalculator(private val adder: Adder) {
    fun calculate(expression: String?): Int {
        val separate = Separator.separate(expression)
        return adder.sum(separate)
    }
}
