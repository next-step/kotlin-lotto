package stringsumcalculator

private val NUMBER_REGEX = Regex("^[0-9]+$")

data class StringNumber(private val value: String) : INumber {
    init {
        if (value.matches(NUMBER_REGEX).not()) {
            throw RuntimeException()
        }
    }

    override fun toInt(): Int {
        return value.toInt()
    }

    companion object {
        val ZERO = StringNumber("0")
    }
}
