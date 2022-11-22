package stringcalculator.model

class PositiveNumbers(
    private val numbers: List<PositiveNumber>
) {
    fun reduceAdd(): PositiveNumber {
        return numbers.reduce(PositiveNumber::add)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PositiveNumbers

        if (numbers != other.numbers) return false

        return true
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }

    companion object {
        fun of(strings: List<String>): PositiveNumbers {
            return PositiveNumbers(strings.map { PositiveNumber.of(it) })
        }
    }
}
