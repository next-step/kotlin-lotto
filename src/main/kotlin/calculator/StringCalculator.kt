package calculator

private const val DEFAULT_VALUE = 0

class StringCalculator {

    fun calculate(text: String?): Int {
        if (text.isNullOrBlank()) {
            return DEFAULT_VALUE
        }
        val numbers = DelimiterExtractor.extractNumbers(text)

        return numbers.reduce() { sum, number -> sum + number }.toInt()
    }
}
