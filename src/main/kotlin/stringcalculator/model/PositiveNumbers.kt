package stringcalculator.model

data class PositiveNumbers(
    val value: List<PositiveNumber>
) {
    fun reduceAdd(): PositiveNumber {
        return value.reduce(PositiveNumber::add)
    }

    companion object {
        fun of(strings: List<String>): PositiveNumbers {
            return PositiveNumbers(strings.map { PositiveNumber.of(it) })
        }
    }
}
