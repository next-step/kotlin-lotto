package calculator.model

enum class CalculatorErrorCode(val message: (String) -> String) {
    INVALID_POSITIVE_NUMBERS(
        message = { input -> "양수를 입력해야 합니다. 입력값 : $input" },
    ),
    INVALID_NUMBERS(
        message = { input -> "숫자를 입력하거나 ${Int.MAX_VALUE}보다 작아야 합니다. 입력값 : $input" },
    ),
}
