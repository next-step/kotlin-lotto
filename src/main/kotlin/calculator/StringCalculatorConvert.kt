package calculator

import calculator.model.CalculatorErrorCode

object StringCalculatorConvert {

    private val CUSTOM_DELIMITER_REGEX: Regex = Regex(pattern = """//(.)\n(.*)""")
    private val DEFAULT_DELIMITER_REGEX: Regex = Regex(pattern = """[,:]""")

    private const val DEFAULT_NUMBER: Int = 0

    @Throws(IllegalArgumentException::class)
    fun convertNumbers(stringCalculatorText: String): PositiveNumbers = PositiveNumbers(
        elements = splitText(text = stringCalculatorText).map { convertNumber(it) }
            .toIntArray(),
    )

    private fun splitText(text: String): List<String> = CUSTOM_DELIMITER_REGEX.find(input = text)
        ?.run {
            val (customDelimiter, tokenStrings) = destructured
            tokenStrings.split(customDelimiter)
        } ?: text.split(regex = DEFAULT_DELIMITER_REGEX)

    @Throws(IllegalArgumentException::class)
    private fun convertNumber(token: String) = when {
        token.isBlank() -> DEFAULT_NUMBER
        else -> requireNotNull(value = token.toIntOrNull()) {
            CalculatorErrorCode.INVALID_NUMBERS.message(token)
        }
    }
}

