package stringcalculator.domain

class Token(stringValue: String, val value: Int = stringValue.toIntOrThrowsRuntimeException()) {
    init {
        if (isNegativeNumber(value)) {
            throw RuntimeException("음수는 토큰이 될 수 없습니다.")
        }
    }

    private fun isNegativeNumber(number: Int): Boolean = number < 0
}
