package calculator

class PositiveNumber() {
    private var positiveNumber = 0

    constructor(number: String) : this() {
        validatePositiveNumber(number)
        positiveNumber = number.toInt()
    }

    fun add(addNumber: Int): Int {
        return positiveNumber.plus(addNumber)
    }

    private fun validatePositiveNumber(splitNumbers: String) {
        validateNumberIsDigit(splitNumbers)
        minusNumberCheck(splitNumbers)
    }

    private fun validateNumberIsDigit(splitNumbers: String) {
        if (!splitNumbers.chars().allMatch(Character::isDigit)) {
            throw RuntimeException("입력한 문자열이 숫자가 아닙니다.")
        }
    }

    private fun minusNumberCheck(splitNumbers: String) {
        if (splitNumbers.toInt() < ZERO_NUMBER) {
            throw RuntimeException("음수는 입력이 불가능 합니다.")
        }
    }

    companion object {
        private const val ZERO_NUMBER = 0
    }
}
