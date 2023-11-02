package stringcalculator

class StringParser(private val validator: Validator = Validator()) {
    fun parse(numbersAsString: String, delimiter: String): List<String> {
        return numbersAsString.split(delimiter)
    }

    fun parse(numbersAsString: String): List<Int> {
        if (hasCustomDelimiter(numbersAsString)) {
            return parse(
                parseDelimiter(numbersAsString).data, parseDelimiter(numbersAsString).delimiter
            ).map { validator.ensurePositiveNumber(it);it.toInt() }
        }
        return numbersAsString.split(',', ';').map { validator.ensurePositiveNumber(it);it.toInt() }
    }

    fun hasCustomDelimiter(numbersAsString: String): Boolean {
        return numbersAsString.startsWith("//") && numbersAsString.contains("\n")
    }

    fun parseDelimiter(numbersAsString: String): ParsingData {
        val delimiter = numbersAsString.substring(2, numbersAsString.indexOf("\n"))
        val data = numbersAsString.substring(numbersAsString.indexOf("\n").plus(1))
        return ParsingData(delimiter, data)
    }
}
