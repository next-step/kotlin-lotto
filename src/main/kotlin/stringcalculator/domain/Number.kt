package stringcalculator.domain

data class Number(private val value: Int) {
    init {
        require(value >= 0) { "Negative numbers are not allowed: $value" }
    }

    fun getValue(): Int = value

    companion object {
        fun from(value: String): Number {
            val number = value.toIntOrNull() ?: throw RuntimeException("Invalid number: $value")
            return Number(number)
        }
    }
}
