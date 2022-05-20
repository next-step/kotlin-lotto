package calculator.processor

import calculator.model.PositiveNumber

class CalculatorProcessor {
    fun add(numbers: List<PositiveNumber>) =
        numbers.sumOf { it.toDouble() }
}
