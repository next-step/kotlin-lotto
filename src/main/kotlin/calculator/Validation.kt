package calculator

object Validation {
    private const val TEXT_MINUS_MESSAGE = "음수를 입력할 수 없습니다."

    fun validate(numbers: List<Int>) {
        require(!numbers.any{number -> number < 0}) { TEXT_MINUS_MESSAGE }
    }
}
