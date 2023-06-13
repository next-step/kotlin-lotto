package calculator

import calculator.model.CalculatorErrorCode

object StringCalculatorConvert {

    private val CUSTOM_DELIMITER_REGEX: Regex = Regex(pattern = """//(.)\n(.*)""")
    private val DEFAULT_DELIMITER_REGEX: Regex = Regex(pattern = """[,:]""")

    private const val DEFAULT_NUMBER: Int = 0

    fun convertNumbers(stringCalculatorText: String): PositiveNumbers = PositiveNumbers(
        elements = splitText(text = stringCalculatorText).map(this::convertNumber),
    )

    private fun splitText(text: String): List<String> = CUSTOM_DELIMITER_REGEX.find(input = text)
        ?.let(this::splitCustomDelimiterToken)
        ?: text.split(regex = DEFAULT_DELIMITER_REGEX)

    private fun splitCustomDelimiterToken(matchResult: MatchResult): List<String> {
        val (customDelimiter, tokenStrings) = matchResult.destructured
        return tokenStrings.split(customDelimiter)
    }

    private fun convertNumber(token: String) = when {
        token.isBlank() -> DEFAULT_NUMBER
        else -> requireNotNull(value = token.toIntOrNull()) {
            CalculatorErrorCode.INVALID_NUMBERS.message(token)
        }
    }
}
