package lotto.domain

data class Number(val string: String?) {
    val number = changeInt(string)

    init {
        checkRange()
    }

    private fun changeInt(string: String?): Int {
        if (!string.isNullOrBlank()) {
            return checkInt(string)
        } else {
            throw NumberFormatException("공백값과 null값은 가질수 없습니다.")
        }
    }

    private fun checkInt(string: String): Int {
        try {
            return string.toInt()
        } catch (e: NumberFormatException) {
            throw NumberFormatException("숫자 이외의 값은 가질수 없습니다.")
        }
    }

    private fun checkRange() {
        if (number < MINIMUM || number > MAXIMUM) {
            throw NumberFormatException("1~45의 값만 가질수 있습니다.")
        }
    }

    companion object {
        private const val MINIMUM = 1
        private const val MAXIMUM = 45
    }
}
