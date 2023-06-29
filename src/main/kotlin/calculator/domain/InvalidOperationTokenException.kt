package calculator.domain

class InvalidOperationTokenException(
    override val message: String? = "숫자 이외의 값은 입력할 수 없습니다."
) : IllegalArgumentException(message)
