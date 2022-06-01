package calculator.vo

data class IntNumber(private val value: Int) {

    init {
        require(0 <= value)
    }

    operator fun plus(other: IntNumber) = IntNumber(value + other.value)

    companion object {

        fun fromString(stringNumber: String): IntNumber {
            validate(stringNumber)
            return IntNumber(convertToInt(stringNumber))
        }

        private fun convertToInt(value: String): Int = if (value.isEmpty()) 0 else value.toInt()

        private fun validate(value: String) {
            require(value.matches(NUMBER_REGX)) {
                "숫자 형식의 값을 입력해주세요. : $value"
            }
        }

        private val NUMBER_REGX = "\\d+".toRegex()
    }
}
