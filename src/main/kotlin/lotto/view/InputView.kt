package lotto.view

object InputView {
    private const val ERR_MSG_INVALID_NUMERIC_FORMAT = "입력된 구입 금액의 포맷이 숫자가 압니다."

    fun validateCash(cash: String) {
        require(cash.toIntOrNull() != null) {ERR_MSG_INVALID_NUMERIC_FORMAT}
    }
}
