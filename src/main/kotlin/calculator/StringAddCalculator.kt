package calculator

class StringAddCalculator {
    private val customRegex = Regex("//(.)\n(.*)")

    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) return RETURN_NULL_OR_EMPTY_STRING
        return convertTextToIntList(text).sum()
    }

    private fun convertTextToIntList(text: String): List<Int> {
        val customList = splitCustom(text)
        return when {
            customList.isNullOrEmpty() -> split(text).map { validationInt(it) }
            else -> customList.map { split(it).sumOf { validationInt(it) } }
        }
    }

    private fun split(text: String): List<String> = text.split(DELIMITER_UNIT_ONE, DELIMITER_UNIT_SECOND)

    private fun splitCustom(text: String): List<String>? {
        val result = customRegex.find(text)
        result?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter)
        } ?: return null
    }

    private fun validationInt(text: String): Int {
        val number = text.toIntOrNull()
        if (number == null || number < 0) throw RuntimeException(EXCEPTION_NULL_OR_EMPTY)
        return number
    }

    companion object {
        const val DELIMITER_UNIT_ONE = ","
        const val DELIMITER_UNIT_SECOND = ":"
        const val RETURN_NULL_OR_EMPTY_STRING = 0
        const val EXCEPTION_NULL_OR_EMPTY = "숫자가 아니거나 음수 입니다."
    }
}
