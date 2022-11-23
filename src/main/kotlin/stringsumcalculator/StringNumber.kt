package stringsumcalculator

private val NUMBER_REGEX = Regex("^[0-9]+$")

class StringNumber(private val value: String) : Number {
    init {
        if (value.matches(NUMBER_REGEX).not()) {
            throw RuntimeException()
        }
    }

    override fun toInt(): Int {
        return value.toInt()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StringNumber

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    companion object {
        val ZERO = StringNumber("0")
    }
}
