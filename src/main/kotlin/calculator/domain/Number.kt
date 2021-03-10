package calculator.domain

class Number(val value: Int) {
    constructor(stringNumber: String) : this(stringNumber.toInt()) {
        checkValidateNumber(stringNumber)
        checkNegativeNumber(stringNumber)
    }

    private fun checkValidateNumber(stringNumber: String) {
        stringNumber.toIntOrNull() ?: throw RuntimeException("$stringNumber 은 올바른 숫자가 아닙니다.")
    }

    private fun checkNegativeNumber(stringNumber: String) {
        if (stringNumber.toInt() < 0) throw RuntimeException("음수는 계산식에 포함될 수 없습니다.")
    }
}
