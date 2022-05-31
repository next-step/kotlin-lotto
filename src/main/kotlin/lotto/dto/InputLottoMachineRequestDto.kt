package lotto.dto

data class InputLottoMachineRequestDto(
    val payment: Int,
    val manualLottoCount: Int,
) {

    companion object {

        const val CANNOT_CONVERT_INT = "정수로 변환할 수 없습니다."
        const val NEGATIVE_ERROR = "음수는 입력할 수 없습니다."

        fun of(inputPayment: String, inputManualLottoCount: String): InputLottoMachineRequestDto {
            val payment: Int = inputPayment.toIntOrNull() ?: throw IllegalArgumentException(CANNOT_CONVERT_INT)
            checkNegative(payment)
            val manualLottoCount: Int = inputManualLottoCount.toIntOrNull() ?: throw IllegalArgumentException(CANNOT_CONVERT_INT)
            checkNegative(manualLottoCount)
            return InputLottoMachineRequestDto(payment, manualLottoCount)
        }

        private fun checkNegative(number: Int) {
            if (number < 0) throw IllegalArgumentException(InputLottoNumberDto.NEGATIVE_ERROR)
        }
    }
}
