package lotto.domain

class Number(string: String) {
    private val number = string.toInt()

    init {
        checkMinus()
    }

    private fun checkMinus() {
        if (number < 0) {
            throw RuntimeException("음수 값은 입력하면 안됩니다.")
        }
    }
}