package calculator

object StringAddCalculator {

    fun calculate(stringCalculatorText: String): CalculatorResult = CalculatorResult(
        result = StringCalculatorConvert.convertNumbers(stringCalculatorText = stringCalculatorText)
            .sumOf { it.toLong() }
            .toIntOrMaxValue(),
    )

    private fun Long.toIntOrMaxValue(): Int = when {
        this > Int.MAX_VALUE -> Int.MAX_VALUE
        else -> toInt()
    }
}
