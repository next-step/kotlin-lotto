package lotto.domain

class Number(string: String) {
    private val number = string.toInt()

    init {
        checkMinusAndZero()
    }

    private fun checkMinusAndZero() {
        if (number <= 0) {
            throw RuntimeException("0보다 작은값은 입력하면 안됩니다.")
        }
    }
}