package calculator.model

@JvmInline
value class Number private constructor(
    val number: Int
) {

    companion object {
        private val POSITIVE_NUMBER_REGEX = "^\\d+$".toRegex()

        fun from(number: String): Number {
            validateNumber(number)

            return Number(number.toInt())
        }

        private fun validateNumber(number: String) {
            require(POSITIVE_NUMBER_REGEX.matches(number)) { "0 이상의 숫자로만 생성이 가능합니다. (number: $number)" }
        }
    }
}
