package lotto.view

object InputView {
    private const val ERR_MSG_INVALID_NUMERIC_FORMAT = "입력된 구입 금액의 포맷이 숫자가 압니다."
    private const val ERR_MSG_OUT_OF_CASH_RANGE = "입력된 값이 구매 가능할 수 있는 금액의 범위를 벗어났습니다"
    fun validateCash(inputData: String) {
        validateNumericFormat(inputData)
        validateNumberRange(inputData.toInt())
    }

    private fun validateNumericFormat(inputData: String) {
        require(inputData.toIntOrNull() != null) { ERR_MSG_INVALID_NUMERIC_FORMAT }
    }

    private fun validateNumberRange(inputData: Int) {
        require(inputData in 1000..100000) { ERR_MSG_OUT_OF_CASH_RANGE }
    }
}
