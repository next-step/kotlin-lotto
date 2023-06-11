package calculator

object StringAddCalculator {

    fun calculate(stringCalculatorText: String): CalculatorResult = CalculatorResult(
        result = StringCalculatorConvert.convertNumbers(stringCalculatorText = stringCalculatorText)
            .elements
            .sumOf { it.toLong() }
            .run {
                when {
                    this > Int.MAX_VALUE -> Int.MIN_VALUE
                    else -> toInt()
                }
            },
    )
}
