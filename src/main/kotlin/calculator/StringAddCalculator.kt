package calculator

object StringAddCalculator {

    fun calculate(stringCalculatorText: String): CalculatorResult = CalculatorResult(
        result = StringCalculatorConvert.convertNumbers(stringCalculatorText = stringCalculatorText)
            .elements
            .sum(),
    )
}
