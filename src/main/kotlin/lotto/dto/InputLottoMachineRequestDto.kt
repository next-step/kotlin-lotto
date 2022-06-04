package lotto.dto

import lotto.domin.LottoNumberSet

data class InputLottoMachineRequestDto(
    val payment: Int,
    val manualLotto: List<LottoNumberSet>,
) {

    companion object {

        const val CANNOT_CONVERT_INT = "정수로 변환할 수 없습니다."
        const val NEGATIVE_ERROR = "음수는 입력할 수 없습니다."

        fun of(
            inputPayment: String,
            manualLotto: List<LottoNumberSet>
        ): InputLottoMachineRequestDto {
            val payment = convertToCount(inputPayment)
            checkNegative(payment)

            return InputLottoMachineRequestDto(payment, manualLotto)
        }

        fun convertToCount(value: String): Int {
            val convertValue = value.toIntOrNull() ?: throw IllegalArgumentException(CANNOT_CONVERT_INT)
            checkNegative(convertValue)
            return convertValue
        }

        private fun checkNegative(number: Int) {
            if (number < 0) throw IllegalArgumentException(NEGATIVE_ERROR)
        }
    }
}
