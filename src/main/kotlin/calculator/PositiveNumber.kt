package calculator

class PositiveNumber(number: String) {
    private var positiveNumber = 0

    init {
        require(number.chars().allMatch(Character::isDigit)) { throw RuntimeException("입력한 문자열이 숫자가 아닙니다.") }
        require(number.toInt() >= ZERO_NUMBER) { throw RuntimeException("음수는 입력이 불가능 합니다.") }

        positiveNumber = number.toInt()
    }

    fun add(addNumber: Int): Int {
        return positiveNumber.plus(addNumber)
    }

    companion object {
        private const val ZERO_NUMBER = 0
    }
}
