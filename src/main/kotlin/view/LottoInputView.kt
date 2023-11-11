package view

object LottoInputView {

    private const val ERR_MSG_NUMBER_FORMAT_EXCEPTION = "입력값에 대한 포멧이 숫자 아닙니다."
    private const val ERR_MSG_INT_FORMAT_EXCEPTION = "입력값에 대한 포멧이 정수가 아닙니다."
    private const val ERR_MSG_MIN_VALUE_EXCEPTION = "최소값 1,000원 이상의 값을 입력해 주세요"
    private const val ERR_MSG_MAX_VALUE_EXCEPTION = "최대값 100,000원 이하의 값을 입력해 주세요"
    private const val ERR_MSG_EXCEED_WINNING_NUMBERS_CNT = "당첨 번호 입력 개수를 초과하였습니다."
    private const val ERR_MSG_EXCEED_WINNING_NUMBER_RANGE = "당첨 번호가 기준 값(45)을 초과하였습니다."
    private const val ERR_MSG_DUPLICATE_WINNING_NUMBER = "중복되는 당첨 번호가 있습니다."
    private const val DELIMITERS_SYMBOL = ","
    private const val FLOAT_ZERO = 0f
    private const val INPUT_MIN_VALUE = 1000
    private const val INPUT_MAX_VALUE = 100000
    private const val INPUT_MIN_WINNING_NUMBER = 1
    private const val INPUT_MAX_WINNING_NUMBER = 45

    fun validateCashInputData(inputData: String) {
        validateNumberFormat(inputData)
        validateInteger(inputData)
        validateInputCashRange(inputData)
    }

    private fun validateNumberFormat(inputData: String) {
        if (inputData.toIntOrNull() == null) {
            throw IllegalArgumentException(ERR_MSG_NUMBER_FORMAT_EXCEPTION)
        }
    }

    private fun validateInteger(inputData: String) {
        if (inputData.toFloat() - inputData.toInt() != FLOAT_ZERO) {
            throw IllegalArgumentException(ERR_MSG_INT_FORMAT_EXCEPTION)
        }
    }

    private fun validateInputCashRange(inputData: String) {
        if (inputData.toInt() < INPUT_MIN_VALUE) {
            throw IllegalArgumentException(ERR_MSG_MIN_VALUE_EXCEPTION)
        }

        if (inputData.toInt() > INPUT_MAX_VALUE) {
            throw IllegalArgumentException(ERR_MSG_MAX_VALUE_EXCEPTION)
        }
    }

    fun createWinningNumber(inputWinningNumber: String): List<Int> {
        // 분리
        val winningNumberList = inputWinningNumber.split(DELIMITERS_SYMBOL).map { it.trim() }

        validateWinningNumber(winningNumberList)

        return winningNumberList.map { it.toInt() }
    }

    private fun validateWinningNumber(winningNumberList: List<String>) {
        winningNumberList.forEach {
            validateNumberFormat(it)
            validateInteger(it)
            validateWinningNumberRange(it)
        }
        validateWinningNumberCnt(winningNumberList)
        validateDuplicateWinningNumber(winningNumberList)
    }

    private fun validateWinningNumberCnt(winningNumberList: List<String>) {
        if (winningNumberList.size > 6) {
            throw IllegalArgumentException(ERR_MSG_EXCEED_WINNING_NUMBERS_CNT)
        }
    }

    private fun validateWinningNumberRange(inputData: String) {
        val number = inputData.toInt()
        if (number < INPUT_MIN_WINNING_NUMBER || number > INPUT_MAX_WINNING_NUMBER) {
            throw IllegalArgumentException(ERR_MSG_EXCEED_WINNING_NUMBER_RANGE)
        }
    }

    private fun validateDuplicateWinningNumber(winningNumberList: List<String>) {
        val winningNumberSet = winningNumberList.toSet()
        if (winningNumberSet.size != winningNumberList.size) {
            throw IllegalArgumentException(ERR_MSG_DUPLICATE_WINNING_NUMBER)
        }
    }
}
