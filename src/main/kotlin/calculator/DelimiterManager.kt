package calculator

class DelimiterManager {

    fun splitByDelimiter(fixedDelimiter: String?, customInput: String?, input: String): List<String> {
        return fixedDelimiter?.let { customInput?.split(it.toRegex()) }
            ?: input.split(DELIMITER.toRegex())
    }

    fun combineDelimiter(customDelimiter: String): String {
        return DELIMITER.plus("|$customDelimiter")
    }

    fun getCustomDelimiter(input: String): String? {
        val result = Regex("//(.)\n(.*)").find(input)
        return result?.groupValues?.get(1)
    }

    companion object {
        private const val DELIMITER: String = ",|:"
    }
}
