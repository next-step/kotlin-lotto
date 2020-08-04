package stringaddcalculator.domain

object StringSeparator {
    private val BASIC_STRING_REGEX = Regex("\\d+(.\\d+)*")

    fun separate(inputString: String?): List<String> {
        if (inputString.isNullOrBlank()) return emptyList()
        val delimiters = DelimiterFinder.find(inputString)
        return getStringToSeparate(inputString).split(*delimiters.toTypedArray())
    }

    private fun getStringToSeparate(string: String): String {
        return BASIC_STRING_REGEX.find(string)?.groupValues?.getOrNull(0)
            ?: throw IllegalArgumentException("$string 는 유효하지 않은 문자열입니다.")
    }
}
