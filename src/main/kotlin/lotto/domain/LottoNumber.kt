package lotto.domain

data class LottoNumber(private val value: Int) : Comparable<LottoNumber> {
    init {
        isValid(value)
    }

    override fun compareTo(other: LottoNumber): Int {
        return value.compareTo(other.value)
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LottoNumber) return false

        return value == other.value
    }

    override fun toString(): String {
        return value.toString()
    }

    private fun isValid(number: Int) {
        require(number in LOWER_LIMIT..UPPER_LIMIT)
    }


    companion object {
        const val LOWER_LIMIT = 1
        const val UPPER_LIMIT = 45
    }
}