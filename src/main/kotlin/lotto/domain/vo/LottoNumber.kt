package lotto.domain.vo

@JvmInline
value class LottoNumber(val number: Int) : Comparable<LottoNumber> {
    init {
        require(number in MIN_VALUE..MAX_VALUE) { "lotto number should be between $MIN_VALUE and $MAX_VALUE" }
    }

    companion object {
        private const val MIN_VALUE = 1
        private const val MAX_VALUE = 45
    }

    override fun compareTo(other: LottoNumber): Int {
        return when {
            this.number > other.number -> 1
            this.number < other.number -> -1
            else -> 0
        }
    }
}
