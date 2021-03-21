package domain

data class LottoNumber(val value: Int) : Comparable<LottoNumber> {
    init {
        require(value in MIN..MAX)
    }

    companion object {
        const val MIN = 1
        const val MAX = 45
    }

    override fun compareTo(other: LottoNumber): Int {
        return value.compareTo(other.value)
    }
}
