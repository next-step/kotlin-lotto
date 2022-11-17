package calculator

class StringAddCalculator {

    fun calculate(input: String?): Int {
        val checkInput: String = checkInput(input)
        val splitList = splitString(checkInput)
        val convertIntList = convertInt(splitList)
        return add(convertIntList)
    }

    fun checkInput(input: String?): String = if (input.isNullOrBlank()) "0" else input

    fun splitString(input: String): List<String> {
        return splitCustomDelimiter(checkInput(input)) ?: splitDelimeter(input)
    }

    fun splitDelimeter(input: String): List<String> {
        return input.split(DEFAULT_DELIMITER_REGEX)
    }

    fun splitCustomDelimiter(input: String): List<String>? {
        val result = CUSTOM_DELIMITER_REGEX.find(input) ?: return null
        val delimiter = result.groupValues[1]
        val splitStringList = result.groupValues[2]
        return splitStringList.split(delimiter)
    }

    fun convertInt(inputList: List<String>): List<Int> {
        val numberList = inputList.map { it.toInt() }
        checkNegative(numberList)
        return numberList
    }

    fun add(numberList: List<Int>): Int {
        return numberList.sum()
    }

    fun checkNegative(numberList: List<Int>) {
        numberList.forEach {
            if (it < 0) throw RuntimeException(NEGATIVE_ERROR)
        }
    }

    companion object {
        const val NEGATIVE_ERROR = "음수는 계산할 수 없습니다."
        private const val COMMA_DELIMITER = ","
        private const val COLON_DELIMITER = ":"

        private val DEFAULT_DELIMITER_REGEX = Regex("$COLON_DELIMITER|$COMMA_DELIMITER")
        private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")
    }
}
