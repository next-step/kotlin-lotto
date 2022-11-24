package stringcalculator.model

class PositiveNumbers(
    val value: List<PositiveNumber>
) {
    fun reduceAdd(): PositiveNumber {
        return value.reduce(PositiveNumber::add)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PositiveNumbers

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    companion object {
        fun of(strings: List<String>): PositiveNumbers {
            return PositiveNumbers(strings.map { PositiveNumber.of(it) })
        }
    }
}
