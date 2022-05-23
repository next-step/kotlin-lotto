package stringAddCalculator

object Calculator {
    const val NEGATIVE_ERROR = "음수는 계산할 수 없습니다."
    private const val COMMA_DELIMITER = ","
    private const val COLON_DELIMITER = ":"

    private val DEFAULT_DELIMITER_REGEX = Regex("$COLON_DELIMITER|$COMMA_DELIMITER")
    private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")

    fun calculate(input: String?): Int {
        val checkInput: String = getInputOrDefault(input)
        var splitByDelimiter = splitCustomDelimiter(checkInput)
        if (splitByDelimiter.isEmpty()) splitByDelimiter = splitByDefaultDelimiter(checkInput)
        val convertIntList = convertOperand(splitByDelimiter)
        return accumulateSum(convertIntList)
    }

    fun getInputOrDefault(input: String?): String = if (input.isNullOrBlank()) "0" else input

    fun splitByDefaultDelimiter(input: String): List<String> {
        return input.split(DEFAULT_DELIMITER_REGEX)
    }

    fun splitCustomDelimiter(input: String): List<String> {
        val result = CUSTOM_DELIMITER_REGEX.find(input) ?: return emptyList()
        val delimiter = result.groupValues[1]
        val splitInputByRegex = result.groupValues[2]
        return splitInputByRegex.split(delimiter)
    }

    fun convertOperand(inputList: List<String>): List<Int> {
        val convertAllToOperand = inputList.map { it.toInt() }
        checkNegative(convertAllToOperand)
        return convertAllToOperand
    }

    fun accumulateSum(numberList: List<Int>): Int {
        return numberList.sum()
    }

    fun checkNegative(numberList: List<Int>) {
        numberList.forEach {
            if (it < 0) throw RuntimeException(NEGATIVE_ERROR)
        }
    }
}
