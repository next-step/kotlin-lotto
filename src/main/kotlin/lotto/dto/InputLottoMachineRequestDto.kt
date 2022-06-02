package lotto.dto

import lotto.domin.LottoNumberSet

data class InputLottoMachineRequestDto(
    val payment: Int,
    val manualLottoCount: Int,
    val manualLotto: List<LottoNumberSet>,
) {

    companion object {

        const val CANNOT_CONVERT_INT = "정수로 변환할 수 없습니다."
        const val NEGATIVE_ERROR = "음수는 입력할 수 없습니다."

        fun of(inputPayment: String, inputManualLottoCount: String, manualLotto: List<LottoNumberSet>): InputLottoMachineRequestDto {
            val payment: Int = inputPayment.toIntOrNull() ?: throw IllegalArgumentException(CANNOT_CONVERT_INT)
            checkNegative(payment)
            val manualLottoCount: Int = inputManualLottoCount.toIntOrNull() ?: throw IllegalArgumentException(CANNOT_CONVERT_INT)
            checkNegative(manualLottoCount)

            return InputLottoMachineRequestDto(payment, manualLottoCount, manualLotto)
        }

        fun convertToCount(inputManualLottoCount: String): Int {
            val manualLottoCount: Int = inputManualLottoCount.toIntOrNull() ?: throw IllegalArgumentException(CANNOT_CONVERT_INT)
            checkNegative(manualLottoCount)
            return manualLottoCount
        }

        private fun checkNegative(number: Int) {
            if (number < 0) throw IllegalArgumentException(NEGATIVE_ERROR)
        }
    }
}
