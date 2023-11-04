package calculate

import java.util.regex.Pattern

class StringCalculator {
    fun inputText(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val matchText = CUSTOM_DELIMITER.matcher(text)
        if (matchText.find()) {
            return matchText.group(2).split(matchText.group(1))
                .map { convertToInt(it) }
                .sumOf { it }
        }

        return text.split(DEFAULT_DELIMITER)
            .map { convertToInt(it) }
            .sumOf { it }
    }

    private fun convertToInt(numberText: String): Int {
        require(numberText.toInt() >= 0) { ERROR_MESSAGE }
        return numberText.toInt()
    }

    companion object {
        private val DEFAULT_DELIMITER: Pattern = Pattern.compile(",|:")
        private val CUSTOM_DELIMITER: Pattern = Pattern.compile("//(.)\n(.*)")
        private const val ERROR_MESSAGE: String = "음수는 입력할 수 없습니다."
    }
}
