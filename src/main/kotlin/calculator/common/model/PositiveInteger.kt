package calculator.common.model

import calculator.application.parser.impl.ParsingException

@JvmInline
value class PositiveInteger(
    val value: Int
) {
    init {
        require(value >= 0) { "양의 정수는 0과 같거나 커야합니다." }
    }

    companion object {
        fun parse(numberString: String) =
            try {
                validateNumber(numberString)
                PositiveInteger(numberString.toInt())
            } catch (e: NumberFormatException) {
                throw ParsingException("숫자만 입력을 할 수 있습니다.")
            } catch (e: IllegalArgumentException) {
                throw ParsingException("0과 같거나 큰 숫자만 가능합니다")
            }

        private fun validateNumber(number: String) =
            require(POSITIVE_NUMBER_REGEX.matches(number)) { "양의 정수는 0과 같거나 커야합니다." }

        private val POSITIVE_NUMBER_REGEX = "^\\d+$".toRegex()
    }
}
