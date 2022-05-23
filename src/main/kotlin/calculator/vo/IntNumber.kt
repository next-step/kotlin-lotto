package calculator.vo

data class IntNumber(private val value: Int) {

    init {
        require(0 <= value) { IllegalArgumentException::class }
    }

    operator fun plus(other: IntNumber) = IntNumber(value + other.value)

    companion object {

        fun fromString(stringNumber: String): IntNumber {
            validate(stringNumber)
            return IntNumber(stringNumber.toInt())
        }

        private fun validate(value: String) {
            if (value.isEmpty() || value.isBlank()) {
                throw IllegalArgumentException(value)
            }

            if (!value.matches(NUMBER_REGX)) {
                throw IllegalArgumentException(value)
            }
        }

        private val NUMBER_REGX = "\\d+".toRegex()
    }
}
