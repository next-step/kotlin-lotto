package calculator

object StringAddCalculator {

    private const val DEFAULT_DELIMITER = ",:"

    private const val CUSTOM_DELIMITER = "//(.)\n(.*)"
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val result = Regex(CUSTOM_DELIMITER).find(text)
        result?.let {
            val customDelimiter = it.groupValues[1]
            return sum(it.groupValues[2].split(customDelimiter))
        }
        return sum(text.split("[$DEFAULT_DELIMITER]".toRegex()))
    }

    private fun sum(tokens: List<String>): Int = tokens.sumOf { toInt(it) }
    private fun toInt(text: String): Int {
        try {
            val result = text.toInt()
            if (result < 0) {
                throw RuntimeException("입력값은 음수가 나올 수 없습니다.")
            }
            return result
        } catch (e: NumberFormatException) {
            throw RuntimeException("입력값은 숫자만 가능합니다.", e)
        }
    }
}
