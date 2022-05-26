package lotto.dto

class InputLottoNumberDto(
    val lasWeekWinningNumber: List<Int>,
    val bonusNumber: Int,
) {

    companion object {

        fun of(
            lastWeekWinningNumber: List<String>,
            bonusNumber: String,
        ): InputLottoNumberDto {
            val convertIntWinningNumber = lastWeekWinningNumber.map {
                it.toIntOrNull() ?: throw IllegalArgumentException(CANNOT_CONVERT_INT)
            }
            val convertIntBonusNumber = bonusNumber.toIntOrNull() ?: throw IllegalArgumentException(CANNOT_CONVERT_INT)
            checkNegative(convertIntWinningNumber)
            checkNegative(convertIntBonusNumber)
            return InputLottoNumberDto(convertIntWinningNumber, convertIntBonusNumber)
        }

        private fun checkNegative(number: Int) {
            if (number < 0) throw IllegalArgumentException(NEGATIVE_ERROR)
        }

        private fun checkNegative(numberList: List<Int>) {
            numberList.forEach {
                if (it < 0) throw IllegalArgumentException(NEGATIVE_ERROR)
            }
        }

        const val CANNOT_CONVERT_INT = "정수로 변환할 수 업습니다."
        const val NEGATIVE_ERROR = "음수는 입력할 수 없습니다."
    }
}
