package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val delimiter = getDelimiter(text)
        val numbers = getNumberText(text)

        return numbers
            .split(delimiter)
            .sumOf {
                val number = it.toInt()
                if (number < 0) {
                    throw RuntimeException("Negative number is not allowed")
                }

                number
            }
    }

    private fun getNumberText(text: String): String {
        val result = INPUT_NUMBER_REGEX.find(text)

        result?.let {
            return it.groupValues[1]
        }

        return text
    }

    private fun getDelimiter(text: String): Regex {
        val result = DELIMITER_REGEX.find(text)

        result?.let {
            return it.groupValues[1].toRegex()
        }

        return DEFAULT_DELIMITER_REGEX
    }

    companion object {
        private val INPUT_NUMBER_REGEX = Regex("//.\n(.*)")
        private val DELIMITER_REGEX = Regex("//(.)\n")
        private val DEFAULT_DELIMITER_REGEX = Regex("[,|:]")
    }
}
