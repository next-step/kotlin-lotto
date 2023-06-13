package string.add.calculator

enum class ErrorMessage(
    val message: String
) {
    NON_NUMERIC_VALUE_WAS_PASSED("숫자 이외의 값이 전달되었습니다."),
    NEGATIVE_NUMBER_PASSED("음수가 전달되었습니다.")
}
