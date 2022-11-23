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
        fun parsing(numberString: String) =
            try {
                val number = numberString.toInt()
                PositiveInteger(number)
            } catch (e: NumberFormatException) {
                throw ParsingException("숫자만 입력을 할 수 있습니다.")
            } catch (e: IllegalArgumentException) {
                throw ParsingException("0과 같거나 큰 숫자만 가능합니다")
            }
    }
}
