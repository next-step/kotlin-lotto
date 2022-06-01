package calculator

class StringCalculator {
    fun add(text: String): Int {
        if (text.isEmpty()) {
            return 0
        }

        if (text.toIntOrNull() != null) {
            return text.toInt()
        }

        var delimiter = DEFAULT_DELIMITER
        var _text = text

        if (text.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            val result = CUSTOM_DELIMITER_REGEX.find(text)
            result?.let { it ->
                require(it.groupValues[CUSTOM_DELIMITER_INDEX].toIntOrNull() == null) { "구분자는 숫자로 지정할 수 없습니다." }
                delimiter = it.groupValues[CUSTOM_DELIMITER_INDEX]
                _text = it.groupValues[TEXT_INDEX]
            }
        }

        return _text
            .split(delimiter.toRegex())
            .sumOf {
                val number = it.toIntOrNull()
                    ?: throw IllegalArgumentException("계산할 값은 정수로 입력해야합니다. text: $text")
                require(number >= 0) { "음수는 계산이 불가능합니다. 0이상의 정수를 입력해주세요.  text: $text" }
                number
            }
    }

    companion object {
        const val DEFAULT_DELIMITER = "[,:]"
        const val CUSTOM_DELIMITER_PREFIX = "//"
        const val CUSTOM_DELIMITER_INDEX = 1
        const val TEXT_INDEX = 2
        val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")
    }
}
