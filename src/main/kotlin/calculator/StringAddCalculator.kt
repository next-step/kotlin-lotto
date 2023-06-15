package calculator

object StringAddCalculator {

    fun calculate(input: String?): PositiveNumber {
        if (input.isNullOrBlank()) return PositiveNumber.ZERO
        val stringAddCalculatorInput = StringAddCalculatorInput(input)
        val numbers = stringAddCalculatorInput.numbers()
        return numbers.fold(PositiveNumber.ZERO) { acc, i -> acc + i }
    }
}
