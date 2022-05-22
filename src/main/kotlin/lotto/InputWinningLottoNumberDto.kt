package lotto

class InputWinningLottoNumberDto(
    val lasWeekWinningNumber: List<Number>
) {

    companion object {

        fun convertInt(lasWeekWinningNumber: List<String>): InputWinningLottoNumberDto {
            val convertIntWinningNumber = lasWeekWinningNumber.map {
                it.toIntOrNull() ?: throw IllegalArgumentException(CANNOT_CONVERT_INT)
            }
            checkNegative(convertIntWinningNumber)
            return InputWinningLottoNumberDto(convertIntWinningNumber)
        }

        fun checkNegative(numberList: List<Int>) {
            numberList.forEach {
                if (it < 0) throw IllegalArgumentException(NEGATIVE_ERROR)
            }
        }

        const val CANNOT_CONVERT_INT = "정수로 변환할 수 업습니다."
        const val NEGATIVE_ERROR = "음수는 입력할 수 없습니다."
    }
}
