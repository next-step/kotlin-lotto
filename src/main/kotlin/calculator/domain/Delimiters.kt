package calculator.domain

import calculator.util.RegexUtil.customRegex

class Delimiters(
    val value: List<String> = DEFAULT_DELIMITER
) {

    fun removeCustomRegex(text: String): String {
        if (customRegex.matches(text)) {
            return customRegex.find(text)
                ?.let { it.groupValues[INDEX_REMOVE_REGEX] }
                .toString()
        }
        return text
    }

    companion object {

        private const val INDEX_DELIMITER = 1
        private const val INDEX_REMOVE_REGEX = 2

        private val DEFAULT_DELIMITER = listOf(",", ":")

        fun create(input: String): Delimiters {
            val delimiter = customRegex.find(input)
                ?.let { it.groupValues[INDEX_DELIMITER] }

            if (delimiter != null) {
                val delimiters = DEFAULT_DELIMITER + delimiter

                return Delimiters(delimiters)
            }
            return Delimiters()
        }
    }
}
