package string.addition.calculator.domain

import string.addition.calculator.view.InputView
import string.addition.calculator.view.OutputView

object StringAddCalculator {
    private const val CONTAIN_NOT_NUMBER_MESSAGE = "숫자가 아닌 값이 포함되어 있습니다."
    private const val NEGATIVE_NUMBER_MESSAGE = "음수는 입력할 수 없습니다."
    private const val DEFAULT_NUMBER = 0

    fun add(input: String?): Int {
        if (input.isNullOrBlank()) {
            return DEFAULT_NUMBER
        }
        val numbers = Splitter.split(input, Splitter.getDelimiters(input))
        isValidNumbers(numbers)
        return numbers.sumOf { it.toInt() }
    }

    private fun isValidNumbers(numbers: List<String>) {
        require(numbers.all { it.toIntOrNull() != null }) { CONTAIN_NOT_NUMBER_MESSAGE }
        require(numbers.all { it.toInt() >= 0 }) { NEGATIVE_NUMBER_MESSAGE }
    }
}

fun main() {
    val input = InputView.receiveCalculatorInput()
    val result = StringAddCalculator.add(input)
    OutputView.printResult(result)
}
