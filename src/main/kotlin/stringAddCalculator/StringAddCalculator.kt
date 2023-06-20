package stringAddCalculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return ANSWER_NULL_OR_BLANK
        if (text.length == CASE_INPUT_LENTGHT_IS_ONE) return text.toInt()
        val parsedString = parseWithDelimiter(text)
        return addNumbersInString(parsedString)
    }

    private fun addNumbersInString(parsedString: ParsedString): Int {
        val (customDelimiter, operands) = parsedString
        val delimiter = customDelimiter?.let { "[:,$it]".toRegex() } ?: "[,:]".toRegex()
        val nums = operands.split(delimiter)
            .map { it.toInt() }
        return nums.sum()
    }

    private fun parseWithDelimiter(text: String): ParsedString {
        val result = Regex("//(.)\n(.*)").find(text)
        var delimiter: String? = null
        var operands: String = text
        result?.let {
            delimiter = it.groupValues[1]
            operands = it.groupValues[2]
        }
        return ParsedString(delimiter = delimiter, operands = operands)
    }

    companion object {
        const val ANSWER_NULL_OR_BLANK = 0
        const val CASE_INPUT_LENTGHT_IS_ONE = 1
    }
}
