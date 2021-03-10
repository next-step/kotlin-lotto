package calculator.domain

class Number (string: String){
    var value: Int = 0
        private set

    init {
        checkValidateNumber(string)
        checkNegativeNumber(string)
        value = string.toInt()
    }

    private fun checkValidateNumber(stringNumber: String) {
        stringNumber.toIntOrNull() ?: throw RuntimeException("$stringNumber 은 올바른 숫자가 아닙니다.")
    }

    private fun checkNegativeNumber(stringNumber: String) {
        if (stringNumber.toInt() < 0) throw RuntimeException("음수는 계산식에 포함될 수 없습니다.")
    }
}
