package expressioncalculator

object IntValidator {
    private const val MESSAGE_NOT_NUMBER_EXCEPTION = "숫자와 구분자 이외의 값은 입력될 수 없습니다."
    private const val MESSAGE_NEGATIVE_NUMBER_EXCEPTION = "0 이상의 숫자가 입력되어야 합니다."

    fun validate(number: Int?) = number
        .requireNotNull()
        .requirePositiveNumber()

    private fun Int?.requireNotNull(): Int {
        if (this == null) throw RuntimeException(MESSAGE_NOT_NUMBER_EXCEPTION)

        return this
    }

    private fun Int.requirePositiveNumber(): Int {
        if (this < 0) throw RuntimeException(MESSAGE_NEGATIVE_NUMBER_EXCEPTION)

        return this
    }
}
