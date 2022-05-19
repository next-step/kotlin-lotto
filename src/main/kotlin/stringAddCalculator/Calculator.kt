package stringAddCalculator

object Calculator {
    const val NEGATIVE_ERROR = "음수는 계산할 수 없습니다."
    private const val COMMA_DELIMITER = ","
    private const val COLON_DELIMITER = ":"
    private const val CUSTOM_DELIMITER = "//(.)\n(.*)"

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) return 0
        return input.toInt()
    }

    fun splitString(input: String): List<String> {
        return input.split(("$COLON_DELIMITER|$COMMA_DELIMITER").toRegex())
    }

    fun customDelimiter(input: String): List<String> {
        val result = Regex(CUSTOM_DELIMITER).find(input)!!
        val (delimiter, splitStringList) = result.groupValues
        return splitStringList.split(delimiter)
    }

    fun convertInt(inputList: List<String>): List<Int> {
        return inputList.map { it.toInt() }
    }

    fun add(numberList: List<Int>): Int {
        return numberList.sum()
    }

    fun checkNegative(numberList: List<Int>) {
        numberList.forEach {
            if (it < 0) throw RuntimeException(NEGATIVE_ERROR)
        }
    }
}
