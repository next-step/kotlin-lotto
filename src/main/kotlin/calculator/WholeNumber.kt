package calculator

@JvmInline
value class WholeNumber(val value: Int) {

    init {
        require(value >= MIN_VALUE) { "wholeNumber must be greater than or equal to $MIN_VALUE. but provided value(`$value`)" }
    }

    operator fun plus(other: WholeNumber): WholeNumber {
        return WholeNumber(value + other.value)
    }

    companion object {
        private const val MIN_VALUE: Int = 0

        operator fun invoke(value: String): WholeNumber {
            if (!value.matches(Regex("[0-9]+"))) {
                throw IllegalArgumentException("wholeNumber must be a number format. but provided value(`$value`)")
            }
            return WholeNumber(value.toInt())
        }

        val Collection<WholeNumber>.sum: WholeNumber
            get() {
                return fold(WholeNumber(0)) { first, second -> first + second }
            }
    }
}
