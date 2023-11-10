package view

class LottoInputView {

    fun validateInputData(inputData: String) {
        if (inputData.toIntOrNull() == null) {
            throw IllegalArgumentException(ERR_MSG_NUMBER_FORMAT_EXCEPTION)
        }

        if (inputData.toFloat() - inputData.toInt() != FLOAT_ZERO) {
            throw IllegalArgumentException(ERR_MSG_INT_FORMAT_EXCEPTION)
        }

        if (inputData.toInt() <= INPUT_MIN_VALUE) {
            throw IllegalArgumentException(ERR_MSG_MIN_VALUE_EXCEPTION)
        }
    }

    companion object {
        private const val ERR_MSG_NUMBER_FORMAT_EXCEPTION = "입력값에 대한 포멧이 숫자 아닙니다."
        private const val ERR_MSG_INT_FORMAT_EXCEPTION = "입력값에 대한 포멧이 정수가 아닙니다."
        private const val ERR_MSG_MIN_VALUE_EXCEPTION = "최소값 1000원 이상을 입력해주세요."
        private const val FLOAT_ZERO = 0f
        private const val INPUT_MIN_VALUE = 1000
    }
}
