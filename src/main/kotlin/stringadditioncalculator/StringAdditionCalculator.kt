package stringadditioncalculator

class StringAdditionCalculator {
    fun calculate(expression: String?): Int {
        val stringNumbers = StringAdditionCalculatorInputParser.parse(expression)
        stringNumbers.validate()

        return stringNumbers.map { it.toInt() }
            .fold(0, Int::plus)
    }
}
