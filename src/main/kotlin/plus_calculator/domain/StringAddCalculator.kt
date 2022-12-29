package plus_calculator.domain

class StringAddCalculator {
    companion object {
        private const val ZERO = 0
        private val CUSTOM_DELIMITER = Regex("//(.)\n(.*)")
        private val DEFAULT_DELIMITER = Regex("[,:]")
    }
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return ZERO
        }

        val textOperands: List<String> = this.tokenizesText(text)

        return textOperands.sumOf { parseNumber(it) }
    }

    private fun tokenizesText(text: String): List<String> {
        val matcher = CUSTOM_DELIMITER.find(text)

        if (matcher != null) {
            val (customDelimiter: String, matchedText: String) = matcher.destructured

            return matchedText.split(customDelimiter)
        }

        return text.split(DEFAULT_DELIMITER)
    }

    private fun parseNumber(numberString: String): Int {
        try {
            val number = numberString.toInt()
            validateNumber(number)

            return number
        } catch (e: NumberFormatException) {
            throw RuntimeException("숫자만 가능합니다.")
        }
    }

    private fun validateNumber(number: Int) {
        if (number < ZERO) {
            throw RuntimeException("음수는 적용할 수 없습니다.")
        }
    }
}