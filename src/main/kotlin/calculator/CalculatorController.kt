package calculator

import calculator.domain.Calculator
import calculator.domain.CustomReadStrategy
import calculator.domain.StandardReadStrategy
import calculator.interfaces.StringReadStrategy
import calculator.ui.InputView

fun main() {
    val inputView = InputView()
    val calculator = Calculator()
    val inputString = inputView.inputString()
    val stringReadStrategy = selectStringReadStrategy(inputString)

    val numbers = stringReadStrategy.readString(inputString)
    val result = calculator.calculate(numbers)

    println(result)
}

fun selectStringReadStrategy(string: String): StringReadStrategy {
    return when {
        string.startsWith("//") -> {
            CustomReadStrategy()
        }
        else -> {
            StandardReadStrategy()
        }
    }
}
