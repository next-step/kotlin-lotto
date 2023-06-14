package stringadditioncalculator

class StringAdditionCalculator {
    fun calculate(input: String): Any {
        val stringNumbers = StringAdditionCalculatorInputParser.parse(input)

        return stringNumbers.asSequence()
            .map { it.toInt() }
            .fold(0, Int::plus)
    }
}
