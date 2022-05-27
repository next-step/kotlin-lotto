package stringcalculator

class PositiveNumber(
    private val number: String
) {

    init {
        checkIsNegative(number)
    }

    private fun checkIsNegative(number: String) {
        if (number.toInt() < 0) {
            throw RuntimeException("입력하신 숫자 중 음수가 존재합니다.")
        }
    }

    fun value() = number.toInt()
}
