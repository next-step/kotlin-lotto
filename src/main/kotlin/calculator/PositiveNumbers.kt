package calculator

data class PositiveNumbers(val positiveNumbers: List<PositiveNumber>) {
    fun sum(): Long {
        return positiveNumbers.sumOf(PositiveNumber::value)
    }

    companion object {
        fun fromStrings(strings: List<String>): PositiveNumbers {
            return strings.map { v -> PositiveNumber.fromString(v) }
                .run { PositiveNumbers(this) }
        }
    }
}
