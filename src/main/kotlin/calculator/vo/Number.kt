package calculator.vo

data class Number(private val value: Int) {

    init {
        require(0 <= value) { IllegalArgumentException::class }
    }

    operator fun plus(other: Number) = Number(value + other.value)

    companion object {

        fun fromString(stringNumber: String): Number {
            validate(stringNumber)
            return Number(stringNumber.toInt())
        }

        private fun validate(value: String) {
            if (value.isEmpty() || value.isBlank()) {
                throw IllegalArgumentException()
            }

            if (!value.matches(NUMBER_REGX)) {
                throw IllegalArgumentException()
            }
        }

        private val NUMBER_REGX = "\\d+".toRegex()
    }
}
