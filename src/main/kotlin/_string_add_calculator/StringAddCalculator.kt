package _string_add_calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        if (text.toIntOrNull() != null) {
            return text.toInt()
        }

        val customMatchResult = CUSTOM_DELIMITER_REGEX.find(text)
        if (customMatchResult !== null) {
            val (delimiter, matchText) = customMatchResult.destructured
            return matchText.split(delimiter).sumOf { it.toInt() }
        }

        return text.split(DELIMITER_REGEX).sumOf { it.toInt() }
    }
    companion object {
        private val DELIMITER_REGEX = ",|:".toRegex()
        private val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)".toRegex()
    }
}
