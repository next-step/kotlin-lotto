package domain.lotto

data class LottoNumber(val value: Int) : Comparable<LottoNumber> {
    init {
        require(value in RANGE)
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.value.compareTo(other.value)
    }

    companion object {
        val RANGE = 1..45

        val VALUES: List<LottoNumber> = RANGE.map { LottoNumber(it) }

        private val lottoNumbersByInteger: Map<Int, LottoNumber> = VALUES.associateBy { it.value }
        fun parse(value: Int): LottoNumber {
            return requireNotNull(lottoNumbersByInteger[value])
        }
    }
}
