package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text == null || text.trim().isEmpty()) return 0

        val delimiters = mutableListOf<String>()
            .apply { addAll(DEFAULT_DELIMITERS) }

        if (existCustomizedDelimiter(text)) {
            delimiters.apply { addAll(getCustomizedDelimiter(text)) }
            return calculate(getTrimmedText(text), delimiters)
        }

        return calculate(text, delimiters)
    }

    private fun existCustomizedDelimiter(text: String): Boolean {
        return text.indexOf(CUSTOM_DELIMITER_START_FLAG) == 0 && text.indexOf(CUSTOM_DELIMITER_END_FLAG) != -1
    }

    private fun getCustomizedDelimiter(text: String): List<String> {
        val startIndex = text.indexOf(CUSTOM_DELIMITER_START_FLAG) + CUSTOM_DELIMITER_START_FLAG.length
        val endIndex = text.indexOf(CUSTOM_DELIMITER_END_FLAG, startIndex)
        return text.substring(startIndex, endIndex)
            .map{ it.toString() }
            .onEach { char -> require(char != MINUS_OPERATOR) }
    }

    private fun getTrimmedText(text: String): String {
        return text.substring(text.indexOf(CUSTOM_DELIMITER_END_FLAG) + CUSTOM_DELIMITER_END_FLAG.length)
    }

    private fun calculate(text: String, delimiters: List<String>): Int {
        val numStringList = splitString(text, delimiters)
        return calculateSum(numStringList)
    }

    private fun splitString(text: String, delimiters: List<String>): List<String> {
        return text.split(*delimiters.toTypedArray())
    }

    private fun calculateSum(text: List<String>): Int {
        return text.sumOf { stringToPositiveInteger(it) }
    }

    private fun stringToPositiveInteger(text: String): Int {
        return PositiveInteger.getPositiveInteger(text)
    }

    companion object {
        private const val CUSTOM_DELIMITER_START_FLAG = "//"
        private const val CUSTOM_DELIMITER_END_FLAG = "\n"
        private const val MINUS_OPERATOR = "-"
        private val DEFAULT_DELIMITERS = listOf(",",":")
    }
}