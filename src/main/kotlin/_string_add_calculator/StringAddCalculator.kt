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
            return matchText.split(delimiter).sumOf {
                val number = it.toInt()
                if (number < 0) {
                    throw RuntimeException("입력값은 음수가 아니여아 한다.")
                }
                number
            }
        }

        return text.split(DELIMITER_REGEX).sumOf {
            val number = it.toInt()
            if (number < 0) {
                throw RuntimeException("입력값은 음수가 아니여아 한다.")
            }
            number
        }
    }
    companion object {
        private val DELIMITER_REGEX = ",|:".toRegex()
        private val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)".toRegex()
    }
}
