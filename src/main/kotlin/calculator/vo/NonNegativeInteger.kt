package calculator.vo

@JvmInline
value class NonNegativeInteger(
    val value: Int,
) {
    init {
        require(value >= 0)
    }

    operator fun plus(other: NonNegativeInteger): NonNegativeInteger {
        return NonNegativeInteger(this.value + other.value)
    }

    companion object {
        fun from(token: String): NonNegativeInteger {
            val parsedToken = token.toIntOrNull()
                ?: throw RuntimeException()

            return NonNegativeInteger(parsedToken)
        }
    }
}
