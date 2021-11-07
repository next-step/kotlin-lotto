package domain.lotto.error

object InputDataNullPointerException : RuntimeException() {
    private const val INPUT_DATA_NULL_POINTER_EXCEPTION_MESSAGE = "입력된 값이 null 입니다."

    override val message: String = INPUT_DATA_NULL_POINTER_EXCEPTION_MESSAGE
}