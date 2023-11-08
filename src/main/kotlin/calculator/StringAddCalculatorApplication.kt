package calculator

import calculator.domain.StringAddCalculator

class StringAddCalculatorApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val text = readln()
            val result = StringAddCalculator.calculate(text)
            println(result)
        }
    }
}
