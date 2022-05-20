package calculator.model

@JvmInline
value class Number(
    private val number: Int
) {

    companion object {
        private const val MIN_NUMBER = 0

        fun from(number: Int): Number {
            validateMinNumber(number)

            return Number(number)
        }

        private fun validateMinNumber(number: Int) {
            require(number >= MIN_NUMBER) { "숫자는 최소 $MIN_NUMBER 이상이어야 합니다." }
        }
    }
}
