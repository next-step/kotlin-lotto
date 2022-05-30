package _string_add_calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return ZERO
        }

        return CUSTOM_DELIMITER_REGEX.find(text)
            ?.destructured
            ?.let { (delimiter, matchText) -> addByDelimiter(delimiter.toRegex(), matchText) }
            ?: addByDelimiter(DELIMITER_REGEX, text)
    }

    private fun addByDelimiter(delimiter: Regex, text: String) = text.split(delimiter).sumOf { it.toPositiveOrTrow() }

    private fun String.toPositiveOrTrow(): Int {
        val number = this.toInt()
        if (number < 0) {
            throw RuntimeException("입력값은 음수가 아니여야 한다.")
        }
        return number
    }

    companion object {
        private const val ZERO = 0
        private val DELIMITER_REGEX = ",|:".toRegex()
        private val CUSTOM_DELIMITER_REGEX = "//(.)\\n(.*)".toRegex()
    }
}
