package stringCalculator

object StringSeperator {

    private const val DEFAULT_SEPERATOR_1 = ":"
    private const val DEFAULT_SEPERATOR_2 = ","
    private val CUSTOM_SEPERATOR_REGEX = "//(.)\n(.*)".toRegex()
    private const val CUSTOM_SEPERATOR_POSITION = 1
    private const val CUSTOM_VALUE_POSITION = 2
    private const val EMPTY_VALUE = 0

    private var customSeperators = mutableListOf(DEFAULT_SEPERATOR_1, DEFAULT_SEPERATOR_2)
    fun seperate(string: String): List<Int> {
        if (string.isEmpty()) {
            return listOf(EMPTY_VALUE)
        }
        var convertedString = string

        CUSTOM_SEPERATOR_REGEX.find(string)?.groupValues?.let {
            customSeperators.add(it[CUSTOM_SEPERATOR_POSITION])
            convertedString = it[CUSTOM_VALUE_POSITION]
        }

        return getNumbers(convertedString.split(*customSeperators.toTypedArray()))
    }

    private fun getNumbers(strings: List<String>): List<Int> {
        return strings.map {
            parseStringToInt(it)
        }
    }

    private fun parseStringToInt(string: String): Int {
        val intString = string.toIntOrNull() ?: throw RuntimeException("숫자만 올 수 있음")
        if (intString < 0) {
            throw RuntimeException("음수는 올 수 없음")
        }
        return intString
    }
}
