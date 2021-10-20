package calculator.exception

class InvalidExpressionException : RuntimeException(INPUT_VALIDATION_MESSAGE) {
    companion object {
        private const val INPUT_VALIDATION_MESSAGE = "입력한 식으로 계산을 할 수 없습니다. 다시 입력해주세요."
    }
}
