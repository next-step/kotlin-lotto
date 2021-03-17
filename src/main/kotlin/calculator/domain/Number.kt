package calculator.domain

class Number(val value: Int) {
    constructor(stringNumber: String) : this(stringNumber.toIntOrNull() ?: throw RuntimeException("$stringNumber 은 올바른 숫자가 아닙니"))

    init {
        checkNegativeNumber(value)
    }

    private fun checkNegativeNumber(number: Int) {
        if (number < 0) throw RuntimeException("음수는 계산식에 포함될 수 없습니다.")
    }
}
