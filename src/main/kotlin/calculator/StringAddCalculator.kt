package calculator

object StringAddCalculator {

    fun calculate(input: String?): PositiveNumber {
        if (input.isNullOrBlank()) return PositiveNumber.ZERO
        val numberParser = NumberParser(input)
        val numbers = numberParser.numbers
        return numbers.fold(PositiveNumber.ZERO) { acc, i -> acc + i }
    }
}
