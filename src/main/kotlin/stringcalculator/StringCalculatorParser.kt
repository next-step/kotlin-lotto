package stringcalculator

class StringCalculatorParser(
    private val validator: StringCalculatorNumberValidator = StringCalculatorNumberValidator()
) {
    fun parse(numbersAsString: String, delimiter: String): List<String> {
        return numbersAsString.split(delimiter)
    }

    fun parse(numbersAsString: String): List<Int> {
        if (hasCustomDelimiter(numbersAsString)) {
            return parse(
                parseDelimiter(numbersAsString).data, parseDelimiter(numbersAsString).delimiter
            ).map { validator.ensurePositiveNumber(it); it.toInt() }
        }
        return numbersAsString.split(*DEFAULT_DELIMITERS)
            .map { validator.ensurePositiveNumber(it); it.toInt() }
    }

    fun hasCustomDelimiter(numbersAsString: String): Boolean {
        return numbersAsString.startsWith(CUSTOM_DELIMITER_PREFIX) && numbersAsString.contains(CUSTOM_DELIMITER_END)
    }

    fun parseDelimiter(numbersAsString: String): ParsingData {
        val delimiter =
            numbersAsString.substring(CUSTOM_DELIMITER_START_INDEX, numbersAsString.indexOf(CUSTOM_DELIMITER_END))
        val data = numbersAsString.substring(numbersAsString.indexOf(CUSTOM_DELIMITER_END).plus(DELIMITER_END_SKIP))
        return ParsingData(delimiter, data)
    }

    companion object {
        private val DEFAULT_DELIMITERS = arrayOf(",", ";")
        private const val CUSTOM_DELIMITER_PREFIX = "//"
        private const val CUSTOM_DELIMITER_END = "\n"
        private const val CUSTOM_DELIMITER_START_INDEX = 2
        private const val DELIMITER_END_SKIP = 1
    }
}
