class StringAddCalculator(private val inputData: String?) {

    init {
        validation()
    }

    private fun validation() {
        val splitData = splitInput()
        splitData.forEach { checkPositiveNumber(it) }
    }

    private fun checkPositiveNumber(data: String) {
        if (data.toIntOrNull() == null) {
            throw RuntimeException("입력값에 숫자 포멧이 아닌 것이 있습니다.")
        } else if (data.toInt() < 0) {
            throw RuntimeException("입력값에 음수가 있습니다.")
        }
    }

    fun splitInput(): List<String> {
        if (inputData == null) {
            return listOf(STR_ZERO)
        }

        val splitInputData = inputData.lines()

        return if (splitInputData.size == CUSTOM_CONDITION) {
            // 커스텀
            customSplitInput(splitInputData)
        } else {
            // 일반
            generalSplitInput(inputData)
        }
    }

    private fun generalSplitInput(inputData: String): List<String> {
        return inputData.split("[,:]".toRegex()).filter { it.isNotBlank() }
    }

    private fun customSplitInput(splitInputData: List<String>): List<String> {
        val delimiter = splitInputData[CUSTOM_DELIMITER_LINE]
        val inputData = splitInputData[CUSTOM_INPUT_DATA_LINE]
        return inputData.split("[$delimiter]".toRegex()).filter { it.isNotBlank() }
    }

    fun addString(splitString: List<String>): Int {
        var result = 0
        splitString.forEach { result += it.toInt() }
        return result
    }

    companion object {
        private const val CUSTOM_DELIMITER_LINE = 0
        private const val CUSTOM_INPUT_DATA_LINE = 1
        private const val STR_ZERO = "0"
        private const val CUSTOM_CONDITION = 2
    }
}
