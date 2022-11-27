package calculator

data class Separators(val value: List<String>) {
    fun toPositiveNumbers(): PositiveNumbers {
        require(hasValidNumber()) {
            "숫자가 아닌 값은 입력될 수 없습니다."
        }

        return PositiveNumbers(value.map { it.toInt() })
    }

    private fun hasValidNumber() = value.any { number -> number.toIntOrNull() === null }

    companion object {
        private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")
        private val DEFAULT_DELIMITER_REGEX = Regex("[,:]")

        private const val CUSTOM_DELIMITER_INDEX = 1
        private const val NUMBERS_INDEX = 2

        fun parse(text: String): Separators {
            return Separators(separateByDelimiter(text))
        }

        private fun separateByDelimiter(text: String): List<String> {
            val result = CUSTOM_DELIMITER_REGEX.find(text)
            result?.let {
                val customDelimiter = it.groupValues[CUSTOM_DELIMITER_INDEX]

                return it.groupValues[NUMBERS_INDEX]
                    .split(customDelimiter)
            }

            return text.split(DEFAULT_DELIMITER_REGEX)
        }
    }
}
