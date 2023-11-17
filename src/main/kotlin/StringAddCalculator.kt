object StringAddCalculator {

    private const val CUSTOM_DELIMITER_LINE = 0
    private const val CUSTOM_INPUT_DATA_LINE = 1
    private const val CUSTOM_CONDITION = 2
    private const val ZERO_INT = 0
    private const val BASIC_DELIMITER = "[,:]"
    private const val ERR_MSG_INCLUDE_NOT_NUMBER_FORMAT = "입력값에 숫자 포맷이 아닌 것이 있습니다."
    private const val ERR_MSG_INCLUDE_NEGATIVE_NUMBER = "입력값에 음수가 있습니다."
    private val EMPTY_LIST = emptyList<String>()

    fun calculate(inputData: String): Int {
        val splitDataList = splitInput(inputData)

        if (splitDataList.isEmpty()) return ZERO_INT

        validation(splitDataList)

        return addString(splitDataList)
    }

    private fun validation(splitDataList: List<String>) {
        splitDataList.forEach { checkPositiveNumber(it) }
    }

    private fun splitInput(inputData: String): List<String> {
        if (inputData.isBlank()) {
            return EMPTY_LIST
        }

        val splitInputData = inputData.lines()

        return if (splitInputData.size == CUSTOM_CONDITION) {
            customSplitInput(splitInputData)
        } else {
            generalSplitInput(inputData)
        }
    }

    private fun checkPositiveNumber(data: String) {
        if (data.toIntOrNull() == null) {
            throw RuntimeException(ERR_MSG_INCLUDE_NOT_NUMBER_FORMAT)
        } else if (data.toInt() < ZERO_INT) {
            throw RuntimeException(ERR_MSG_INCLUDE_NEGATIVE_NUMBER)
        }
    }

    private fun addString(splitString: List<String>): Int {
        return splitString.sumOf { it.toInt() }
    }

    private fun generalSplitInput(inputData: String): List<String> {
        return inputData.split(BASIC_DELIMITER.toRegex()).filter { it.isNotBlank() }
    }

    private fun customSplitInput(splitInputData: List<String>): List<String> {
        val delimiter = splitInputData[CUSTOM_DELIMITER_LINE]
        val inputData = splitInputData[CUSTOM_INPUT_DATA_LINE]
        return inputData.split("[$delimiter]".toRegex()).filter { it.isNotBlank() }
    }
}
