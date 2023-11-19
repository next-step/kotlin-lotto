package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        text ?: return DEFAULT_VALUE
        if (text.isEmpty()) {
            return DEFAULT_VALUE
        }

        val numbers = splitWithDelimiter(text)

        return numbers.sumOf { toPositiveInt(it) }
    }

    private fun splitWithDelimiter(text: String): List<String> {
        if (text.matches(CUSTOM_DELIMITER)) {
            val customDelimiter = text[2]
            return text.substring(4).split(customDelimiter)
        }
        return text.split("[,|:]".toRegex())
    }

    private fun toPositiveInt(text: String): Int {
        val number = text.toInt()
        require(number >= MINIMUM_VALUE) { "음수는 입력할 수 없습니다." }
        return number
    }

    companion object {
        private const val DEFAULT_VALUE = 0
        private const val MINIMUM_VALUE = 0
        private val CUSTOM_DELIMITER = Regex("//(.)\n(.*)")
    }
}
