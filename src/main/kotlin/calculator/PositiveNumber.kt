package calculator


class PositiveNumber(
    token: String
) {
    private val number: Int

    init {
        val intValue = token.toIntOrNull()
        requireNotNull(intValue) { "숫자를 입력하세요" }
        require(intValue >= 0) { "0보다 큰 양수를 입력하세요" }
        number = intValue
  }
}