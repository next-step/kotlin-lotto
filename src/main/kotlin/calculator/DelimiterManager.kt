package calculator

class DelimiterManager {

    fun splitByDelimiter(fixedDelimiter: String?, customInput: String?, input: String): List<String> {
        return fixedDelimiter?.let { customInput?.split(it.toRegex()) }
            ?: input.split(DELIMITER.toRegex())
    }

    fun combineDelimiter(customDelimiter: String?): String? {
        var fixedDelimiter: String? = null
        customDelimiter?.let {
            fixedDelimiter = DELIMITER.plus("|$it")
        }
        return fixedDelimiter
    }

    fun getCustomDelimiter(input: String): String? {
        val result = Regex("//(.)\n(.*)").find(input)
        return result?.let {
            return it.groupValues[1]
        }
    }

    companion object {
        private const val DELIMITER: String = ",|:"
    }
}
