package lotto.dto

class InputLottoNumberDto(
    val lasWeekWinningNumber: List<Int>,
    val bonusNumber: Int,
) {

    companion object {

        const val CANNOT_CONVERT_INT = "정수로 변환할 수 업습니다."
        const val NEGATIVE_ERROR = "음수는 입력할 수 없습니다."
        const val CANNOT_DUPLICATION = "로또 번호는 중복될 수 없습니다."

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

        fun convertToLottoNumber(inputLottoNumber: List<String>): List<Int> {
            val convertToLottoNumber = inputLottoNumber.map {
                it.toIntOrNull() ?: throw IllegalArgumentException(CANNOT_CONVERT_INT)
            }
            checkNegative(convertToLottoNumber)
            require(convertToLottoNumber.toSet().size == convertToLottoNumber.size) { CANNOT_DUPLICATION }
            return convertToLottoNumber
        }

        private fun checkNegative(number: Int) {
            if (number < 0) throw IllegalArgumentException(NEGATIVE_ERROR)
        }

        private fun checkNegative(numberList: List<Int>) {
            numberList.forEach {
                if (it < 0) throw IllegalArgumentException(NEGATIVE_ERROR)
            }
        }
    }
}
