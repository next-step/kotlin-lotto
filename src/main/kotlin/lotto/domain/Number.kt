package lotto.domain

class Number(string: String?) {
    private val number = changeInt(string)

    init {
        checkMinusAndZero()
    }

    private fun changeInt(string: String?): Int {
        if (!string.isNullOrBlank()) {
            return string.toInt()
        } else {
            throw NumberFormatException("공백값과 null값은 가질수 없습니다.")
        }
    }

    private fun checkMinusAndZero() {
        if (number <= 0) {
            throw NumberFormatException("0보다 작은값은 가질수 없습니다.")
        }
    }
}
