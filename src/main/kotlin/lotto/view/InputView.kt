package lotto.view

object InputView {
    private const val ERR_MSG_INVALID_NUMERIC_FORMAT = "입력된 값의 포맷이 숫자가 압니다."
    private const val ERR_MSG_OUT_OF_CASH_RANGE = "입력된 값이 구매 가능할 수 있는 금액의 범위를 벗어났습니다"

    fun inputCash(): String {
        println("구입금액을 입력해 주세요.")
        val inputData = readln()
        validateCash(inputData)
        return inputData
    }

    fun inputWinningNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val inputData = readln()
        println()
        return splitInputData(inputData)
    }

    fun validateCash(inputData: String) {
        validateNumericFormat(inputData)
        validateNumberRange(inputData.toInt())
    }

    fun splitInputData(inputData: String): List<Int> {
        val splitData = inputData.split(",").map { it.trim() }
        validateWinningNumber(splitData)
        return splitData.map { it.toInt() }
    }

    private fun validateNumericFormat(inputData: String) {
        require(inputData.toIntOrNull() != null) { ERR_MSG_INVALID_NUMERIC_FORMAT }
    }

    private fun validateNumberRange(inputData: Int) {
        require(inputData in 1000..100000) { ERR_MSG_OUT_OF_CASH_RANGE }
    }

    private fun validateWinningNumber(inputData: List<String>) {
        inputData.forEach { require(it.toIntOrNull() != null) { ERR_MSG_INVALID_NUMERIC_FORMAT } }
    }
}
