package calculator

private const val DEFAULT_DELIMITER_1 = ","
private const val DEFAULT_DELIMITER_2 = ":"
private const val CUSTOM_DELIMITER_START_FLAG = "//"
private const val CUSTOM_DELIMITER_END_FLAG = "\n"
private const val CUSTOM_DELIMITER_INDEX = 2
private const val CUSTOM_DELIMITER_MIN_LENGTH = 5
private const val CUSTOM_DELIMITER_DROP_INDEX = 4
private const val NUMBER_MIN_VALUE = 0
private const val NUMBER_MAX_VALUE = 100

/**
 * 문자열 계산기 (덧셈, 커스텀 구분자)
 * */
object Calculator {

    private var delimiterList: List<String> = listOf(DEFAULT_DELIMITER_1, DEFAULT_DELIMITER_2)

    /**
     * 계산 동작
     * @param equation 계산식 문자열
     * @return 계산된 값을 반환
     * */
    fun calculate(equation: String?): Int {
        if (equation.isNullOrBlank()) return 0

        setDelimiter(equation)

        val numberList: List<Int> = getNumberList(equation)

        return numberList.sumOf { it }
    }

    private fun setDelimiter(equation: String) {

        if (equation.startsWith(CUSTOM_DELIMITER_START_FLAG)) {
            require(equation.length >= CUSTOM_DELIMITER_MIN_LENGTH && equation.take(CUSTOM_DELIMITER_MIN_LENGTH).contains(CUSTOM_DELIMITER_END_FLAG)) {
                "커스텀 구분자를 정확히 입력해야 합니다"
            }
            delimiterList = listOf(equation[CUSTOM_DELIMITER_INDEX].toString())
            return
        }

        delimiterList = listOf(DEFAULT_DELIMITER_1, DEFAULT_DELIMITER_2)
    }

    private fun getNumberList(equation: String): List<Int> {
        var numberTextList = equation.split(*delimiterList.toTypedArray())

        if (equation.startsWith(CUSTOM_DELIMITER_START_FLAG)) {
            numberTextList = equation.drop(CUSTOM_DELIMITER_DROP_INDEX).split(*delimiterList.toTypedArray())
        }

        require(numberTextList.all { it.toIntOrNull() != null && it.toInt() >= NUMBER_MIN_VALUE && it.toInt() <= NUMBER_MAX_VALUE }) {
            "${NUMBER_MIN_VALUE}이상 ${NUMBER_MAX_VALUE}이하의 숫자를 입력하셔야 합니다."
        }

        return numberTextList.map { it.toInt() }
    }
}
