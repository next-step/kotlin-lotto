package stringcalculator

class PositiveNumber(
    private val number: String
) {

    init {
        require(number.toInt() >= ZERO) {
            "입력하신 숫자 중 음수가 존재합니다."
        }
    }

    companion object {
        private const val ZERO = 0
    }

    fun value(): Int = number.toInt()
}
