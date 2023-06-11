package calculator

enum class CalculatorErrorCode(val message: (String) -> String) {
    INVALID_POSITIVE_NUMBERS(
        message = { input -> "양수를 입력해야 합니다. 입력값 : $input" },
    ),
    INVALID_NUMBERS(
        message = { input -> "숫자를 입력해야 합니다. 입력값 : $input" },
    ),
}
