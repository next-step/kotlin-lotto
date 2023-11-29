package stringsumcalculator

class Calculator {

    fun execute(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        return getDestructured(text)?.let { (delimiter, value) ->
            sum(value, delimiter)
        } ?: sum(text, DEFAULT_DELIMITER)
    }

    private fun getDestructured(text: String): MatchResult.Destructured? {
        return CUSTOM_SEARCH_PATTERN.find(text)?.destructured
    }

    fun sum(value: String, delimiter: String): Int {
        return value.split(delimiter.toRegex()).sumOf {
            it.toPositiveNumber()
        }
    }

    private fun String.toPositiveNumber(): Int {
        val value = this.toIntOrNull()
        if (value == null || value < 0) {
            throw RuntimeException("숫자 이외의 값 또는 음수이므로 계산을 할 수 없습니다.")
        }
        return value
    }

    companion object {
        private const val DEFAULT_DELIMITER = ",|:"
        private val CUSTOM_SEARCH_PATTERN: Regex = Regex("//(.)\n(.*)")
    }
}