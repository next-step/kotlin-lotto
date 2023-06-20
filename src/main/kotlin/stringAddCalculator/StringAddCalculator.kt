package stringAddCalculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return ANSWER_NULL_OR_BLANK
        val (customDelimiter, operands) = parseWithDelimiter(text)
        if (operandsLengthIsOne(operands)) return operands.toInt()

        return addNumbersInString(customDelimiter = customDelimiter, operands = operands)
    }

    private fun operandsLengthIsOne(text: String): Boolean {
        return text.length == CASE_INPUT_LENTGHT_IS_ONE
    }

    private fun addNumbersInString(customDelimiter: String?, operands: String): Int {
        val delimiter = customDelimiter?.let { "[:,$it]".toRegex() } ?: "[,:]".toRegex()
        val numbers = operands.split(delimiter)
            .map { it.toIntOrNull() }
        val validatedNumbers = validateNumbers(numbers)
        return validatedNumbers.sum()
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

    private fun validateNumbers(numbers: List<Int?>): List<Int> {
        val hasInvalidNumber = numbers.any { it == null || it < 0 }
        if (hasInvalidNumber) {
            throw RuntimeException("구분자, 숫자 이외의 값 또는 음수는 포함되면 안됩니다.")
        }
        return numbers.filterNotNull()
    }

    companion object {
        const val ANSWER_NULL_OR_BLANK = 0
        const val CASE_INPUT_LENTGHT_IS_ONE = 1
    }
}
