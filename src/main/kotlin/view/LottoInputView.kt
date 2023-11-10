package view

class LottoInputView {

    fun validateInputData(inputData: String) {
        if (inputData.toIntOrNull() == null) {
            throw IllegalArgumentException(ERR_MSG_NUMBER_FORMAT_EXCEPTION)
        }
    }

    companion object {
        private const val ERR_MSG_NUMBER_FORMAT_EXCEPTION = "입력값에 대한 포멧이 숫자 아닙니다."
    }
}
