package addcalculator.domain

class StringValue(private val value: String?) {
    var number: Int = ZERO
        private set

    init {
        validateNullAndEmpty()
    }

    private fun validateNullAndEmpty() {
        if (value.isNullOrBlank()) {
            number = ZERO
            return
        }
        validateParseInt()
        validatePositiveNumber()
    }

    private fun validateParseInt() {
        number = value?.toInt() ?: throw IllegalArgumentException("정수로 변경할 수 없는 문자열입니다.")
    }

    private fun validatePositiveNumber() {
        if (number < ZERO) {
            throw IllegalArgumentException("양수만 입력이 가능합니다.")
        }
    }

    companion object {
        private const val ZERO = 0
    }
}
